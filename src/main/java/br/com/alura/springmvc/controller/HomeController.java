package br.com.alura.springmvc.controller;

import br.com.alura.springmvc.model.Pedido;
import br.com.alura.springmvc.model.StatusPedido;
import br.com.alura.springmvc.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private PedidoRepository Pedidorepository;

    @GetMapping()
    public ModelAndView home(){
        List<Pedido> pedidos = Pedidorepository.findAll();

        ModelAndView mv = new ModelAndView();
        mv.addObject("pedidos", pedidos);

        return mv;
    }

    @GetMapping("/{status}")
    public String porStatus(@PathVariable("status") String status, Model model){
        List<Pedido> pedidos = Pedidorepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);

        return "home";
    }
    @ExceptionHandler(IllegalArgumentException.class)
        public String onError(){
        return"redirect:/home";
    }
}
