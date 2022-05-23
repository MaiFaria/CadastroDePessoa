package br.com.pessoas.mvp.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class PeopleDTO {
    @NotBlank(message = "Nome não pode ser em branco.")
    private String name;
    @Min(value = 18, message = "Idade mínima permitida de 18 anos.")
    @Max(value = 100, message = "Idade máxima permitida de 100 anos.")
    private int age;
    @NotBlank(message = "CPF é obrigatório.")
    private String cpf;
}
