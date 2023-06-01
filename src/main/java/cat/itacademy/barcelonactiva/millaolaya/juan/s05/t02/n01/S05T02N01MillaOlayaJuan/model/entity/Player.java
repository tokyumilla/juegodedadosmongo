package cat.itacademy.barcelonactiva.millaolaya.juan.s05.t02.n01.S05T02N01MillaOlayaJuan.model.entity;


import org.springframework.data.annotation.CreatedDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;


@Document ("Players")
public class Player {
    @Id
    private String id;

    private String name;

    @CreatedDate
    private Instant registerDate;


    private List<Roll> rolls;

    public Player (){}

    public Player(String id, String name, List<Roll> rolls) {
        this.id = id;
        this.name = name;
        this.rolls = rolls;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getRegisterDate() {
        return registerDate;
    }

    public List<Roll> getRolls() {
        return rolls;
    }

    public void setRolls(List<Roll> rolls) {
        this.rolls = rolls;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registerDate=" + registerDate +
                ", rolls=" + rolls +
                '}';
    }
}
