package model;

public abstract class Funcionario {

    private Integer IdFunc;
    private String Nome;
    private String Documento;
    private String Email;

    public Integer getIdFunc() {
        return IdFunc;
    }

    public void setIdFunc(Integer idFunc) {
        IdFunc = idFunc;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }
    
    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String documento) {
        Documento = documento;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public abstract String getTipoFuncionario();
}
