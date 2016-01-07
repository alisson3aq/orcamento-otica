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
        final MedicoBean medicoBean = new MedicoBean();
        medicoBean.setTelefone("(19)32856521");
        medicoBean.setEstado("Washington");
        medicoBean.setEndereco("Rua Gomes da Costa 885");
        medicoBean.setBairro("Parque Imperador");
        medicoBean.setCep("13529-965");
        medicoBean.setCidade("Campinas");
        medicoBean.setCpf("785002238-96");
        medicoBean.setEmail("reginaldo@gmail.com");
        medicoBean.setNome("Reginaldo Gomes");
        return medicoBean;
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
    public Boolean deleteMedico(String cpf) {
        MedicosDAO medicosDAO = new MedicosDAO();
        medicosDAO.deleteMedico(cpf);
        return true;
    }
}
