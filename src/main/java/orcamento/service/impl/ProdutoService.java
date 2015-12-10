package orcamento.service.impl;

import orcamento.bean.ProdutoBean;
import orcamento.dao.ProdutosDAO;
import orcamento.service.IProdutosService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * Created by mgustavo on 03/12/15.
 */
@Service
public class ProdutoService implements IProdutosService {

    @Override
    public ArrayList<ProdutoBean> listProdutos() {
        ProdutosDAO produtosDAO = new ProdutosDAO();
        return produtosDAO.listProdutos();
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
        ProdutosDAO produtosDAO = new ProdutosDAO();
        produtosDAO.createProduto(produtoBean);
        return true;
    }

    @Override
    public Boolean updateProduto(ProdutoBean produtoBean) {
        return true;
    }

    @Override
    public Boolean deleteProduto(String codigo) {
        ProdutosDAO produtosDAO = new ProdutosDAO();
        produtosDAO.deleteProduto(codigo);
        return true;
    }
}
