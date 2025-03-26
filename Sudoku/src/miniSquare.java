import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class miniSquare {
    private int number = 0;

    @Override
    public String toString() {
        return number + ", ";
    }
}
