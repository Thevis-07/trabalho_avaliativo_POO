
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class CarroEletrico {
    private int id;
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private int nivelBateria;
    private double capacidadeBateria;
    private double autonomia;
    private double autonomiaTotal;
    private double  quilometragem;
    private List<Recarga> registroRecargas;

    public CarroEletrico(int id, String marca, String modelo, int anoFabricacao, double capacidadeBateria, double autonomia) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.capacidadeBateria = capacidadeBateria;
        this.autonomia = autonomia;
        this.autonomiaTotal = autonomia;
        this.quilometragem = 0.0;
        this.registroRecargas = new ArrayList<Recarga>();
    }
    
    public abstract int getTempoMedioCarga();

    public void Recarregando(int EletroPostoId){    
    
        this.autonomia = this.autonomiaTotal;

        var quantidadeCarregada = this.capacidadeBateria * (1 - (this.nivelBateria / 100));

        registroRecargas.add(new Recarga(EletroPostoId, quantidadeCarregada));
    
        System.out.println("Carro recarregado. Autonomia: " + autonomia + " km");
    }

    public void exibirInformacoes() {
        System.out.println("Id: " + id + " - Marca: " + marca + " - Modelo: " + modelo + " - Autonomia: " + autonomia + " km");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public double getCapacidadeBateria() {
        return capacidadeBateria;
    }

    public void setCapacidadeBateria(double capacidadeBateria) {
        this.capacidadeBateria = capacidadeBateria;
    }

    public double getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }
    
    public double getAutonomiaTotal() {
        return autonomiaTotal;
    }

    public void setAutonomiaTotal(double autonomiaTotal) {
        this.autonomiaTotal = autonomiaTotal;
    }
    
    public int getNivelBateria() {
        return nivelBateria;
    }

    public void setNivelBateria(int nivelBateria) {
        this.nivelBateria = nivelBateria;
    }

    public double getQuilomretragem() {
        return quilometragem;
    }

    public void setQuilomretragem(double quilomretragem) {
        this.quilometragem = quilomretragem;
    }

    public List<Recarga> getRegistroRecargas() {
        return registroRecargas;
    }

    public void setRegistroRecargas(List<Recarga> registroRecargas) {
        this.registroRecargas = registroRecargas;
    }
    
}
