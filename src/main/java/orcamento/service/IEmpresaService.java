package orcamento.service;

import orcamento.bean.EmpresaBean;

import java.util.ArrayList;

/**
 * Created by mgustavo on 03/12/15.
 */
public interface IEmpresaService {


    ArrayList<EmpresaBean> listEmpresas();

    EmpresaBean getEmpresa(String chavePrimaria);

    Boolean createEmpresa(EmpresaBean empresaBean);

    EmpresaBean updateEmpresa(EmpresaBean empresaBean);

    Boolean deleteEmpresa(String chavePrimaria);

}
