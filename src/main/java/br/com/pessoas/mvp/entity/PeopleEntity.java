package br.com.pessoas.mvp.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Data
@Builder
@Entity
@Table(name = "People")
public class PeopleEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    public Long id;
    public String name;
    public int age;
    public String cpf;
    @OneToMany(mappedBy = "peopleEntity")
    public List<ContactEntity> contactEntityList;
}
