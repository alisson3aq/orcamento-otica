package orcamento.service.impl;

import orcamento.bean.ServicoBean;
import orcamento.service.IServicosService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by mgustavo on 03/12/15.
 */
@Service
public class ServicoService implements IServicosService {

    @Override
    public ArrayList<ServicoBean> listServicos() {

        ArrayList<ServicoBean> servicoBeans = new ArrayList<ServicoBean>();

        ServicoBean servicoBean = new ServicoBean();
        servicoBean.setCodigo("0521");
        servicoBean.setDescricao("Limpeza de lentes");
        servicoBean.setFornecedor("In House");
        servicoBean.setUnidade("par");
        servicoBean.setValorUnitario(new BigDecimal(113.90));

        ServicoBean servicoBean1 = new ServicoBean();
        servicoBean1.setCodigo("0522");
        servicoBean1.setDescricao("Conserto de armação");
        servicoBean1.setFornecedor("In house");
        servicoBean1.setUnidade("un");
        servicoBean1.setValorUnitario(new BigDecimal(123.5));

        servicoBeans.add(servicoBean);
        servicoBeans.add(servicoBean1);


        return servicoBeans;
    }

    @Override
    public ServicoBean getServico(String chavePrimaria) {
        ServicoBean servicoBean = new ServicoBean();
        servicoBean.setCodigo("0521");
        servicoBean.setDescricao("Limpeza de lentes");
        servicoBean.setFornecedor("In House");
        servicoBean.setUnidade("par");
        servicoBean.setValorUnitario(new BigDecimal(113.90));

        return servicoBean;
    }

    @Override
    public Boolean createServico(ServicoBean servicoBean) {
        return true;
    }

    @Override
    public Boolean updateServico(ServicoBean servicoBean) {
        return true;
    }

    @Override
    public Boolean deleteServico(String chavePrimaria) {
        return true;
    }
}
