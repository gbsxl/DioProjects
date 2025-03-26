import lombok.Getter;

@Getter
public enum GameLevel {
    EMPTY(0), EASY(40), MIDLEVEL(35), HARD(30), IMPOSSIBLE(20);
    final int valuesToGenerate;

    GameLevel(int valuesToGenerate) {
        this.valuesToGenerate = valuesToGenerate;
    }

}
