package orcamento.service.impl;

import orcamento.bean.ClienteBean;
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

        final ArrayList<ClienteBean> clienteBeans = new ArrayList<ClienteBean>();

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

        final ClienteBean clienteBean1 = new ClienteBean();
        clienteBean1.setTelefone("(19)4534344");
        clienteBean1.setEstado("New York");
        clienteBean1.setEndereco("Rua Carlos Gomes 1885");
        clienteBean1.setBairro("Jardim Meneghel");
        clienteBean1.setCep("43567-965");
        clienteBean1.setCidade("São Sebastião");
        clienteBean1.setCpf("7434343-963");
        clienteBean1.setEmail("mano@gmail.com");
        clienteBean1.setNome("Mano Menezes");

        clienteBeans.add(clienteBean);
        clienteBeans.add(clienteBean1);

        return clienteBeans;
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
        return true;
    }

    @Override
    public Boolean updateCliente(ClienteBean clienteBean) {
        return true;
    }

    @Override
    public Boolean deleteCliente(String chavePrimaria) {
        return true;
    }
}
