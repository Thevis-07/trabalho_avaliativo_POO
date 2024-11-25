import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var frota = new Frota();

        frota.adicionarCarro(new CarroCompacto(01, "chevrolet", "Bolt EV", 2024, 60.00)); 
        frota.adicionarCarro(new CarroCompacto(10, "fiat", "500e", 2023, 42.00)); //200km autonomia
        frota.adicionarCarro(new CarroSUV(2, "Tesla", "Model Y", 2024, 75.00));
        frota.adicionarCarro(new CarroSUV(4, "Hyundai", "Ioniq 5", 2024, 77.40));
        frota.adicionarCarro(new CarroSedan(7, "BMW", "i4", 2024, 81.50));
        frota.adicionarCarro(new CarroSedan(7, "Tesla", "Model 3", 2024, 75));
        frota.listarCarros();

        frota.BuscarCarroId(4).setQuilomretragem(150000);
        frota.BuscarCarroId(7).setQuilomretragem(250000);

        frota.adicionarMotorista(new Motorista(1, "Joãozinho", "021451552154", "iniciante"));
        frota.adicionarMotorista(new Motorista(2, "Mariazinha", "021451552155", "intermediário"));
        frota.adicionarMotorista(new Motorista(3, "Zezinho", "021451552156", "avançado"));
        frota.adicionarMotorista(new Motorista(4, "Luizinho", "021451552157", "iniciante"));
        frota.listarMotoristas();


        frota.adicionarEletroposto(new EletroPosto(10, "BR 287", 2, 3, 100 ));
        frota.adicionarEletroposto(new EletroPosto(9, "BR 287", 0, 2, 200 ));
        frota.adicionarEletroposto(new EletroPosto(8, "BR 287", 3, 2, 300 ));
        frota.adicionarEletroposto(new EletroPosto(7, "BR 287", 3, 2, 450 ));
        frota.adicionarEletroposto(new EletroPosto(6, "BR 101", 1, 4, 150));
        frota.adicionarEletroposto(new EletroPosto(5, "BR 116", 2, 3, 220));
        frota.adicionarEletroposto(new EletroPosto(4, "av principal", 3, 2, 350));
        frota.adicionarEletroposto(new EletroPosto(3, "rodovia central", 4, 1, 500));
        frota.adicionarEletroposto(new EletroPosto(2, "rua secundária", 2, 2, 600));        
    

        System.out.println(frota.BuscarEletropostosLocalizacao("BR 287"));

        var rota = new Rota(1, "Caxias", 610, frota.BuscarEletropostosLocalizacao("BR 287"));
        var rota2 = new Rota(1, "POA", 640, frota.BuscarEletropostosLocalizacao("BR 287"));

        var motora = frota.BuscarMotoristaId(1);
        var carro = frota.BuscarCarroId(1);

        var carro2 = frota.BuscarCarroId(10);

        var viagem = new Viagem(carro, motora, rota);
        var viagem2 = new Viagem(carro2, motora, rota2);

        viagem.Viajar();
        viagem2.Viajar();

        frota.registrarViagem(viagem);

        frota.listarCarrosManutencao();
        frota.listarCarrosBaixaAutonomia();

        frota.ViagensMotoristaId(1);

        frota.historicoRecargasCarroId(1);
    }
}
