package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EngGame extends Game {
    @JsonCreator
    public EngGame() {
        cols = new Column();
        deck = new English();
    }
}