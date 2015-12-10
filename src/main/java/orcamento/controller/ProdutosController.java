package orcamento.controller;

import orcamento.bean.ProdutoBean;
import orcamento.service.impl.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
	public ArrayList<ProdutoBean> postProduto(@RequestBody ProdutoBean produtoBean){
		produtoService.createProduto(produtoBean);
		return produtoService.listProdutos();
	}

	@RequestMapping(value = " /{codigo}",method = RequestMethod.DELETE)
	@ResponseBody
	public ArrayList<ProdutoBean> deleteUsuario(@PathVariable String codigo){
		produtoService.deleteProduto(codigo);
		return produtoService.listProdutos();
	}

}
