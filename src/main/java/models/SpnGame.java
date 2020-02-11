package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SpnGame extends Game {
    @JsonCreator
    public SpnGame() {
            cols = new Column();
            deck = new Spanish();
    }
}
