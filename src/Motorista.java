public class Motorista {
    private int id;
    private String nome;
    private String carteiraHabilitacao;
    private String nivelExperiencia; // Iniciante, Intermediário, Avançado

    public Motorista(int id, String nome, String carteiraHabilitacao, String nivelExperiencia) {
        this.id = id;
        this.nome = nome;
        this.carteiraHabilitacao = carteiraHabilitacao;
        this.nivelExperiencia = nivelExperiencia;
    }

    public void exibirDados() {
        System.out.printf("ID: %d, Nome: %s, Carteira de Habilitação: %s, Nível de Experiência: %s%n",
                id, nome, carteiraHabilitacao, nivelExperiencia);
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCarteiraHabilitacao() {
        return carteiraHabilitacao;
    }

    public void setCarteiraHabilitacao(String carteiraHabilitacao) {
        this.carteiraHabilitacao = carteiraHabilitacao;
    }

    public String getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(String nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

    
}
