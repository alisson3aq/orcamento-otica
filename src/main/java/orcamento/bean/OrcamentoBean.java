package orcamento.bean;

import java.util.Date;

/**
 * Created by mgustavo on 03/12/15.
 */
public class OrcamentoBean {
    private String cliente_nome;
    private String cliente_cpf;
    private String cliente_endereco;
    private String cliente_bairro;
    private String cliente_cidade;
    private String cliente_estado;
    private String cliente_cep;
    private String cliente_telefone;
    private String cliente_email;
    private String codigo;
    private String descricao;
    private Double quantidade;
    private String unidade;
    private Double valorUnitario;
    private Double valorTotal;
    private Double valorTotalGeral;
    private Date data;
    private Integer prazoEntrega;

    public String getCliente_nome() {
        return cliente_nome;
    }

    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    public String getCliente_cpf() {
        return cliente_cpf;
    }

    public void setCliente_cpf(String cliente_cpf) {
        this.cliente_cpf = cliente_cpf;
    }

    public String getCliente_endereco() {
        return cliente_endereco;
    }

    public void setCliente_endereco(String cliente_endereco) {
        this.cliente_endereco = cliente_endereco;
    }

    public String getCliente_bairro() {
        return cliente_bairro;
    }

    public void setCliente_bairro(String cliente_bairro) {
        this.cliente_bairro = cliente_bairro;
    }

    public String getCliente_cidade() {
        return cliente_cidade;
    }

    public void setCliente_cidade(String cliente_cidade) {
        this.cliente_cidade = cliente_cidade;
    }

    public String getCliente_estado() {
        return cliente_estado;
    }

    public void setCliente_estado(String cliente_estado) {
        this.cliente_estado = cliente_estado;
    }

    public String getCliente_cep() {
        return cliente_cep;
    }

    public void setCliente_cep(String cliente_cep) {
        this.cliente_cep = cliente_cep;
    }

    public String getCliente_telefone() {
        return cliente_telefone;
    }

    public void setCliente_telefone(String cliente_telefone) {
        this.cliente_telefone = cliente_telefone;
    }

    public String getCliente_email() {
        return cliente_email;
    }

    public void setCliente_email(String cliente_email) {
        this.cliente_email = cliente_email;
    }

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

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorTotalGeral() {
        return valorTotalGeral;
    }

    public void setValorTotalGeral(Double valorTotalGeral) {
        this.valorTotalGeral = valorTotalGeral;
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
