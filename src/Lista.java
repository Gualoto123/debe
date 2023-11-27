import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Lista {

    private Set<Paquete> listadoPaquete;

    public Lista() {
        listadoPaquete = new LinkedHashSet<>();
        listadoPaquete.add(new Paquete(1, 7.5f, "QUITO", "Prensa", "Pepe", "En ruta"));
        listadoPaquete.add(new Paquete(2, 3.5f, "Guayaquil", "Prensa", "Ana", "En ruta"));
        listadoPaquete.add(new Paquete(3, 1.5f, "QUITO", "Amazonas", "Pepe", "Entregado"));
        listadoPaquete.add(new Paquete(3, 5.5f, "QUITO", "Amazonas", "Pepe", "Entregado"));
    }

    public void agregar(Paquete nuevoPaquete) {
        listadoPaquete.add(nuevoPaquete);
    }

    //ciudad nombre
  public ArrayList <Paquete> ciudadNombre (String ciudad, String nombre){
        ArrayList resultado= new ArrayList<>();
        for(Paquete p: listadoPaquete){
            if(p.getCiudad().compareToIgnoreCase(ciudad)==0 &&
            p.getNombreReceptor().compareToIgnoreCase(nombre)==0){
                resultado.add(p);
            }
        }
        return resultado;
  }

// suma recursivo
    public float sumaRecursivo(int indice, String ciudad){
        if(indice==listadoPaquete.size())
            return 0;
        Paquete paquete=(Paquete) listadoPaquete.toArray()[indice];
        if(paquete.getCiudad().compareToIgnoreCase(ciudad)==0)
            return paquete.getPeso()+sumaRecursivo(indice+1, ciudad);
        else
            return sumaRecursivo(indice+1, ciudad);

    }
    public float suma(String ciudad){
        return sumaRecursivo(0, ciudad);
    }
    public void odernar(){
        ArrayList<Paquete> paquetesList = new ArrayList<>(listadoPaquete);
        int n = paquetesList.size();

        for (int i = 1; i < n; i++) {
            Paquete aux = paquetesList.get(i);
            int j = i - 1;

            while (j >= 0 && aux.getPeso() < paquetesList.get(j).getPeso()) {
                paquetesList.set(j + 1, paquetesList.get(j));
                j = j - 1;
            }
            paquetesList.set(j + 1, aux);
        }

        listadoPaquete = new LinkedHashSet<>(paquetesList);
    }
    public Set<Paquete> getListadoPaquete() {
        return listadoPaquete;
    }

    }



