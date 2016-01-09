package orcamento.service.impl;

import orcamento.bean.MedicoBean;
import orcamento.dao.MedicosDAO;
import orcamento.service.IMedicosService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * Created by mgustavo on 03/12/15.
 */
@Service
public class MedicoService implements IMedicosService {


    @Override
    public ArrayList<MedicoBean> listMedicos() {
        MedicosDAO medicosDAO = new MedicosDAO();
        return medicosDAO.listMedicos();
    }

    @Override
    public MedicoBean getMedico(String chavePrimaria) {
        return null;
    }

    @Override
    public Boolean createMedico(MedicoBean medicoBean) {
        MedicosDAO medicosDAO = new MedicosDAO();
        medicosDAO.createMedico(medicoBean);
        return true;
    }

    @Override
    public Boolean updateMedico(MedicoBean medicoBean) {
        return true;
    }

    @Override
    public Boolean deleteMedico(Long codigo) {
        MedicosDAO medicosDAO = new MedicosDAO();
        medicosDAO.deleteMedico(codigo);
        return true;
    }
}
