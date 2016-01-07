package orcamento.controller;

import orcamento.bean.MedicoBean;
import orcamento.service.impl.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@Controller
@RequestMapping("/medicos")
public class MedicosController {

	@Autowired
	MedicoService medicosService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<MedicoBean> listMedico(){
		return medicosService.listMedicos();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<MedicoBean> postMedico(@RequestBody MedicoBean medicoBean){
		medicosService.createMedico(medicoBean);
		return medicosService.listMedicos();
	}

	@RequestMapping(value = " /{cpf}",method = RequestMethod.DELETE)
	@ResponseBody
	public ArrayList<MedicoBean> deleteMedico(@PathVariable String cpf){
		medicosService.deleteMedico(cpf);
		return medicosService.listMedicos();
	}

}
