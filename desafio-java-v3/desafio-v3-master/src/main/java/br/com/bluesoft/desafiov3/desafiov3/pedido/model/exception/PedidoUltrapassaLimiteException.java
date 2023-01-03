package br.com.bluesoft.desafiov3.desafiov3.pedido.model.exception;

public class PedidoUltrapassaLimiteException extends Exception{

     public PedidoUltrapassaLimiteException(){
          super ("Pedido Ultrapassa o Limite de 50 Itens");
     }
}
