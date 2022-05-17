package br.com.pessoas.mvp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro")
public class PessoaController {

    @GetMapping("/newPerson")
    public String newPerson() {
        return "";
    }
}
