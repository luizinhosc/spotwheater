package spotwheater.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import spotwheater.util.SpotWheaterView;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpotWheater {

    @JsonView(SpotWheaterView.SpotWheaterSimple.class)
    private String base;
    @JsonView(SpotWheaterView.SpotWheaterSimple.class)
    private Value main;

    public SpotWheater() {
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Value getMain() {
        return main;
    }

    public void setMain(Value main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "SpotWheater{" +
                "base='" + base + '\'' +
                ", main=" + main +
                '}';
    }
}
