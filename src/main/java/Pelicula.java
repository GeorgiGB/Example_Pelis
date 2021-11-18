//CLASE TIPO POJO "PLAIN OLD JAVA OBJECT"

public class Pelicula {
    private int idPeli;
    private String titol;
    private int any;
    private String director;


    //Constructor
    public Pelicula(int idPeli, String titol, int any, String director) {
        this.idPeli = idPeli;
        this.titol = titol;
        this.any = any;
        this.director = director;
    }

    //Setters

    public int getIdPeli() {
        return idPeli;
    }

    public String getTitol() {
        return titol;
    }

    public int getAny() {
        return any;
    }

    public String getDirector() {
        return director;
    }


}
