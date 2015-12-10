package orcamento.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by mgustavo on 03/12/15.
 */
@Entity
public class ServicoBean {
    @Id
    @Column(unique = true,nullable = false)
    private String codigo;
    @Column(nullable = false)
    private String descricao;
    private String unidade;
    private String Fornecedor;
    @Column(nullable = false,precision = 2)
    private BigDecimal valorUnitario;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        Fornecedor = fornecedor;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}
