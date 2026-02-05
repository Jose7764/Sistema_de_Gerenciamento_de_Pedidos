package service;

import Repository.BancoDeDados;
import model.Pedido;


public class ProcessadorDePedido {

    BancoDeDados bancoDeDados = new BancoDeDados();
    ConfirmarEmail email = new ConfirmarEmail();
    CalcularFrete fretes = new CalcularFrete();

    public double processar(Pedido pedido)
            throws Exception {

        if (pedido.getQuantidadeItens() > 100) {

            throw new Exception("Estoque insuficiente para a quantidade solicitada.");
        }

        double frete = fretes.freteCalculo(pedido);
        double impostos = pedido.getValorTotal() * 0.15; // 15% de imposto fixo
        double valorFinal = pedido.getValorTotal() + frete + impostos;


        pedido.setPago(true);
        bancoDeDados.salvarNoBancoDeDado(pedido, valorFinal);
        email.enviarConfirmacaoPorEmail(pedido.getEmailCliente(), pedido.getId());
        return valorFinal;
    }



}