package entites;

public class Dipendente {
    /*
     * numero decimale con stipendio base mensile prevalorizzato
     * a 1000 accessibile a tutte le classi
     */
    protected double stipendioBase;

    /*identificativo univoco del dipendente*/
    private long matricola;

    /*
    * numero decimale con stipendio base mensile
    * calcolato per il diependente
    */
    private  double stipendio;

    /*
    * numero decimale con importo per ogni ora di straordinario
    * */
    private double importoOrarioDecimale;
    public enum Livelli {OPERAIO, IMPIEGATO, QUADRO, DIRIGENTE};
    private  Livelli livello;
    public enum Dipartimenti {PRODUZIONE, AMMINISTRAZIONE, VENDITE}
    private Dipartimenti dipartimento;

    public Dipendente( long idMatricola, Dipartimenti dipartimento) {
        this.stipendioBase = 1000;
        this.matricola = idMatricola;
        this.stipendio= this.stipendioBase;
        this.importoOrarioDecimale=30;
        this.livello= Livelli.OPERAIO;
        this.dipartimento = dipartimento;
    }
public Dipendente(long idMatricola, long stipendio, int ore, Livelli livello, Dipartimenti dipartimento){
        this.stipendioBase = 1000;
        this.matricola= idMatricola;
        this.stipendio = stipendio;
        setImportoOrarioDecimale(ore);
        this.livello = livello;
        setDipartimento(dipartimento);

}
    public double getStipendioBase() {
        return stipendioBase;
    }


    public long getMatricola() {
        return matricola;
    }


    public double getStipendio() {
        return stipendio;
    }


    public double getImportoOrarioDecimale() {
        return importoOrarioDecimale;
    }

    public void setImportoOrarioDecimale(int ore) {
        if(ore>0){
            this.importoOrarioDecimale = ore*12;
        }else{
           this.importoOrarioDecimale= -(ore*12);
        }
    }
public void setDipartimento(Dipartimenti dipartimento){
this.dipartimento = dipartimento;
}
   /* private long setIdMatricola(){
        return (long)(Math.random()*100000000);
    }
    */

 /*
    private void setLivello(){
        if(this.stipendio >=1000 && this.stipendio<1200){
            this.livello= Livelli.OPERAIO;
        }else if(this.stipendio>=1200 && this.stipendio <1400){
            this.livello= Livelli.IMPIEGATO;
        }else if(this.stipendio>=1400 && this.stipendio < 1600){
            this.livello = Livelli.QUADRO;
        }else{
            this.livello= Livelli.DIRIGENTE;
        }
    }
    */

    public Livelli promuovi(){
        switch (this.livello){
            case OPERAIO :{
                this.livello= Livelli.IMPIEGATO;
                this.stipendio = this.stipendioBase*1.2;
                break;
            }
            case IMPIEGATO: {
                this.livello= Livelli.QUADRO;
                this.stipendio = this.stipendioBase*1.5;
                break;
            }
            case QUADRO: {
                this.livello= Livelli.DIRIGENTE;
                this.stipendio = this.stipendioBase*2;
                break;
            }
            case DIRIGENTE:{
                System.out.println("errore non esiste una promozione oltre il dirigente! ");
            }
        }
        return this.livello;
    }

    public void stampaDatiDipendente() {

        System.out.println(
                "Dipendente{" +
                        "stipendioBase=" + stipendioBase +
                        ", matricola=" + matricola +
                        ", stipendio=" + stipendio +
                        ", importoOrarioDecimale=" + importoOrarioDecimale +
                        ", livello=" + livello +
                        ", dipartimento=" + dipartimento +
                        '}');
    }


}
