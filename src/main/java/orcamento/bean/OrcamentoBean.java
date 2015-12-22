package orcamento.bean;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mgustavo on 03/12/15.
 */
@Entity
public class OrcamentoBean {

    @Id
    private String codigo;
    //TODO: Transformar isso em objeto?
    private String validade;
    //TODO: enum?...
    private String status;
    private Date dataentrega;
    private Date dataorcamento;
    //TODO: Transformar isso em objeto, vendedor é um perfil do usuário?
    private String vendedor;
    @ManyToOne
    private ClienteBean cliente;
    @ElementCollection
    private ArrayList<ProdutoBean> produtos;
    @ElementCollection
    private ArrayList<ServicoBean> servicos;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public Date getDataentrega() {
        return dataentrega;
    }

    public void setDataentrega(Date dataentrega) {
        this.dataentrega = dataentrega;
    }

    public Date getDataorcamento() {
        return dataorcamento;
    }

    public void setDataorcamento(Date dataorcamento) {
        this.dataorcamento = dataorcamento;
    }

    public ClienteBean getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBean cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ProdutoBean> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<ProdutoBean> produtos) {
        this.produtos = produtos;
    }

    public ArrayList<ServicoBean> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<ServicoBean> servicos) {
        this.servicos = servicos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
