package inter.utilities;

public class Car {

    public Car(String color, String type) {
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String color;

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    // standard getters setters
}