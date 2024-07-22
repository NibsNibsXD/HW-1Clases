/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hw1p2clases;

/**
 *
 * @author Jorge Aguirre
 */
public class Multa {
    
    public static double TIPO_GRAVE = 5000;
    public static double TIPO_MEDIO = 2000;
    public static double TIPO_LEVE = 500;
    
    private int CodigoDeMulta;
    private String NombreDelMultado;
    private String TipoDeMulta;
    private double MontoAPagar;
    private boolean FuePagada;

    public Multa(int codigo, String nombreInfractor, String tipo) {
        this.CodigoDeMulta = codigo;
        this.NombreDelMultado = nombreInfractor;
        this.FuePagada = false;
        
        
        
        
    }
    
    public int getCodigo() {
        return CodigoDeMulta;
    }

    public double getMontoAPagar() {
        return MontoAPagar;
    }

    public boolean isPagada() {
        return FuePagada;
    }
    
    private void SetterDeTipo(String tipo){
        switch(tipo){
            case "GRAVE":
                this.TipoDeMulta = tipo;
                this.MontoAPagar = TIPO_GRAVE;
                break;
            case "MEDIO":
                this.TipoDeMulta = tipo;
                this.MontoAPagar = TIPO_MEDIO;
                break;
            case "LEVE":
            default:
                this.TipoDeMulta = "LEVE";
                this.MontoAPagar = TIPO_LEVE;
                break;
        }
        
        
        
        
    }
    
    public void pay() {
        if (!FuePagada) {
            FuePagada = true;
        }
    }
}
