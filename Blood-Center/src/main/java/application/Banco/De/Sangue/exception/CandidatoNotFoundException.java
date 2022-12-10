package application.Banco.De.Sangue.exception;

public class CandidatoNotFoundException extends RuntimeException{

    public CandidatoNotFoundException(String mensagem) {
        super(mensagem);
    }
}
