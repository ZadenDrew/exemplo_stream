package exemplostream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author acabezaslopez
 */
public class UsosStreams {

    List<Alumno> listaAlumnos = new ArrayList();
    List<Alumno> suspensos = new ArrayList();

    public void crearLista() {
        listaAlumnos.add(new Alumno("111", "Ana", "dam1", 4));
        listaAlumnos.add(new Alumno("222", "Ana", "dam1", 8));
        listaAlumnos.add(new Alumno("333", "Antón", "dam2", 6));
        listaAlumnos.add(new Alumno("444", "Brais", "fpb", 5));
        listaAlumnos.add(new Alumno("555", "Alex", "dam1", 3));
        listaAlumnos.add(new Alumno("666", "Noa", "adm", 7));
    }

    public void amosar() {
        /* try {

            Iterator it = listaAlumnos.iterator();
            if (it.next() != null) {
                System.out.println(listaAlumnos.toString());
            }
        } catch (NullPointerException ep) {
            System.out.println("El Array es nulo\nNo hay libros!!!!");
        }*/
 /*for(Alumno al:listaAlumnos)
           System.out.println(al);*/
        //*** USANDO STREAMS */
        listaAlumnos.stream().forEach((a) -> System.out.println(a));
        // **** UTILIZANDO REFERENCIA A METODOS */
        listaAlumnos.stream().filter(a -> true).forEach(System.out::println);

    }

    /* public void pedirdatos(){
     listaAlumnos = new lista(JOptionPane.showInputDialog("Introduce o titulo: "),
                            JOptionPane.showInputDialog("Introduce o autor: "),
                            JOptionPane.showInputDialog("Introduce ISBN: "),
                            Float.parseFloat(JOptionPane.showInputDialog("Introduce prezo: ")),
                            Integer.parseInt(JOptionPane.showInputDialog("Introduce nº unidades: ")));
     listaAlumnos.add(lista);
    }*/
    public void amosarAlumnoDeterminado() {
        /* **** AMOSAR OS ALUMNOS QUE COMEZAN POR A *** */
        listaAlumnos.stream().filter(al -> al.getNome().charAt(0) == 'A').forEach(al -> System.out.println(al));
        //listaAlumnos.stream().filter(a -> a.getNome().charAt(0) == 'A').forEach(a -> System.out.println(a));
        listaAlumnos.stream().filter(al -> al.getNome().startsWith("B")).forEach(al -> System.out.println(al));
    }

    public void aprobados() {
        /* ***AMOSAR OS APROBADOS *** */
        listaAlumnos.stream().filter(al -> al.getNota() >= 5).forEach(al -> System.out.println(al));
    }

    public void listarSuspensos() {
        suspensos = listaAlumnos.stream().filter((al) -> al.getNota() < 5).collect(Collectors.toList());

    }

    public void amosarSuspensos() {
        suspensos.stream().forEach(al -> System.out.println(al));
    }

    public void buscarAlumno() {
        String nif = JOptionPane.showInputDialog("Introduce dni :");
        listaAlumnos.stream().filter(al -> al.getDni().equalsIgnoreCase(nif)).forEach(System.out::println);
    }
   
      public void mayorNota(){
            
           crearLista();
         System.out.println(listaAlumnos.stream().max((al1,al2)->al1.getNota()-al2.getNota()).get());
      }
      public void ordenar(){
          crearLista();
          listaAlumnos.stream().sorted((al1,al2)-> al1.getNome().compareToIgnoreCase(al2.getNome())).forEach(System.out::println);
      }
      public void subirNota(){
          crearLista();
          
          listaAlumnos.stream().map((al)-> al.getNota()+2).forEach(System.out::println);
          listaAlumnos.stream().filter(al -> al.getNota()>5).map(al -> al.getNota()+2).forEach(System.out::println);
      }

}
