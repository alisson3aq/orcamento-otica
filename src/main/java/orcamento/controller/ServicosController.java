package orcamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/servicos")
public class ServicosController {

	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Boolean getUsuarios(){	
		return false;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Boolean postUsuarios(){	
		return false;
	}
	
}
