public class CarroSUV extends CarroEletrico {
    public CarroSUV(int id, String marca, String modelo, int anoFabricacao, double capacidadeBateria) {
        super(id, marca, modelo, anoFabricacao, capacidadeBateria, 400); 
    }

    @Override
    public int getTempoMedioCarga() {
        return 8;
    }
}