package lambda_exercise;

public class Vehicle {

    private String type;
    private String brand;
    private int year;

    public Vehicle(String type, String brand, int year) {
        this.type = type;
        this.brand = brand;
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vehicle{");
        sb.append("type='").append(type).append('\'');
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", year=").append(year);
        sb.append('}');
        return sb.toString();
    }
}
