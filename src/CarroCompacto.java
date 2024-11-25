public class CarroCompacto extends CarroEletrico {
    public CarroCompacto(int id, String marca, String modelo, int anoFabricacao, double capacidadeBateria) {
        super(id, marca, modelo, anoFabricacao, capacidadeBateria, 200); // Definindo autonomia padrão
    }

    @Override
    public int getTempoMedioCarga() {
        return 4;
    }
}

