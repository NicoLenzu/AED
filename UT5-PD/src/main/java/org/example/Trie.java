package PD3;

import PD3.utils.FileReaderAED;

public class Trie {
    private static final int TAMANIO_ALFABETO = 26;
    private static final int LINEAS_POR_PAGINA = 50;

    private static class NodoTrie {
        NodoTrie[] hijos;
        boolean esFinal;
        ListaPaginas paginas;

        public NodoTrie() {
            this.hijos = new NodoTrie[TAMANIO_ALFABETO];
            this.esFinal = false;
            this.paginas = new ListaPaginas();
        }
    }

    private static class NodoPagina {
        int numeroPagina;
        NodoPagina siguiente;

        public NodoPagina(int numeroPagina) {
            this.numeroPagina = numeroPagina;
            this.siguiente = null;
        }
    }

    private static class ListaPaginas {
        NodoPagina inicio;

        public ListaPaginas() {
            this.inicio = null;
        }

        public void agregar(int numeroPagina) {
            if (!contiene(numeroPagina)) {
                NodoPagina nuevo = new NodoPagina(numeroPagina);
                if (inicio == null || numeroPagina < inicio.numeroPagina) {
                    nuevo.siguiente = inicio;
                    inicio = nuevo;
                } else {
                    NodoPagina actual = inicio;
                    while (actual.siguiente != null && actual.siguiente.numeroPagina < numeroPagina) {
                        actual = actual.siguiente;
                    }
                    nuevo.siguiente = actual.siguiente;
                    actual.siguiente = nuevo;
                }
            }
        }

        public boolean contiene(int numeroPagina) {
            NodoPagina actual = inicio;
            while (actual != null) {
                if (actual.numeroPagina == numeroPagina) {
                    return true;
                }
                actual = actual.siguiente;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            NodoPagina actual = inicio;
            while (actual != null) {
                sb.append(actual.numeroPagina).append(" ");
                actual = actual.siguiente;
            }
            return sb.toString().trim();
        }
    }

    private NodoTrie raiz;

    public Trie() {
        this.raiz = new NodoTrie();
    }

    private int obtenerIndice(char c) {
        return Character.toLowerCase(c) - 'a';
    }

    public void insertar(String palabra) {
        NodoTrie nodo = raiz;
        for (char c : palabra.toLowerCase().toCharArray()) {
            int indice = obtenerIndice(c);
            if (indice >= 0 && indice < TAMANIO_ALFABETO) {
                if (nodo.hijos[indice] == null) {
                    nodo.hijos[indice] = new NodoTrie();
                }
                nodo = nodo.hijos[indice];
            }
        }
        nodo.esFinal = true;
    }

    public static class ResultadoBusqueda {
        private boolean existe;
        private int comparaciones;
        private String palabra;
        private String paginas;

        public ResultadoBusqueda(boolean existe, int comparaciones, String palabra, String paginas) {
            this.existe = existe;
            this.comparaciones = comparaciones;
            this.palabra = palabra;
            this.paginas = paginas;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Palabra: ").append(palabra).append("\n");
            sb.append("Existe en el índice: ").append(existe).append("\n");
            sb.append("Número de comparaciones: ").append(comparaciones).append("\n");
            if (existe) {
                sb.append("Páginas: ").append(paginas);
            }
            return sb.toString();
        }
    }

    public ResultadoBusqueda buscar(String palabra) {
        int comparaciones = 0;
        NodoTrie nodo = raiz;
        String palabraLimpia = palabra.replaceAll("[^a-zA-Z]", "").toLowerCase();
        
        for (char c : palabraLimpia.toCharArray()) {
            int indice = obtenerIndice(c);
            comparaciones++;
            if (indice < 0 || indice >= TAMANIO_ALFABETO || nodo.hijos[indice] == null) {
                return new ResultadoBusqueda(false, comparaciones, palabraLimpia, "");
            }
            nodo = nodo.hijos[indice];
        }
        
        boolean existe = nodo.esFinal;
        String paginas = existe ? nodo.paginas.toString() : "";
        return new ResultadoBusqueda(existe, comparaciones, palabraLimpia, paginas);
    }

    public boolean agregarPagina(String palabra, int numeroPagina) {
        String palabraLimpia = palabra.replaceAll("[^a-zA-Z]", "").toLowerCase();
        NodoTrie nodo = raiz;
        
        for (char c : palabraLimpia.toCharArray()) {
            int indice = obtenerIndice(c);
            if (indice < 0 || indice >= TAMANIO_ALFABETO || nodo.hijos[indice] == null) {
                return false;
            }
            nodo = nodo.hijos[indice];
        }
        
        if (nodo.esFinal) {
            nodo.paginas.agregar(numeroPagina);
            return true;
        }
        return false;
    }

    public void indizarLibro(String nombreArchivo) {
        String[] lineas = FileReaderAED.leerArchivo(nombreArchivo);
        int numeroLinea = 0;
        int numeroPagina = 1;

        for (String linea : lineas) {
            numeroLinea++;
            if (numeroLinea > LINEAS_POR_PAGINA) {
                numeroPagina++;
                numeroLinea = 1;
            }

            String[] palabras = linea.split("\\s+");
            for (String palabra : palabras) {
                String palabraLimpia = palabra.replaceAll("[^a-zA-Z]", "").toLowerCase();
                if (!palabraLimpia.isEmpty()) {
                    agregarPagina(palabraLimpia, numeroPagina);
                }
            }
        }
    }

    public void imprimirIndice() {
        imprimirRecursivo(raiz, "");
    }

    private void imprimirRecursivo(NodoTrie nodo, String palabraActual) {
        if (nodo.esFinal) {
            System.out.println(palabraActual + ": " + nodo.paginas.toString());
        }

        for (int i = 0; i < TAMANIO_ALFABETO; i++) {
            if (nodo.hijos[i] != null) {
                imprimirRecursivo(nodo.hijos[i], palabraActual + (char)('a' + i));
            }
        }
    }

    public void cargarPalabrasIndice(String nombreArchivo) {
        String[] palabras = FileReaderAED.leerArchivo(nombreArchivo);
        for (String palabra : palabras) {
            palabra = palabra.trim();
            if (!palabra.isEmpty()) {
                insertar(palabra);
            }
        }
    }
} 