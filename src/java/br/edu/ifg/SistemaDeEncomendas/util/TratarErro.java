package br.edu.ifg.SistemaDeEncomendas.util;

public class TratarErro extends Exception{

    public TratarErro(String message) {
        super(message);
    }

    public TratarErro(String message, Throwable cause) {
        super(message, cause);
    }
      
}
