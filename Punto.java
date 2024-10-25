public class Punto {
    private double pregnancies;
    private double glucose;
    private double bloodPressure;
    private double skinThickness;
    private double insulin;
    private double bmi;
    private double diabetesPedigreeFunction;
    private double age;

    public Punto(double pregnancies, double glucose, double bloodPressure, double skinThickness,
                 double insulin, double bmi, double diabetesPedigreeFunction, double age) {
        this.pregnancies = pregnancies;
        this.glucose = glucose;
        this.bloodPressure = bloodPressure;
        this.skinThickness = skinThickness;
        this.insulin = insulin;
        this.bmi = bmi;
        this.diabetesPedigreeFunction = diabetesPedigreeFunction;
        this.age = age;
    }

    // Getters
    public double getPregnancies() { return pregnancies; }
    public double getGlucose() { return glucose; }
    public double getBloodPressure() { return bloodPressure; }
    public double getSkinThickness() { return skinThickness; }
    public double getInsulin() { return insulin; }
    public double getBmi() { return bmi; }
    public double getDiabetesPedigreeFunction() { return diabetesPedigreeFunction; }
    public double getAge() { return age; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Punto punto = (Punto) obj;
        return Double.compare(punto.pregnancies, pregnancies) == 0 &&
               Double.compare(punto.glucose, glucose) == 0 &&
               Double.compare(punto.bloodPressure, bloodPressure) == 0 &&
               Double.compare(punto.skinThickness, skinThickness) == 0 &&
               Double.compare(punto.insulin, insulin) == 0 &&
               Double.compare(punto.bmi, bmi) == 0 &&
               Double.compare(punto.diabetesPedigreeFunction, diabetesPedigreeFunction) == 0 &&
               Double.compare(punto.age, age) == 0;
    }

    @Override
    public String toString() {
        return String.format("Punto{pregnancies=%.2f, glucose=%.2f, bloodPressure=%.2f, skinThickness=%.2f, insulin=%.2f, bmi=%.2f, diabetesPedigreeFunction=%.2f, age=%.2f}",
                pregnancies, glucose, bloodPressure, skinThickness, insulin, bmi, diabetesPedigreeFunction, age);
    }
}