package br.com.pessoas.mvp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PeopleResponseDto {
    private Long id;
    private String name;
    private int age;
    private String cpf;
}
