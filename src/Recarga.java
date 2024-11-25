import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Recarga {
    private LocalDateTime data; // Data da recarga
    private int eletropostoId; // ID do eletroposto utilizado
    private Double quantidadeCarregada; // Quantia recarregada (em kWh)
    
    public Recarga(int eletroposto, Double quantidadeCarregada) {
        this.data = LocalDateTime.now();
        this.eletropostoId = eletroposto;
        this.quantidadeCarregada = quantidadeCarregada;
    }

    public void exibir() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = data.format(formatter);

        System.out.println("=== Detalhes da Recarga ===");
        System.out.println("Data: " + dataFormatada);
        System.out.println("Eletroposto ID: " + eletropostoId);
        System.out.println("Quantidade Carregada (kWh): " + quantidadeCarregada);
        System.out.println("===========================");
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getEletropostoId() {
        return eletropostoId;
    }

    public void setEletropostoId(int eletropostoId) {
        this.eletropostoId = eletropostoId;
    }

    public Double getQuantidadeCarregada() {
        return quantidadeCarregada;
    }

    public void setQuantidadeCarregada(Double quantidadeCarregada) {
        this.quantidadeCarregada = quantidadeCarregada;
    }

    
}
