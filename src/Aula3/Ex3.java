package Aula3;

public class Ex3 {
	public static void main(String[]args){
        Condutor condutor = new Condutor("Manuel", 55555, new Data(13, 06, 1996), 'C');
        Veiculo veiculo = new Veiculo(2000, 50, 5, 1000);
        Ligeiro ligeiro = new Ligeiro(2500, 200, 5, 1000);
        PesadoMercadorias pesadoMercadorias = new PesadoMercadorias(2500, 100, 2, 1500);
        Motociclo motociclo = new Motociclo(100, 120, 1, 300);
        PesadoPassageiros pesadoPassageiros = new PesadoPassageiros(1000, 100, 15, 1500);
        
        
        System.out.println("Condutor: " +condutor+"\n");
        System.out.println("Veículo: "+veiculo+"\n");
        System.out.println("Ligeiro: "+ligeiro+"\n");
        System.out.println("Pesado de Mercadorias: "+pesadoMercadorias+"\n");
        System.out.println("Motociclo: "+motociclo+"\n");
        System.out.println("Pesado de Passageiros: "+pesadoPassageiros+"\n");
        
    }
}
