package com.api.unipar.entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cliente")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cidade;
    @Column (name = "cep", length = 9, nullable = false) //está definindo que o atributo cep terá somente 9 caracteres e significa que ele deve ser obrigatório
    private String cep;
    @Column (length = 80)
    private String rua;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return this.rua +  " , " + this.cidade + " - " + this.cep;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
