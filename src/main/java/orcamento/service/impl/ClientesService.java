package orcamento.service.impl;

import orcamento.bean.ClienteBean;
import orcamento.service.IClientesService;

import java.util.ArrayList;

/**
 * Created by mgustavo on 03/12/15.
 */
public class ClientesService implements IClientesService {

    @Override
    public ArrayList<ClienteBean> listOrcamento() {
        return null;
    }

    @Override
    public ClienteBean getEmpresa(String chavePrimaria) {
        return null;
    }

    @Override
    public Boolean createEmpresa(ClienteBean clienteBean) {
        return null;
    }

    @Override
    public Boolean updateEmpresa(ClienteBean clienteBean) {
        return null;
    }

    @Override
    public Boolean deleteEmpresa(String chavePrimaria) {
        return null;
    }
}
