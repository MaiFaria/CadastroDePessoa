package br.com.pessoas.mvp.service;

import br.com.pessoas.mvp.dto.PeopleDTO;
import br.com.pessoas.mvp.dto.PeopleResponseDto;
import br.com.pessoas.mvp.entity.PeopleEntity;
import br.com.pessoas.mvp.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    public PeopleResponseDto savePeople(PeopleDTO peopleDTO) {
        var people = peopleRepository.save(PeopleEntity.builder().name(peopleDTO.getName()).age(peopleDTO.getAge()).cpf(peopleDTO.getCpf()).build());
        return PeopleResponseDto.builder().id(people.id).name(people.name).age(people.age).cpf(people.cpf).build();
    }
}
