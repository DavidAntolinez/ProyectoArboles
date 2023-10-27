
import bean.Nodos;
import logica.Larbol;

public class App {
    public static void main(String[] args) throws Exception {
        Larbol h = new Larbol("GBHADCFEMJNILK");
        
        Nodos q = h.Buscardato(h.getPunta(), 'D');
        h.h();
    }
}
