package rmi;

import java.io.Serializable;
import java.util.UUID;

public class Message implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String nome;
    private String message;
    private UUID id;

    public Message(String nome, String message, UUID id) {
        this.nome = nome;
        this.message = message;
        this.id = id;
    }
    
    public String getNome() {
        return this.nome;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UUID getId() {
        return this.id;
    }

}
