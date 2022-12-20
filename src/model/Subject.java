package model;

public class Subject {
    private static int _id = 1;
    private int id;
    private String name;
    private int currentNumber;
    private int maxNumber;

    public Subject(int id) {
        this.id = id;
        this.currentNumber = -1; // Khong xac dinh
        this.maxNumber = -1; // Khong xac dinh
    }

    public Subject(String name, int currentNumber, int maxNumber) {
        this.id = _id++;
        this.name = name;
        this.currentNumber = currentNumber;
        this.maxNumber = maxNumber;
    }

    public Subject(String name, int maxNumber) {
        this.id = _id++;
        this.name = name;
        this.currentNumber = 0;
        this.maxNumber = maxNumber;
    }

    @Override
    public String toString() {
        return "Subject: \n\t Id:" + id + "\n\t Mon hoc :" + name + "\n\t So nguoi hien tai :" + currentNumber + "\n\t So nguoi dang ky toi da :" + maxNumber + "\n";

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }
}
