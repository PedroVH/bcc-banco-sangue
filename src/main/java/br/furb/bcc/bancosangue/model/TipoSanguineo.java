package br.furb.bcc.bancosangue.model;

import javax.persistence.*;

@Entity
@Table(name = "tipo_sanguineo")
public class TipoSanguineo {
    @Id
    @GeneratedValue
    private int id;

    private String tipo;

    @Column(name = "qtd_disponivel")
    private long qtdDisponivel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getQtdDisponivel() {
        return qtdDisponivel;
    }

    public void setQtdDisponivel(long qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }
}
