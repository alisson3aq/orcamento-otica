package orcamento.service;

import orcamento.bean.MedicoBean;

import java.util.ArrayList;

/**
 * Created by mgustavo on 03/12/15.
 */
public interface IMedicosService {

    ArrayList<MedicoBean> listMedicos();

    MedicoBean getMedico(String chavePrimaria);

    Boolean createMedico(MedicoBean medicoBean);

    Boolean updateMedico(MedicoBean medicoBean);

    Boolean deleteMedico(String chavePrimaria);
    
}
