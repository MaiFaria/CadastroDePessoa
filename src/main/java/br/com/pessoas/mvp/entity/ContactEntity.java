package br.com.pessoas.mvp.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Data
@Builder
@Entity
@Table(name = "Contact")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    public Long id;
    public String number;
    public String email;
    @ManyToOne
    @JoinColumn(name="people_id")
    public PeopleEntity peopleEntity;
}
