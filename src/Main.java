import entites.Dipendente;

public class Main {
    public static void main(String[] args) {
        Dipendente max = new Dipendente(00001, 1200, 0, Dipendente.Livelli.IMPIEGATO, Dipendente.Dipartimenti.VENDITE );
        max.stampaDatiDipendente();
        System.out.println(max.promuovi());
        max.stampaDatiDipendente();
    }
}
