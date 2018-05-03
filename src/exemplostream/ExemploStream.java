package exemplostream;

/**
 *
 * @author acabezaslopez
 */
public class ExemploStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alumno al = new Alumno();
        UsosStreams st = new UsosStreams();
        st.crearLista();
        //st.amosar();
        st.listarSuspensos();
        st.amosarSuspensos();
    }

}
