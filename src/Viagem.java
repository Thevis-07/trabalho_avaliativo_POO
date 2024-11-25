import java.util.ArrayList;
import java.util.List;

public class Viagem {
    private CarroEletrico carro;
    private Motorista motorista;
    private Rota rota;
    private List<Integer> eletropostosIds;
    
    public Viagem(CarroEletrico carro, Motorista motorista, Rota rota) {
        this.carro = carro;
        this.motorista = motorista;
        this.rota = rota;
        this.eletropostosIds = new ArrayList<>();
    }

    public void Viajar(){
        var eletropostos = this.rota.RealizarRota(this.carro);
        eletropostosIds.addAll(eletropostos);
    }

    public CarroEletrico getCarro() {
        return carro;
    }

    public void setCarro(CarroEletrico carro) {
        this.carro = carro;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public List<Integer> getEletropostos() {
        return eletropostosIds;
    }

    public void exibir() {
        System.out.println("Detalhes da Viagem:");
        System.out.println("--------------------");
        
        System.out.println("Carro Elétrico:");
        System.out.println("Modelo: " + carro.getModelo());
        System.out.println("Autonomia: " + carro.getAutonomia() + " km");
    
        System.out.println("\nMotorista:");
        System.out.println("Nome: " + motorista.getNome());
        System.out.println("CNH: " + motorista.getCarteiraHabilitacao());
    
        System.out.println("\nRota:");
        System.out.println("Destino: " + rota.getDestino());
        System.out.println("Distância Total: " + rota.getDistancia() + " km");
    
        System.out.println("\nEletropostos ao longo da rota:");
        for (Integer id : eletropostosIds) {
            System.out.println("- Eletroposto ID: " + id);
        }
    }
}

