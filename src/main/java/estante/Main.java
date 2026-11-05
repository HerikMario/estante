package estante;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Catálogo ===");

        Obra obra1 = new Obra("O Eternauta", TipoObra.QUADRINHO, 1957);
        Obra obra2 = new Obra("O Hobbit", TipoObra.LIVRO, 1937);
        Obra obra3 = new Obra("Um Sonho de Liberdade", TipoObra.FILME, 1994);
        Obra obra4 = new Obra("Dragon Ball Vol. 1", TipoObra.MANGA, 1985);
        Obra obra5 = new Obra("God Of War", TipoObra.JOGO, 2018);

        obra1.comecar();
        obra1.terminar(9);   // terminada, com nota
        obra2.comecar();     // em andamento
        obra5.comecar();     // em andamento
        // obra3 e obra4 continuam na fila

        System.out.println(obra1);
        System.out.println(obra2);
        System.out.println(obra3);
        System.out.println(obra4);
        System.out.println(obra5);

        System.out.println();
        System.out.println("=== Ações proibidas ===");

        try {
            new Obra("", TipoObra.LIVRO, 2000);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Cadastrar obra sem título → " + e.getMessage());
        }

        try {
            new Obra("Filme do Futuro", TipoObra.FILME, 2030);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Cadastrar obra com ano no futuro → " + e.getMessage());
        }

        try {
            new Obra("Obra Sem Tipo", null, 2000);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Cadastrar obra com tipo nulo → " + e.getMessage());
        }

        try {
            obra3.terminar(8);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Terminar obra que nem começou → " + e.getMessage());
        }

        try {
            obra4.terminar(7);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Dar nota a obra na fila → " + e.getMessage());
        }

        try {
            obra1.comecar();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Começar obra já terminada → " + e.getMessage());
        }

        try {
            obra2.comecar();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Começar obra já em andamento → " + e.getMessage());
        }

        try {
            obra5.terminar(11);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Terminar com nota fora de 1 a 10 → " + e.getMessage());
        }
        System.out.println("Estado do God of War após a recusa → " + obra5);
    }
}