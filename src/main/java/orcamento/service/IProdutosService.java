package orcamento.service;

import orcamento.bean.ProdutoBean;

import java.util.ArrayList;

/**
 * Created by mgustavo on 03/12/15.
 */
public interface IProdutosService {
    
    ArrayList<ProdutoBean> listOrcamento();

    ProdutoBean getProduto(String chavePrimaria);

    Boolean createProduto(ProdutoBean produtoBean);

    Boolean updateProduto(ProdutoBean produtoBean);

    Boolean deleteProduto(String chavePrimaria);
    
}
