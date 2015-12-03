package orcamento.controller;

import orcamento.bean.ProdutoBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<ProdutoBean> listProduto(){
		return new ArrayList<ProdutoBean>();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Boolean postProduto(@RequestBody ProdutoBean produtoBean){
		return false;
	}
	
}
