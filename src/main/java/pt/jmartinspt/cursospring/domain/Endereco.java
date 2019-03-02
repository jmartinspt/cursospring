package pt.jmartinspt.cursospring.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String rua;
    private String numeroporta;
    private String andar;
    private String codpostal;
    private String localidade;

    @ManyToOne
    @JoinColumn(name="cidade_id")
    private Cidade cidade;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    public Endereco() {
    }

    public Endereco(Integer id, String rua, String numeroporta, String andar, String codpostal, String localidade, Cidade cidade, Cliente cliente) {
        this.rua = rua;
        this.numeroporta = numeroporta;
        this.andar = andar;
        this.codpostal = codpostal;
        this.localidade = localidade;
        this.cidade = cidade;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumeroporta() {
        return numeroporta;
    }

    public void setNumeroporta(String numeroporta) {
        this.numeroporta = numeroporta;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }


    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
