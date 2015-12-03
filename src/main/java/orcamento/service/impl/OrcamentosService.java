package orcamento.service.impl;

import orcamento.bean.ClienteBean;
import orcamento.bean.OrcamentoBean;
import orcamento.bean.ProdutoBean;
import orcamento.bean.ServicoBean;
import orcamento.service.IOrcamentosService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mgustavo on 03/12/15.
 */
@Service
public class OrcamentosService implements IOrcamentosService {

    @Override
    public ArrayList<OrcamentoBean> listOrcamentos() {

        ArrayList<OrcamentoBean> orcamentoBeans = new ArrayList<OrcamentoBean>();

        OrcamentoBean orcamentoBean = new OrcamentoBean();

        final ClienteBean clienteBean = new ClienteBean();
        clienteBean.setTelefone("(19)32856521");
        clienteBean.setEstado("Washington");
        clienteBean.setEndereco("Rua Gomes da Costa 885");
        clienteBean.setBairro("Parque Imperador");
        clienteBean.setCep("13529-965");
        clienteBean.setCidade("Campinas");
        clienteBean.setCpf("785002238-96");
        clienteBean.setEmail("reginaldo@gmail.com");
        clienteBean.setNome("Reginaldo Gomes");

        orcamentoBean.setData(new Date());
        orcamentoBean.setCliente(clienteBean);
        orcamentoBean.setPrazoEntrega(15);

        ArrayList<ProdutoBean> produtoBeans = new ArrayList<ProdutoBean>();

        ProdutoBean produtoBean = new ProdutoBean();
        produtoBean.setDescricao("Lente de contatos");
        produtoBean.setCodigo("0465");
        produtoBean.setFabricante("Mormai");
        produtoBean.setUnidade("un");
        produtoBean.setValorUnitario(19.99);

        ProdutoBean produtoBean1 = new ProdutoBean();
        produtoBean1.setDescricao("Oculos de sol");
        produtoBean1.setCodigo("0466");
        produtoBean1.setFabricante("Mormai");
        produtoBean1.setUnidade("un");
        produtoBean1.setValorUnitario(199.99);

        produtoBeans.add(produtoBean1);
        produtoBeans.add(produtoBean);

        orcamentoBean.setProdutos(produtoBeans);

        ArrayList<ServicoBean> servicoBeans = new ArrayList<ServicoBean>();

        ServicoBean servicoBean = new ServicoBean();
        servicoBean.setCodigo("0521");
        servicoBean.setDescricao("Limpeza de lentes");
        servicoBean.setFornecedor("In House");
        servicoBean.setUnidade("par");
        servicoBean.setValorUnitario(new BigDecimal(113.90));

        ServicoBean servicoBean1 = new ServicoBean();
        servicoBean1.setCodigo("0522");
        servicoBean1.setDescricao("Conserto de armação");
        servicoBean1.setFornecedor("In house");
        servicoBean1.setUnidade("un");
        servicoBean1.setValorUnitario(new BigDecimal(123.5));

        servicoBeans.add(servicoBean);
        servicoBeans.add(servicoBean1);


        orcamentoBean.setServicos(servicoBeans);

        orcamentoBeans.add(orcamentoBean);

        return orcamentoBeans;
    }

    @Override
    public OrcamentoBean getOrcamento(String chavePrimaria) {
        OrcamentoBean orcamentoBean = new OrcamentoBean();

        final ClienteBean clienteBean = new ClienteBean();
        clienteBean.setTelefone("(19)32856521");
        clienteBean.setEstado("Washington");
        clienteBean.setEndereco("Rua Gomes da Costa 885");
        clienteBean.setBairro("Parque Imperador");
        clienteBean.setCep("13529-965");
        clienteBean.setCidade("Campinas");
        clienteBean.setCpf("785002238-96");
        clienteBean.setEmail("reginaldo@gmail.com");
        clienteBean.setNome("Reginaldo Gomes");

        orcamentoBean.setData(new Date());
        orcamentoBean.setCliente(clienteBean);
        orcamentoBean.setPrazoEntrega(15);

        ArrayList<ProdutoBean> produtoBeans = new ArrayList<ProdutoBean>();

        ProdutoBean produtoBean = new ProdutoBean();
        produtoBean.setDescricao("Lente de contatos");
        produtoBean.setCodigo("0465");
        produtoBean.setFabricante("Mormai");
        produtoBean.setUnidade("un");
        produtoBean.setValorUnitario(19.99);

        ProdutoBean produtoBean1 = new ProdutoBean();
        produtoBean1.setDescricao("Oculos de sol");
        produtoBean1.setCodigo("0466");
        produtoBean1.setFabricante("Mormai");
        produtoBean1.setUnidade("un");
        produtoBean1.setValorUnitario(199.99);

        produtoBeans.add(produtoBean1);
        produtoBeans.add(produtoBean);

        orcamentoBean.setProdutos(produtoBeans);

        ArrayList<ServicoBean> servicoBeans = new ArrayList<ServicoBean>();

        ServicoBean servicoBean = new ServicoBean();
        servicoBean.setCodigo("0521");
        servicoBean.setDescricao("Limpeza de lentes");
        servicoBean.setFornecedor("In House");
        servicoBean.setUnidade("par");
        servicoBean.setValorUnitario(new BigDecimal(113.90));

        ServicoBean servicoBean1 = new ServicoBean();
        servicoBean1.setCodigo("0522");
        servicoBean1.setDescricao("Conserto de armação");
        servicoBean1.setFornecedor("In house");
        servicoBean1.setUnidade("un");
        servicoBean1.setValorUnitario(new BigDecimal(123.5));

        servicoBeans.add(servicoBean);
        servicoBeans.add(servicoBean1);


        orcamentoBean.setServicos(servicoBeans);
        return orcamentoBean;
    }

    @Override
    public Boolean createOrcamento(OrcamentoBean orcamentoBean) {
        return true;
    }

    @Override
    public Boolean updateOrcamento(OrcamentoBean orcamentoBean) {
        return true;
    }

    @Override
    public Boolean deleteOrcamento(String chavePrimaria) {
        return true;
    }
}
