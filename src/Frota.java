import java.util.ArrayList;
import java.util.List;

public class Frota {
    private List<CarroEletrico> carros;
    private List<Motorista> motoristas;
    private List<EletroPosto> eletropostos;
    private List<Viagem> viagens;

    public Frota() {
        this.carros = new ArrayList<CarroEletrico>();
        this.motoristas = new ArrayList<Motorista>();
        this.eletropostos = new ArrayList<EletroPosto>();
        this.viagens = new ArrayList<Viagem>();
    }

    public void adicionarCarro(CarroEletrico carro) {
        carros.add(carro);
    }

    public void removerCarro(int id) {
        for (var x : this.carros){
            if(x.getId() == id){
                this.carros.remove(x);
                break;
            }
        };
    }

    public void  listarCarros() {
        System.out.println("Os carros cadastrados são: ");
        for (var x : this.carros){
            x.exibirInformacoes();
        }

        System.out.println("----------------------------------------------------------------------------------");
    }

    public void adicionarMotorista(Motorista motorista) {
        motoristas.add(motorista);
    }

    public void listarMotoristas() {
        System.out.println("Os motoristas cadastrados são: ");
        for (var x : this.motoristas){
            x.exibirDados();
        }

        System.out.println("----------------------------------------------------------------------------------");
    }

    public void adicionarEletroposto(EletroPosto eletroposto) {
        eletropostos.add(eletroposto);
    }

    public void  listarEletropostos() {
        System.out.println("Os EletroPostos cadastrados são: ");
        for (var x : this.eletropostos){
            x.exibirDados();
        }

        System.out.println("----------------------------------------------------------------------------------");
    }

    public void registrarViagem(Viagem viagem) {
        viagens.add(viagem);
    }

    public List<Viagem> listarViagens() {
        return new ArrayList<>(viagens);
    }

    public void listarCarrosBaixaAutonomia(){
        var carrosBaixaAutonomia = new ArrayList<CarroEletrico>();

        for(CarroEletrico car : this.carros){
            if(car.getAutonomia() > 0){
                double percentual = (car.getAutonomia() / car.getAutonomiaTotal()) * 100;

                if(percentual <= 20){
                    carrosBaixaAutonomia.add(car);
                }
            }
        }

        System.out.println("\nCarros com autonomia menor ou igual a 20%: ");
        for(CarroEletrico car : carrosBaixaAutonomia){
            car.exibirInformacoes();
        }
    }


    public void listarCarrosManutencao(){
        var carrosBaixaAutonomia = new ArrayList<CarroEletrico>();

        for(CarroEletrico car : this.carros){
            if(car.getQuilomretragem() >= 100000){
                carrosBaixaAutonomia.add(car);
            }
        }

        System.out.println("\nCarros que necessitam manutenção: ");
        for(CarroEletrico car : carrosBaixaAutonomia){
            car.exibirInformacoes();
        }
    }

    public void historicoRecargasCarroId(int id){

        System.out.println("\nHistórico de recagas carro: " + id);
        for(CarroEletrico car : this.carros){
            if(car.getId() == id){
                for(var recarga : car.getRegistroRecargas()){
                    recarga.exibir();
                }
            }
        }
    }

    public void ViagensMotoristaId(int id){
        var viagensFeitas = new ArrayList<Viagem>();

        System.out.println("\nViagens do motorista especificado:");

        for(Viagem viagem : this.viagens){
            if(viagem.getMotorista().getId() == id){
                viagensFeitas.add(viagem);
            }
        }

        for(Viagem viagem : viagensFeitas){
            viagem.exibir();
        }
    }

    public List<EletroPosto> BuscarEletropostosLocalizacao(String localizacao){
        var eletroPostos = new ArrayList<EletroPosto>();

        for (var eletro : this.eletropostos){
            System.out.println("teste teste");
            System.out.println(eletro.getLocalizacao() == localizacao);
            if(eletro.getLocalizacao().toUpperCase() == localizacao.toUpperCase()){
                eletroPostos.add(eletro);
            }
        }

        return eletroPostos;
    }

    public CarroEletrico BuscarCarroId(int id){
        for (var car : this.carros){
            if(car.getId() == id){
                return car;
            }
        }
        return null;
    }

    public Motorista BuscarMotoristaId(int id){
        for (var motora : this.motoristas){
            if(motora.getId() == id){
                return motora;
            }
        }
        return null;
    }
}
