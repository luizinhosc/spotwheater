package spotwheater.util;

import spotwheater.model.Value;

public class SpotWheaterJson {


    private String base;

    private Value main;

    public SpotWheaterJson() {

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
}
