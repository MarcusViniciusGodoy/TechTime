package model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class RegistroPonto {

    private int idRegPonto;
     private Funcionario func;
     private LocalDate dataRegistro;
     private LocalDateTime horaEntrada;
     private LocalDateTime horaSaida;
 
     public int getIdRegPonto() {
         return idRegPonto;
     }
 
     public void setIdRegPonto(int idRegPonto) {
         this.idRegPonto = idRegPonto;
     }
 
     public Funcionario getFunc() {
         return func;
     }
 
     public void setFunc(Funcionario func) {
         this.func = func;
     }
 
     public LocalDate getDataRegistro() {
         return dataRegistro;
     }
 
     public void setDataRegistro(LocalDate dataRegistro) {
         this.dataRegistro = dataRegistro;
     }
 
     public LocalDateTime getHoraEntrada() {
         return horaEntrada;
     }
 
     public void setHoraEntrada(LocalDateTime horaEntrada) {
         this.horaEntrada = horaEntrada;
     }
 
     public LocalDateTime getHoraSaida() {
         return horaSaida;
     }
 
     public void setHoraSaida(LocalDateTime horaSaida) {
         this.horaSaida = horaSaida;
     }
 
     public long calcularHorasTrabalhadas() {
         if (horaEntrada != null && horaSaida != null) {
             return Duration.between(horaEntrada, horaSaida).toHours();
         }
         return 0;
     }
 
     public BigDecimal calcularValorDia() {
         if (func instanceof Operador operador) {
             return operador.getValorHora().multiply(BigDecimal.valueOf(calcularHorasTrabalhadas()));
         }
         return BigDecimal.ZERO;
     }

     public void apresentarRegistroPonto() {
        System.out.println("--- Relatório Diário de Ponto ---\n");
        System.out.println("Funcionario: " + func.getNome());
        System.out.println("Tipo: " + func.getTipoFuncionario());
        System.out.println("Data de Registro: " + dataRegistro);
        System.out.println("Hora de Entrada: " + horaEntrada);
        System.out.println("Hora de Saída: " + horaSaida);
        System.out.println("Horas Trabalhadas: " + calcularHorasTrabalhadas());
        if (func instanceof Operador) {
            System.out.println("Valor do Dia: R$ " + calcularValorDia());
        }
        System.out.println();
     }
}
