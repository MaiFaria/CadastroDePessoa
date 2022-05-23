package br.com.pessoas.mvp.controller;

import br.com.pessoas.mvp.dto.PeopleDTO;
import br.com.pessoas.mvp.dto.PeopleResponseDto;
import br.com.pessoas.mvp.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/cadastro")
public class PessoaController {

    @Autowired
    private PeopleService peopleService;

    @PostMapping("/newPerson")
    public ResponseEntity<PeopleResponseDto> createPeople(@Valid @RequestBody PeopleDTO peopleDTO) {
        return new ResponseEntity<>(peopleService.savePeople(peopleDTO), CREATED);
    }
}
