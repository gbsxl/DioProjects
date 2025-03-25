import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class Bloquinho {
    private int number = 0;

    @Override
    public String toString() {
        return number + ", ";
    }
}
