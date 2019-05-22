package treballfinalprogii;

import java.util.Random;


public class Vector {
    

    int x;
    int y;
    double modul;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void Suma(Vector v) { //tb ho puc fer com public Vector Suma (Vector v){ i acabar amb un "return this"}
        x += v.x;
        y += v.y;
    }

    public void Resta(Vector v) {
        x -= v.x;
        y -= v.y;
    }

    public int getX() {
        return x;
    public void Suma (Vector v){ //tb ho puc fer com public Vector Suma (Vector v){ i acabar amb un "return this"}
        x+=v.x;
        y+=v.y;     
    }
    
    public void Resta (Vector v){ 
        x-=v.x;
        y-=v.y;       
    }
    //Normalitzar vector --> fer-lo unitari. Hem de fer el mòdul (arrel quadrada de sumar elements vector al quadrat); 
    // i dividim cada element pel modul.
    public void modul(Vector v){
        double sumaComponentsAlQuadrat = v.x*v.x + v.y*v.y;
        modul = Math.sqrt(sumaComponentsAlQuadrat);
    }
   /*necessitam que la x i la y siguin doubles perque si no peta a sa classe Panell cercles 
    public void Normalitzacio (Vector v){
        x=v.x/modul;
        y=v.y/modul;
    }
    */

        /**
     * Emplena el vector amb valors aleatòris enters entre 0 i vsup
     * @param vsup 
    
    public void ompleAleatori(int vsup) {
        Random rnd = new Random();
        for (int i = 0; i < this.x.length; i++) {
            this.x[i] = rnd.nextInt(vsup); //li passam un valor (vsup) a nextInt, i això farà que es vagi omplint un array
            //amb números aleatoris que no siguin major que el valor superior vsup.
        }
    }

    public double getModul() {
        return modul;
    }

    public void setModul(double modul) {
        this.modul = modul;
    }

    //Normalitzar vector --> fer-lo unitari. Hem de fer el mòdul (arrel quadrada de sumar elements vector al quadrat); 
    // i dividim cada element pel modul.
    public void modul(Vector v) {
        double sumaComponentsAlQuadrat = v.x * v.x + v.y * v.y;
        modul = Math.sqrt(sumaComponentsAlQuadrat);
    }

    /*necessitam que la x i la y siguin doubles perque si no peta a sa classe Panell cercles 
    public void Normalitzacio (Vector v){
        x=v.x/modul;
        y=v.y/modul;
    }
     */
    /**
     * Emplena el vector amb valors aleatòris enters entre 0 i vsup
     *
     * @param vsup * public void ompleAleatori(int vsup) { Random rnd = new
     * Random(); for (int i = 0; i < this.x.length; i++) { this.x[i] =
     * rnd.nextInt(vsup); //li passam un valor (vsup) a nextInt, i això farà que
     * es vagi omplint un array //amb números aleatoris que no siguin major que
     * el valor superior vsup. } }
     *
     */
    @Override
    *  */
   
     @Override
    public String toString() {
        return "Vector{" + "x=" + x + ", y=" + y + '}';
    }
      
      //Mètode que s'aplica a un vector i té com a paràmetre un altre vector.
    //Primer verificam amb un condicional si les dimensions dels 2 vectors coincideixen.
    /*
    public double prodEscalar(Vector v) throws rangsinconsistents {
        if (this.x.length != v.x.length) { //Si no són iguals, activam l'excepció.
            throw new rangsinconsistents("Rangs inconsistents");
        }
        double s = 0;
        for (int i = 0; i < this.x.length; i++) {
            s += this.x[i] * v.x[i];
        }
        return s;
    }
    
    
      public static class RangsInconsistents extends Exception {

    //Mètode que s'aplica a un vector i té com a paràmetre un altre vector.
    //Primer verificam amb un condicional si les dimensions dels 2 vectors coincideixen.
    /*
    public double prodEscalar(Vector v) throws rangsinconsistents {
        if (this.x.length != v.x.length) { //Si no són iguals, activam l'excepció.
            throw new rangsinconsistents("Rangs inconsistents");
        }
        double s = 0;
        for (int i = 0; i < this.x.length; i++) {
            s += this.x[i] * v.x[i];
        }
        return s;
    }
    
    
      public static class RangsInconsistents extends Exception {

        public RangsInconsistents(String s) {
            super(s);
        }
    }
     */
        public RangsInconsistents(String s) {
            super(s);
        }
    }
    */

}
