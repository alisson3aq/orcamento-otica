package orcamento.controller;

import orcamento.bean.ServicoBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;

@Controller
@RequestMapping("/servicos")
public class ServicosController {

	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<ServicoBean> listServicos(){
		return new ArrayList<ServicoBean>();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Boolean postServicos(@RequestBody ServicoBean servicoBean){
		return false;
	}
	
}
