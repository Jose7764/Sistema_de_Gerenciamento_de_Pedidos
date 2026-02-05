package Repository;

import model.Pedido;

public class BancoDeDados {

    public void salvarNoBancoDeDado(Pedido pedido, double valorFinal) {

        System.out.println("Pedido " + pedido.getId() + " finalizado (Valor: R$" + valorFinal + ") e salvo no BD.");

    }
}
