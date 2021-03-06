package orcamento.bean;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by mgustavo on 03/12/15.
 */
@Entity
public class OrcamentoBean {
    @Id
    @GeneratedValue
    private Long codigo;
    //TODO: Transformar isso em objeto?
    private String validade;
    /*    //TODO: enum?...
        private String status;*/
    private Date dataentrega;
    private Date dataorcamento;
    //TODO: Transformar isso em objeto, vendedor é um perfil do usuário?
    private String vendedor;
    private String formapagamento;
    private String comentario;
    @OneToOne
    private MedicoBean medico;
    @OneToOne
    private ClienteBean cliente;
    @OneToOne
    private EmpresaBean empresa;
    @Transient
    private Double valorTotal;


    @ElementCollection(fetch = FetchType.EAGER)
    private Collection<ItemBean> items;

    public Collection<ItemBean> getItems() {
        return items;
    }

    public void setItems(Collection<ItemBean> items) {
        this.items = items;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public ClienteBean getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBean cliente) {
        this.cliente = cliente;
    }

    public EmpresaBean getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaBean empresa) {
        this.empresa = empresa;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }

    public MedicoBean getMedico() {
        return medico;
    }

    public void setMedico(MedicoBean medico) {
        this.medico = medico;
    }
}


