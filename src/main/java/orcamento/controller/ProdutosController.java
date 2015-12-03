package orcamento.controller;

import orcamento.bean.ProdutoBean;
import orcamento.service.impl.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {


	@Autowired
	ProdutoService produtoService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<ProdutoBean> listProduto(){
		return produtoService.listProdutos();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Boolean postProduto(@RequestBody ProdutoBean produtoBean){
		return produtoService.createProduto(produtoBean);
	}
	
}
