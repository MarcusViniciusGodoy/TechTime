package model;

import java.math.BigDecimal;

public class Operador extends Funcionario{

    private BigDecimal valorHora;

    public BigDecimal getValorHora() {
        return valorHora;
    }

    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public String getTipoFuncionario(){
        return "Operador";
    }
}
