package app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.Funcionario;
import model.Gerente;
import model.Operador;
import model.RegistroPonto;
import model.Secretaria;

public class ControleApp {

    public static void main(String[] args) throws InterruptedException {
        
        var opcao = -1;
        Scanner leitura = new Scanner(System.in);
        while(opcao != 0){
            var menu = """
                1 - Cadastrar funcionários
                2 - Listar funcionários cadastrados
 
                0 - Sair
                """;
 
                System.out.println(menu);
                opcao = leitura.nextInt();
                leitura.nextLine();
 
                switch (opcao) {
                    case 1:
                        cadastraFuncionario();
                        break;
                    case 2:
                        listaFuncionarios();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
        }
    }
    static List<Funcionario> funcionarios = new ArrayList<>();
    static List<RegistroPonto> registros = new ArrayList<>();

    public static void cadastraFuncionario() throws InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Qual a função do funcionário (Operador - 1, Gerente - 2, Secretaria - 3)");
        var funcao = leitura.nextInt();
        leitura.nextLine();
        Funcionario novoFuncionario = null;
    
        if (funcao == 1){
            Operador op = new Operador();
            System.out.println("Digite o nome do funcionário: ");
            String nome = leitura.nextLine();
            op.setNome(nome);
            System.out.println("Digite o valor da hora: ");
            var vlHora = leitura.nextBigDecimal();
            op.setValorHora(vlHora);
            novoFuncionario = op;
    
        } else if (funcao == 2){
            Gerente gr = new Gerente();
            System.out.println("Digite o nome do funcionário: ");
            String nome = leitura.nextLine();
            gr.setNome(nome);
            novoFuncionario = gr;
    
        } else if (funcao == 3){
            Secretaria sr = new Secretaria();
            System.out.println("Digite o nome do funcionário: ");
            String nome = leitura.nextLine();
            sr.setNome(nome);
            novoFuncionario = sr;
    
        } else {
            System.out.println("Digite uma função válida.");
            return;
        }
    
        RegistroPonto rp = new RegistroPonto();
        rp.setFunc(novoFuncionario);
        rp.setDataRegistro(LocalDate.now());
        rp.setHoraEntrada(LocalDateTime.of(LocalDate.now(), LocalTime.of(11,0,0)));
        Thread.sleep(1000);
        rp.setHoraSaida(LocalDateTime.now());
        funcionarios.add(novoFuncionario);
        registros.add(rp);
        rp.apresentarRegistroPonto();
    }

    public static void listaFuncionarios() {
        for (RegistroPonto rp : registros) {
            rp.apresentarRegistroPonto();
        }
    }
}
