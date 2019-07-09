package spotwheater.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import spotwheater.util.SpotWheaterView;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

    @JsonView(SpotWheaterView.SpotWheaterSimple.class)
    private double temp; //280.15,
    private int   pressure; // 1024,
    private int  humidit; // 87,
    private float temp_min; // 280.15,
    private float temp_max; // 280.15

    public Value() {
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidit() {
        return humidit;
    }

    public void setHumidit(int humidit) {
        this.humidit = humidit;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }

    @Override
    public String toString() {
        return "Value{" +
                "temp=" + temp +
                ", pressure=" + pressure +
                ", humidit=" + humidit +
                ", temp_min=" + temp_min +
                ", temp_max=" + temp_max +
                '}';
    }
}
