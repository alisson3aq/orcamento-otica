package orcamento.service.impl;

import orcamento.bean.EmpresaBean;
import orcamento.dao.EmpresasDAO;
import orcamento.service.IEmpresaService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * Created by mgustavo on 03/12/15.
 */
@Service
public class EmpresaService implements IEmpresaService {

    @Override
    public ArrayList<EmpresaBean> listEmpresas() {
        EmpresasDAO empresasDAO = new EmpresasDAO();
        return empresasDAO.listEmpresas();
    }

    @Override
    public EmpresaBean getEmpresa(String chavePrimaria) {
        EmpresasDAO empresasDAO = new EmpresasDAO();
        return empresasDAO.listEmpresas().get(0);
    }

    @Override
    public Boolean createEmpresa(EmpresaBean empresaBean) {
        EmpresasDAO empresasDAO = new EmpresasDAO();
        empresasDAO.createEmpresa(empresaBean);
        return true;
    }

    @Override
    public EmpresaBean updateEmpresa(EmpresaBean empresaBean) {
        EmpresasDAO empresasDAO = new EmpresasDAO();
        //Se empresa não existir, cria.
        empresasDAO.updateEmpresa(empresaBean);
        return empresaBean;
    }

    @Override
    public Boolean deleteEmpresa(String chavePrimaria) {
        return true;
    }
}
