package orcamento.service.impl;

import orcamento.bean.EmpresaBean;
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
        ArrayList<EmpresaBean> empresaBeans = new ArrayList<EmpresaBean>();

        EmpresaBean empresaBean = new EmpresaBean();
        empresaBean.setBairro("Nova Veneza");
        empresaBean.setCep("130452-854");
        empresaBean.setCidade("São Paulo");
        empresaBean.setCnpj("145826-856");
        empresaBean.setEmail("contato@empresa.com.br");
        empresaBean.setEmpresa("Ótica ver bem - ltda");
        empresaBean.setEndereco("Rua dos alecrins 258");
        empresaBean.setEstado("Paraná");
        empresaBean.setTelefone("(21) 32568-9856");

        EmpresaBean empresaBean1 = new EmpresaBean();
        empresaBean1.setBairro("Jardim Empresarial");
        empresaBean1.setCep("130784-454");
        empresaBean1.setCidade("Rio de Janeiro");
        empresaBean1.setCnpj("145826-844");
        empresaBean1.setEmail("contato@empresa.com.br");
        empresaBean1.setEmpresa("Casa da Visão óticas - ltda");
        empresaBean1.setEndereco("Avenida do Ipiranga 854");
        empresaBean1.setEstado("São Paulo");
        empresaBean1.setTelefone("(21) 99562-7458");

        return empresaBeans;
    }

    @Override
    public EmpresaBean getEmpresa(String chavePrimaria) {
        EmpresaBean empresaBean = new EmpresaBean();
        empresaBean.setBairro("Nova empresa");
        empresaBean.setCep("130452-854");
        empresaBean.setCidade("São Paulo");
        empresaBean.setCnpj("145826-856");
        empresaBean.setEmail("contato@empresa.com.br");
        empresaBean.setEmpresa("Ótica ver bem - ltda");
        empresaBean.setEndereco("Rua dos alecrins 258");
        empresaBean.setEstado("Paraná");
        empresaBean.setTelefone("(21) 32568-9856");
        return empresaBean;
    }

    @Override
    public Boolean createEmpresa(EmpresaBean empresaBean) {
        return true;
    }

    @Override
    public Boolean updateEmpresa(EmpresaBean empresaBean) {
        return true;
    }

    @Override
    public Boolean deleteEmpresa(String chavePrimaria) {
        return true;
    }
}
