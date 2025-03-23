package org.example;
public class Marcapasos {

    private byte ps;                                // 1 byte
    private byte fc;                                // 1 byte
    private short as;                               // 2 bytes
    private int maxFuerza;                          // 4 bytes
    private float minLatidos;                       // 4 bytes
    private double batRestante;                     // 8 bytes
    private char[] codFabricante = new char[8];     // 8 bytes

    public Marcapasos(int ps,int fc,int as) {
        if (!(ps>250 || fc>226 || as>1000)) {
            setPs(ps);
            setFc(fc);
            setAs(as);
        }
    }
    public int getPs() {
        return ps + 256;
    }
    public int getFc() {
        return fc + 256;
    }
    public short getAs() {
        return as;
    }
    public long getMaxFuerza() {
        if (maxFuerza<0){
            return maxFuerza + (4294967296L); // = 2^32
        }
        return maxFuerza;

    }
    public float getMinLatidos() {
        return minLatidos;
    }
    public double getBatRestante() {
        return batRestante;
    }

    public void setPs(int ps) {
        this.ps = (byte)ps;
    }
    public void setFc(int fc) {
        this.fc = (byte)fc;
    }
    public void setAs(int as) {
        this.as = (short)as;
    }
    public void setMaxFuerza(long maxFuerza) {
        this.maxFuerza = (int)maxFuerza ;
    }
    public void setMinLatidos(float minLatidos) {
        this.minLatidos = minLatidos;
    }
    public void setBatRestante(double batRestante) {
        this.batRestante = batRestante;
    }
    public void setCodFabricante(String codigo) {
        for(int i=0;i<codigo.length();i++){
            codFabricante[i] = codigo.charAt(i); // Recorro el string y guardo cada caracter en el array de Chars
        }
    }
    public void setCodFabricante(char[] codigo) {
        for (int i = 0; i <= 8 ; i++) {
            if (i<=codigo.length){
                codFabricante[i] = codigo[i];
            }
            else{
                break;
            }
        }
    }

    public String toString() {
        return "ps: "+getPs()+" fc: "+getFc()+" as: "+getAs()+ " maxFuerza: "+getMaxFuerza()+" minLatidos: "+getMinLatidos()+" batRestante: "+getBatRestante();
    }
}
