package br.com.fiap.gamestore.model;

//Entidade -> representa uma tabela no banco de dados

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "tb_game")
public class Game {

    @Id //PK
    @Column(name = "cd_game")
    @SequenceGenerator(name="seqGame", sequenceName = "seq_game", allocationSize = 1)
    @GeneratedValue(generator = "seqGame", strategy = GenerationType.SEQUENCE)
    private Long codigo;

    @Column(name = "nm_game")
    @NotBlank //NOT NULL
    @Size(min = 2, max = 100)
    private String nome;

    @Column(name="nr_nota")
    @DecimalMax(value = "10")
    @DecimalMin(value = "0")
    private Double nota;

    @Column(name = "nr_ano")
    private Integer ano;

    @Column(name="dt_compra")
    private LocalDate dataCompra;

    @Column(name="st_finalizado")
    private boolean finalizado;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
}
