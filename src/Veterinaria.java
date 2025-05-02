import java.util.ArrayList;

public class Veterinaria {
    private ArrayList<Mascota> mascotas;


    public Veterinaria(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public void agregarMascota(Mascota m) {
        mascotas.add(m);
    }


    @Override
    public String toString() {
        return "Veterinaria{" +
                ", mascotas=" + mascotas +
                '}';
    }
}

