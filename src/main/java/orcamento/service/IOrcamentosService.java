package orcamento.service;

import orcamento.bean.OrcamentoBean;
import java.util.Collection;
import java.util.Date;

/**
 * Created by mgustavo on 03/12/15.
 */
public interface IOrcamentosService {

    Collection<OrcamentoBean> listOrcamentos(Date inicio, Date fim);

    OrcamentoBean getOrcamento(Long chavePrimaria);

    OrcamentoBean createOrcamento(OrcamentoBean orcamentoBean);

    Boolean updateOrcamento(OrcamentoBean orcamentoBean);

    Boolean deleteOrcamento(Long chavePrimaria);

}
