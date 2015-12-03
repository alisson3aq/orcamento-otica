package orcamento.bean;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mgustavo on 03/12/15.
 */
public class OrcamentoBean {

    private ClienteBean cliente;
    private ArrayList<ProdutoBean> produtos;
    private ArrayList<ServicoBean> servicos;
    private Date data;
    private Integer prazoEntrega;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(Integer prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }
}
