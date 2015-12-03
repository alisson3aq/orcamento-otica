package orcamento.service;

import orcamento.bean.ClienteBean;

import java.util.ArrayList;

/**
 * Created by mgustavo on 03/12/15.
 */
public interface IClientesService {

    ArrayList<ClienteBean> listOrcamento();

    ClienteBean getEmpresa(String chavePrimaria);

    Boolean createEmpresa(ClienteBean clienteBean);

    Boolean updateEmpresa(ClienteBean clienteBean);

    Boolean deleteEmpresa(String chavePrimaria);
    
}
