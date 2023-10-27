package logica;

import bean.Barbol;
import bean.Nodos;

public class Larbol extends Barbol {

    public Larbol(String cadena) {
        char[] datos = cadena.toCharArray();
        for (int i = 0; i < datos.length; i++) {
            Insertar(datos[i], getPunta());
        }
    }

    public void RecorrerInorden(Nodos R) {
        if (R != null) {
            RecorrerInorden(R.getLi());
            Mostrar(R.getDato());
            RecorrerInorden(R.getLd());
        }
    }

    public void Mostrar(char a) {
        System.out.print(a);
    }

    public void RecorrerPosorden(Nodos R) {
        if (R != null) {
            RecorrerPosorden(R.getLi());
            RecorrerPosorden(R.getLd());
            Mostrar(R.getDato());
        }
    }

    public void RecorrerPreorden(Nodos R) {
        if (R != null) {
            Mostrar(R.getDato());
            RecorrerPreorden(R.getLi());
            RecorrerPreorden(R.getLd());
        }
    }

    public void h() {
        System.out.println("null");
    }

    public void Insertar(char dato, Nodos P) {
        if (getPunta() == null) {
            setPunta(new Nodos(dato));
        } else {
            if (dato > P.getDato()) {
                if (P.getLd() == null) {
                    P.setLd(new Nodos(dato));
                } else {
                    Insertar(dato, P.getLd());
                }
            } else {
                if (P.getLi() == null) {
                    P.setLi(new Nodos(dato));
                } else {
                    Insertar(dato, P.getLi());
                }
            }
        }
    }

    public void Mostrar1hijos(Nodos R) {
        if (R != null) {
            Mostrar1hijos(R.getLi());
            if ((R.getLd() == null && R.getLi() != null) || (R.getLd() != null && R.getLi() == null)) {
                Mostrar(R.getDato());
            }
            Mostrar1hijos(R.getLd());
        }
    }

    public void MostrarPadres(Nodos R, char dato, String cadena) {
        if (R != null) {
            if (R.getDato() > dato) {
                cadena += R.getDato();
                MostrarPadres(R.getLi(), dato, cadena);
            } else if (R.getDato() < dato) {
                cadena += R.getDato();
                MostrarPadres(R.getLd(), dato, cadena);
            } else {
                StringBuilder stringbuilder = new StringBuilder(cadena);
                String invertida = stringbuilder.reverse().toString();
                System.out.println(invertida);
            }
        }
    }

    public void MostrarHojas(Nodos R) {
        if (R != null) {
            MostrarHojas(R.getLi());
            if (R.getLd() == null & R.getLi() == null) {
                Mostrar(R.getDato());
            }
            MostrarHojas(R.getLd());
        }
    }

    public void MostrarLi(Nodos R) {
        if (R != null) {
            MostrarLi(R.getLi());
            if (R.getLd() == null & R.getLi() != null) {
                Mostrar(R.getDato());
            }
            MostrarLi(R.getLd());
        }
    }

    public boolean MostrarHermanoDerecho(Nodos R, char dato, boolean bandera) {
        if (R != null) {
            if (R.getLi() != null & R.getLd() != null) {
                if (R.getLi().getDato() == dato) {
                    System.out.print("El hermano Derecho del dato es: ");
                    Mostrar(R.getLd().getDato());
                    System.out.println();
                    bandera = true;
                }
            }
            if (!bandera & R.getDato() > dato) {
                bandera = MostrarHermanoDerecho(R.getLi(), dato, bandera);
            } else if (R.getDato() < dato) {
                bandera = MostrarHermanoDerecho(R.getLd(), dato, bandera);
            }
        }
        if (!bandera & R == getPunta()) {
            System.out.println("El dato no tiene hermano derecho");
        }
        return bandera;
    }

    public boolean MostrarHermanoIzquierdo(Nodos R, char dato, boolean bandera) {
        if (R != null) {
            if (R.getLi() != null & R.getLd() != null) {
                if (R.getLd().getDato() == dato) {
                    System.out.print("El hermano izquierdo del dato es: ");
                    Mostrar(R.getLi().getDato());
                    System.out.println();
                    bandera = true;
                }
            }
            if (!bandera & R.getDato() > dato) {
                bandera = MostrarHermanoIzquierdo(R.getLi(), dato, bandera);
            } else if (R.getDato() < dato) {
                bandera = MostrarHermanoIzquierdo(R.getLd(), dato, bandera);
            }
        }
        if (!bandera & R == getPunta()) {
            System.out.println("El dato no tiene hermano izquierdo");
        }
        return bandera;
    }

    public int ContarHojas(Nodos R,int cont) {
        if (R != null) {
            cont = ContarHojas(R.getLi(),cont);
            cont = ContarHojas(R.getLd(),cont);
            if(R.getLd() == null & R.getLi() == null){
                cont++;
            }
        }
        return cont;
    }

    public int ContarPadres(Nodos R,int cont) {
        if (R != null) {
            cont = ContarPadres(R.getLi(),cont);
            cont = ContarPadres(R.getLd(),cont);
            if(R.getLd() != null | R.getLi() != null){
                cont++;
            }
        }
        return cont;
    }

    public void Altura(char dato){
        Nodos R = Buscardato(getPunta(), dato);
        System.out.println("La altura de "+dato+" es: "+CalcularAltura(R,0));
    }

    public int CalcularAltura(Nodos R, int cont){
        
    }

    public Nodos Buscardato(Nodos R, char dato){
        if (R != null) {
            if (R.getDato() > dato) {
                R = Buscardato(R.getLi(), dato);
            } else if (R.getDato() < dato) {
                R = Buscardato(R.getLd(), dato);
            } else {
                return R;
            }
        }
        return R;
    }
}
