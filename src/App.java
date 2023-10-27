
import logica.Larbol;

public class App {
    public static void main(String[] args) throws Exception {
        Larbol h = new Larbol("GBHADCFEMJNILK");
        System.out.println(h.ContarHojas(h.getPunta(), 0));
    }
}
