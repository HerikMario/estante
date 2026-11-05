package estante;

public class Obra {
    //Atributos
    private String titulo;
    private TipoObra tipo;
    private int anoLancamento;
    private StatusObra status;
    private Integer nota;

    //Construtores
    public Obra(String titulo, TipoObra tipo, int anoLancamento) {
        this.titulo = validarTitulo(titulo);
        this.tipo = validarTipo(tipo);
        this.anoLancamento = validarAnoLancamento(anoLancamento);
        this.status = StatusObra.QUERO;
        this.nota = null;
    }

    //Métodos públicos
    public void comecar(){
        if(status == StatusObra.EM_ANDAMENTO){
            throw new IllegalStateException("A obra já está em andamento");
        }
        if(status == StatusObra.CONCLUIDO){
            throw new IllegalStateException("A obra já foi concluída");
        }
        status = StatusObra.EM_ANDAMENTO;
    }

    public void terminar(int nota){
        if(status == StatusObra.QUERO){
            throw new IllegalStateException("A obra precisa ser iniciada para ser concluída");
        }
        if(status == StatusObra.CONCLUIDO){
            throw new IllegalStateException("A obra já foi concluída");
        }
        darNota(nota);
        status = StatusObra.CONCLUIDO;
    }

    //Métodos privados
    private String validarTitulo(String titulo){
        if (titulo == null || titulo.isBlank()){
            throw new IllegalArgumentException("A obra precisa de um titulo para existir");
        }
        return titulo;
    }

    private int validarAnoLancamento(int anoLancamento){
        if (anoLancamento < 1800 || anoLancamento > java.time.Year.now().getValue()){
            throw new IllegalArgumentException(String.format("O ano do lançamento precisa estar entre 1800 e %d", java.time.Year.now().getValue()));
        }
        return anoLancamento;
    }

    private TipoObra validarTipo(TipoObra tipo){
        if (tipo == null){
            throw new IllegalArgumentException("A obra precisa de um tipo para existir");
        }
        return tipo;
    }

    private void darNota(int nota){
        if (this.nota != null) {
            throw new IllegalStateException("A obra já possui uma nota");
        }
        if (nota < 1 || nota > 10){
            throw new IllegalArgumentException("A nota precisa estar entre 1 e 10");
        }
        this.nota = nota;
    }

    //Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public TipoObra getTipo() {
        return tipo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public StatusObra getStatus() {
        return status;
    }

    public Integer getNota() {
        return nota;
    }

    //toString
    @Override
    public String toString() {
        String notaTexto = (nota == null) ? "sem nota" : nota + "/10";
        return String.format("%s (%s, %d) - %s - Nota: %s",
                titulo, tipo, anoLancamento, status, notaTexto);
    }
}
