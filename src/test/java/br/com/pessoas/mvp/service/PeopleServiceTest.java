package br.com.pessoas.mvp.service;

import br.com.pessoas.mvp.dto.PeopleDTO;
import br.com.pessoas.mvp.dto.PeopleResponseDto;
import br.com.pessoas.mvp.repository.PeopleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.pessoas.mvp.entity.PeopleEntity.builder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PeopleServiceTest {

    public static final String CPF = "34543534";
    public static final int AGE = 30;
    public static final String NAME = "Mai";
    public static final long ID = 324L;

    @InjectMocks
    private PeopleService peopleService;

    @Mock
    private PeopleRepository peopleRepository;

    @Test
    public void savePeople() {
        when(peopleRepository.save(any()))
            .thenReturn(builder().id(ID).name(NAME).age(AGE).cpf(CPF).build());

        final PeopleResponseDto peopleResponseDto = peopleService.savePeople(PeopleDTO.builder().name(NAME).age(AGE).cpf(CPF).build());

        assertEquals(ID, peopleResponseDto.getId());
        assertEquals(NAME, peopleResponseDto.getName());
        assertEquals(AGE, peopleResponseDto.getAge());
        assertEquals(CPF, peopleResponseDto.getCpf());
    }
}