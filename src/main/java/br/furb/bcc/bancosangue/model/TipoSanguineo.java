package br.furb.bcc.bancosangue.model;

import javax.persistence.*;

@Entity
@Table(name = "tipo_sanguineo")
public class TipoSanguineo {
    @Id
    @GeneratedValue
    private Long id;

    private String tipo;

    @Column(name = "qtd_disponivel")
    private double qtdDisponivel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getQtdDisponivel() {
        return qtdDisponivel;
    }

    public void setQtdDisponivel(double qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }
}
