package model;

public class Secretaria extends Funcionario{

    private String ramal;
    private String telefone;

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String getTipoFuncionario(){
        return "Secretaria";
    }
}
