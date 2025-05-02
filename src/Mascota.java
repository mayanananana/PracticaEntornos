import java.util.Objects;

public class Mascota {
    private int id;
    private String nombre;
    private int edad;
    private String especie;
    private boolean vacunado;
    private int visitas;
    private static int count=1;


    public Mascota() {
        this.id = count;
        count++;
    }

    public Mascota(String nombre, int edad, String especie, boolean vacunado) {
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
        this.vacunado = vacunado;
        this.visitas=0;
        this.id= count; count++;

    }

    public Mascota(String nombre, int edad, String especie, boolean vacunado, int visitasUser) {
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
        this.vacunado = vacunado;
        this.visitas=visitasUser;
        this.id= count; count++;

    }

   /* public String getNombre() {
        return nombre;
    }*/

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  /*  public int getEdad() {
        return edad;
    }*/

    public void setEdad(int edad) {
        this.edad = edad;
    }

   /* public String getEspecie() {
        return especie;
    }*/

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    public int getVisitas() {
        return visitas;
    }

    public void vacunar() {
        this.vacunado = true;
    }

    public void registrarVisita() {
        this.visitas++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", especie='" + especie + '\'' +
                ", vacunado=" + vacunado +
                ", visitas=" + visitas +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mascota mascota = (Mascota) o;
        return id == mascota.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

