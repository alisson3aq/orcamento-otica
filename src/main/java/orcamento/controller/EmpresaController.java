package orcamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Boolean getEmpresa(){	
		return false;
	}
	
}
