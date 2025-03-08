package libreria;

public class Libro{
    private static double porcIVA=10;
    private String autor;
    private String titulo;
    private double precio;
    //Constructor
    public Libro(String autor, String titulo, double precio){
        this.autor = autor;
        this.titulo = titulo;
        this.precio = precio;
    }
    //Métodos de instancia
    public String getAutor(){
        return autor;
    }
    public String getTitulo(){
        return titulo;
    }
    public double getPrecioBase(){
        return precio;
    }
    protected double getBaseImponible(){
        return precio;
    }
    public double getPrecioFinal(){
        double baseImponible = getBaseImponible();
        return baseImponible + baseImponible * porcIVA/100;
    }
    public String toString(){
        return "(" + autor + "; " + titulo + "; " + precio+ "; " + porcIVA+ "%; " + getPrecioFinal() + ")";
    }
    //Métodos de clase
    public static double getIVA(){
        return porcIVA;
    }
    public static void setIVA(double porcIVA){
        Libro.porcIVA = porcIVA;
    }
}