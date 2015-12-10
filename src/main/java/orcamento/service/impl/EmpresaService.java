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
        EmpresaBean empresaBean = new EmpresaBean();
        empresaBean.setBairro("Nova empresa");
        empresaBean.setCep("130452-854");
        empresaBean.setCidade("São Paulo");
        empresaBean.setCnpj("145826-856");
        empresaBean.setEmail("contato@empresa.com.br");
        empresaBean.setNome("Ótica ver bem - ltda");
        empresaBean.setEndereco("Rua dos alecrins 258");
        empresaBean.setEstado("Paraná");
        empresaBean.setTelefone("(21) 32568-9856");
        return empresaBean;
    }

    @Override
    public Boolean createEmpresa(EmpresaBean empresaBean) {
        EmpresasDAO empresasDAO = new EmpresasDAO();
        empresasDAO.createEmpresa(empresaBean);
        return true;
    }

    @Override
    public EmpresaBean updateEmpresa(EmpresaBean empresaBean) {
        return empresaBean;
    }

    @Override
    public Boolean deleteEmpresa(String chavePrimaria) {
        return true;
    }
}
