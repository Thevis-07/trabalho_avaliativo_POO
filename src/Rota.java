import java.util.ArrayList;
import java.util.List;

public class Rota {
    private int id;
    private String destino;
    private double distancia;
    private double  distanciaPercorrida;
    private List<EletroPosto> eletroPostos;

    public Rota(int id, String destino, double distancia, List<EletroPosto> eletroPostos) {
        this.id = id;
        this.destino = destino;
        this.distancia = distancia;
        this.eletroPostos = eletroPostos;
        this.distanciaPercorrida = 0;
    }

    public List<Integer> RealizarRota(CarroEletrico carro) {
        double autonomiaRestante = carro.getAutonomia();
        List<Integer> idsEletropostos = new ArrayList<Integer>();

        if (distancia <= autonomiaRestante) {
            System.out.println("Veículo pode realizar a viagem sem recarregar.");
            distanciaPercorrida = distancia;
            autonomiaRestante -= distancia;
        } else {
            while (this.distanciaPercorrida < this.distancia) {
                if (this.eletroPostos.size() > 0) {
                    double trecho = this.eletroPostos.get(0).getKm() - this.distanciaPercorrida;
                    if (trecho < 0) {
                        this.eletroPostos.remove(0);
                        continue;
                    }

                    if (this.eletroPostos.get(0).temVagasDisponiveis() && autonomiaRestante >= trecho) {
                        System.out.println("Carregando para prosseguir a viagem...");
                        distanciaPercorrida += trecho;
                        autonomiaRestante -= trecho;
                        carro.Recarregando(this.eletroPostos.get(0).getId());
                        autonomiaRestante = carro.getAutonomiaTotal();
                        idsEletropostos.add(this.eletroPostos.get(0).getId());
                        this.eletroPostos.remove(0);
                    } else if (this.eletroPostos.size() > 1) {
                        double proximoTrecho = this.eletroPostos.get(1).getKm() - this.distanciaPercorrida;
                        if (autonomiaRestante >= proximoTrecho) {
                            System.out.println("Sem vagas no eletroposto atual. Deslocando para o proximo...");
                            this.eletroPostos.remove(0);
                        } else {
                            System.out.println("Autonomia insuficiente para chegar ao proximo eletroposto.");
                            System.out.println("Aguardando vaga...");
                            distanciaPercorrida += trecho;
                            autonomiaRestante -= trecho;
                            carro.Recarregando(this.eletroPostos.get(0).getId());
                            autonomiaRestante = carro.getAutonomiaTotal();
                            idsEletropostos.add(this.eletroPostos.get(0).getId());
                            this.eletroPostos.remove(0);
                        }
                    } else {
                        double distanciaAteDestino = this.distancia - this.distanciaPercorrida;
                        if (autonomiaRestante >= distanciaAteDestino) {
                            System.out.println("Prosseguindo até o destino.");
                            distanciaPercorrida += distanciaAteDestino;
                            autonomiaRestante -= distanciaAteDestino;
                            break;
                        } else {
                            System.out.println("O veículo não pode realizar esta rota, falta de autonomia.");
                            break;
                        }
                    }
                } else {
                    double distanciaAteDestino = this.distancia - this.distanciaPercorrida;
                    if (autonomiaRestante >= distanciaAteDestino) {
                        System.out.println("Prosseguindo até o destino.");
                        distanciaPercorrida += distanciaAteDestino;
                        autonomiaRestante -= distanciaAteDestino;
                    } else {
                        System.out.println("O veículo não pode realizar esta rota, falta de autonomia.");
                    }
                    break;
                }
            }

            carro.setAutonomia(autonomiaRestante);

            if (this.distanciaPercorrida >= this.distancia) {
                System.out.println("Viagem concluída.");
            } else {
                System.out.println("Viagem não concluída. Distância percorrida: " + this.distanciaPercorrida + " km");
            }
        }

        return idsEletropostos;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public List<EletroPosto> getEletroPostos() {
        return eletroPostos;
    }

    public void setEletroPostos(List<EletroPosto> eletroPostos) {
        this.eletroPostos = eletroPostos;
    }
}
