package orcamento.service.impl;

import orcamento.bean.ClienteBean;
import orcamento.dao.ClientesDAO;
import orcamento.service.IClientesService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * Created by mgustavo on 03/12/15.
 */
@Service
public class ClientesService implements IClientesService {


    @Override
    public ArrayList<ClienteBean> listClientes() {
        ClientesDAO clientesDAO = new ClientesDAO();
        return clientesDAO.listClientes();
    }

    @Override
    public ClienteBean getCliente(String chavePrimaria) {
        final ClienteBean clienteBean = new ClienteBean();
        clienteBean.setTelefone("(19)32856521");
        clienteBean.setEstado("Washington");
        clienteBean.setEndereco("Rua Gomes da Costa 885");
        clienteBean.setBairro("Parque Imperador");
        clienteBean.setCep("13529-965");
        clienteBean.setCidade("Campinas");
        clienteBean.setCpf("785002238-96");
        clienteBean.setEmail("reginaldo@gmail.com");
        clienteBean.setNome("Reginaldo Gomes");
        return clienteBean;
    }

    @Override
    public Boolean createCliente(ClienteBean clienteBean) {
        ClientesDAO clientesDAO = new ClientesDAO();
        clientesDAO.createCliente(clienteBean);
        return true;
    }

    @Override
    public Boolean updateCliente(ClienteBean clienteBean) {
        return true;
    }

    @Override
    public Boolean deleteCliente(String cpf) {
        ClientesDAO clientesDAO = new ClientesDAO();
        clientesDAO.deleteCliente(cpf);
        return true;
    }
}
