package orcamento.service.impl;

import orcamento.bean.ProdutoBean;
import orcamento.service.IProdutosService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by mgustavo on 03/12/15.
 */
@Service
public class ProdutoService implements IProdutosService {

    @Override
    public ArrayList<ProdutoBean> listProdutos() {

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

        return produtoBeans;
    }

    @Override
    public ProdutoBean getProduto(String chavePrimaria) {
        ProdutoBean produtoBean = new ProdutoBean();
        produtoBean.setDescricao("Lente de contatos");
        produtoBean.setCodigo("0465");
        produtoBean.setFabricante("Mormai");
        produtoBean.setUnidade("un");
        produtoBean.setValorUnitario(19.99);
        return produtoBean;
    }

    @Override
    public Boolean createProduto(ProdutoBean produtoBean) {
        return true;
    }

    @Override
    public Boolean updateProduto(ProdutoBean produtoBean) {
        return true;
    }

    @Override
    public Boolean deleteProduto(String chavePrimaria) {
        return true;
    }
}
