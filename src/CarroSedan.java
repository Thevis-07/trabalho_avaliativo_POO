public class CarroSedan extends CarroEletrico {
    public CarroSedan(int id, String marca, String modelo, int anoFabricacao, double capacidadeBateria) {
        super(id, marca, modelo, anoFabricacao, capacidadeBateria, 400); // Definindo autonomia padrão
    }

    @Override
    public int getTempoMedioCarga() {
        return 6;
    }
}
