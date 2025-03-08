package libreria;

import java.util.ArrayList;

public class Libreria {
    //Atributos
    ArrayList<Libro> libros= new ArrayList<>();
    //Metodos de instancia
    public void addLibro(String autor, String titulo, double precio){
        Libro libro=new Libro(autor, titulo, precio);
        anyadirLibro(libro);
    }
    public void remLibro(String autor, String titulo){
        int pos=buscarLibro(autor, titulo);
        if (pos==-1){
            throw new RuntimeException("Libro no encontrado ("+autor+", "+titulo+")");
        }
        libros.remove(pos);

    }
    public double getPrecioFinal (String autor, String titulo){
        int pos=buscarLibro(autor, titulo);
        if (pos==-1){
            throw new RuntimeException("Libro no encontrado ("+autor+", "+titulo+")");
        }
        return libros.get(pos).getPrecioFinal();

    }
    public String toString(){

        String res="[";
        for (int i=0;i<libros.size();i++){
            res+=libros.get(i).toString();
            if(i<libros.size()-1){
                res+=",\n ";
            }
        }
        res+="]";
        return res;
    }
    protected void anyadirLibro(Libro libro){
        int pos=buscarLibro(libro.getAutor(), libro.getTitulo());
        if (pos==-1) {
            libros.add(libro);
        }else{
            libros.set(pos, libro);
        }
    }
    private int buscarLibro(String autor, String titulo){
        int pos=-1;
        for (int i=0; i<libros.size()&&pos==-1; i++){
            if (libros.get(i).getAutor().equalsIgnoreCase(autor) && libros.get(i).getTitulo().equalsIgnoreCase(titulo)){
                pos=i;
            }
        }
        return pos;
    }
}
