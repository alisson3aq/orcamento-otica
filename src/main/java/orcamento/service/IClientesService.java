package orcamento.service;

import orcamento.bean.ClienteBean;

import java.util.ArrayList;

/**
 * Created by mgustavo on 03/12/15.
 */
public interface IClientesService {

    ArrayList<ClienteBean> listClientes();

    ClienteBean getCliente(String chavePrimaria);

    Boolean createCliente(ClienteBean clienteBean);

    Boolean updateCliente(ClienteBean clienteBean);

    Boolean deleteCliente(String chavePrimaria);
    
}
