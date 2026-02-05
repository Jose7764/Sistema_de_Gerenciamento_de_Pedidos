package service;

import model.Pedido;

public class CalcularFrete {

    public double freteCalculo(Pedido pedido){
        double frete = 0.0;
        if (pedido.getValorTotal() < 500.00) {
            frete = 50.00;

        } else {
            frete = 0.0;
        }
        return frete;
    }
}
