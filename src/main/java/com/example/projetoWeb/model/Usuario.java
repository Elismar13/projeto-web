package com.example.projetoWeb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "O nome é obrigatório.")
    @Size(message = "O nome deve ter pelo menos 3 caracteres.")
    private String nome;

    @Column(unique = true, nullable = false)
    @NotNull(message = "O email é obrigatório.")
    @Email(message = "formato de email inválido.")
    private String email;

    @Column(nullable = false)
    private String senha;


}
