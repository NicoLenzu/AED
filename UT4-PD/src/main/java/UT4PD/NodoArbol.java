package UT4PD;

public class NodoArbol<T> {
    private T dato;

    public void setIzq(NodoArbol<T> izq) {
        this.izq = izq;
    }

    public void setDer(NodoArbol<T> der) {
        this.der = der;
    }

    private NodoArbol<T> izq;
    private NodoArbol<T> der;

    private Comparable<T> id;

    public NodoArbol(T dato) {
        this.dato = dato;
        this.id = (Comparable<T>) dato;
    }
    public T getDato() {
        return dato;
    }
    public NodoArbol<T> getDer() {
        return der;
    }
    public NodoArbol<T> getIzq() {
        return izq;
    }
    public Comparable<T> getId() {
        return id;
    }
    public boolean esHoja() {
        return izq == null && der == null;
    }
    public int altura()
    {
        NodoArbol<T> nodoAct = this;
        int A = -1;
        int B = -1;
        if (nodoAct.getIzq() != null) {
            A = nodoAct.getIzq().altura();
        }
        if (nodoAct.getDer() != null) {
            B = nodoAct.getDer().altura();
        }
        return Math.max(A, B) + 1;
    }
    public int hojas()
    {
        NodoArbol<T> nodoAct = this;
        int hojas = 0;
        if (nodoAct.esHoja()) {
            hojas++;
        }
        if (nodoAct.getIzq() != null) {
            hojas += nodoAct.getIzq().hojas();
        }
        if (nodoAct.getDer() != null) {
            hojas += nodoAct.getDer().hojas();
        }
        return hojas;
    }
    public int internos()
    {
        int internos = 0;
        NodoArbol<T> nodoAct = this;
        if (!nodoAct.esHoja()) {
            internos++;
        }
        if (nodoAct.getIzq() != null) {
            internos += nodoAct.getIzq().hojas();
        }
        if (nodoAct.getDer() != null) {
            internos += nodoAct.getDer().hojas();
        }
        return internos;
    }
    public int completos(){
        NodoArbol<T> nodoAct = this;
        int completos = 0;
        if (nodoAct.getDer() != null && nodoAct.getIzq() != null) {
            completos++;
        }
        if (nodoAct.getIzq() != null) {
            completos += nodoAct.getIzq().completos();
        }
        if (nodoAct.getDer() != null) {
            completos += nodoAct.getDer().completos();
        }
        return completos;


    }
    public void inOrder(){
        NodoArbol<T> nodoAct = this;
        if (nodoAct != null) {
            if (nodoAct.getIzq() != null){
                nodoAct.getIzq().inOrder();}
            System.out.println(nodoAct.getDato());
            if(nodoAct.getDer() != null){
                nodoAct.getDer().inOrder();}
        }
    }
    public void preOrder(){
        NodoArbol<T> nodoAct = this;
        if (nodoAct != null) {
            System.out.println(nodoAct.getDato());
            if (nodoAct.getIzq() != null){
            nodoAct.getIzq().preOrder();}
            if (nodoAct.getDer() != null){
            nodoAct.getDer().preOrder();}
        }
    }
    public void postOrder(){
        NodoArbol<T> nodoAct = this;
        if (nodoAct != null) {
            if (nodoAct.getIzq() != null){
            nodoAct.getIzq().postOrder();}
            if (nodoAct.getDer() != null){
            nodoAct.getDer().postOrder();}
            System.out.println(nodoAct.getDato());
        }
    }
    public int evalExpr(){
        NodoArbol<T> NodoAct = this;
        if (NodoAct.esHoja()){
            return (int)NodoAct.getDato();
        }
        else{
            int x = NodoAct.getIzq().evalExpr();
            int y = NodoAct.getDer().evalExpr();
            return switch ((String) NodoAct.getDato()) {
                case "*" -> x * y;
                case "/" -> x / y;
                case "+" -> x + y;
                case "-" -> x - y;
                default -> 0;
            };
        }
    }
    public NodoArbol eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.getId()) < 0) {
            if (this.getIzq() != null) {
                this.setIzq(this.getIzq().eliminar(unaEtiqueta));
            }
            return this;
        }

        if (unaEtiqueta.compareTo(this.getId()) > 0) {
            if (this.getDer() != null) {
                this.setDer(this.getDer().eliminar(unaEtiqueta));
            }
            return this;
        }

        return quitarNodo(this);
    }
    
    public NodoArbol quitarNodo(NodoArbol unNodo) {
        if (this.getIzq() == null) {
            return getDer();
        }

        if (this.getDer() == null) {
            return this.getIzq();
        }

        NodoArbol elHijo = this.getIzq();
        NodoArbol elPadre = this;
        while (elHijo.getDer() != null) {
            elPadre = elHijo;
            elHijo = elHijo.getDer();
        }

        if (elPadre != this) {
            elPadre.setDer(elHijo.getIzq());
            elHijo.setIzq(this.getIzq());
        }

        elHijo.setIzq(getDer());
        return elHijo;
    }

}
