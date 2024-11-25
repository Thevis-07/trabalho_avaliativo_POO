public class EletroPosto {
    private int id;
    private String localizacao; // cdd estr
    private int vagasDisponiveis;
    private double tempoMedioCarga; //horas
    private int km;

    public EletroPosto(int id, String localizacao, int vagasDisponiveis, double tempoMedioCarga, int km) {
        this.id = id;
        this.localizacao = localizacao;
        this.vagasDisponiveis = vagasDisponiveis;
        this.tempoMedioCarga = tempoMedioCarga;
        this.km = km;
    }

    public void exibirDados() {
        System.out.printf("ID: %d, Localização: %s, Vagas Disponíveis: %d, Tempo Médio de Carga: %.2f horas%n",
                id, localizacao, vagasDisponiveis, tempoMedioCarga);
    }    

    public boolean temVagasDisponiveis()
    {
        if(this.vagasDisponiveis > 0) return true;
        
        return false;
    }

    public void ocuparVaga(){
        if(vagasDisponiveis > 0){
            this.vagasDisponiveis += 1;
        }

        System.out.println("Sem vagas disponiveis!!");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public double getTempoMedioCarga() {
        return tempoMedioCarga;
    }

    public void setTempoMedioCarga(double tempoMedioCarga) {
        this.tempoMedioCarga = tempoMedioCarga;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    
}
