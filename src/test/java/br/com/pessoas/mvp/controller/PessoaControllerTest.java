package br.com.pessoas.mvp.controller;

import br.com.pessoas.mvp.dto.PeopleDTO;
import br.com.pessoas.mvp.dto.PeopleResponseDto;
import br.com.pessoas.mvp.service.PeopleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static br.com.pessoas.mvp.dto.PeopleResponseDto.builder;
import static br.com.pessoas.mvp.util.JsonUtils.convertToJson;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PessoaController.class)
public class PessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeopleService peopleService;

    @Test
    public void createPeople() throws Exception {
        final PeopleResponseDto peopleResponseDto = builder().id(234L).name("Mai").age(30).cpf("324235435").build();

        when(peopleService.savePeople(any()))
            .thenReturn(peopleResponseDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/cadastro/newPerson")
                .contentType(APPLICATION_JSON_VALUE)
                .content(convertToJson(PeopleDTO.builder().name("Japa").age(32).cpf("123134234").build()))
            ).andExpect(status().isCreated())
            .andExpect(content().json(convertToJson(peopleResponseDto)));
    }
}