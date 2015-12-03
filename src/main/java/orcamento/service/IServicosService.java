package orcamento.service;

import orcamento.bean.ServicoBean;

import java.util.ArrayList;

/**
 * Created by mgustavo on 03/12/15.
 */
public interface IServicosService {
    ArrayList<ServicoBean> listServicos();

    ServicoBean getServico(String chavePrimaria);

    Boolean createServico(ServicoBean servicoBean);

    Boolean updateServico(ServicoBean servicoBean);

    Boolean deleteServico(String chavePrimaria);
    
}
