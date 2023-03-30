package edu.miu.webSocket;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Chat {

    @Id
    private Integer id;
    private String massage;
    public Chat(){}

    public Chat(Integer id, String massage) {
        this.id = id;
        this.massage = massage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
