package org.example.classes;

public class Man implements Person{

    private String name;
    private String city;
    private String country;
    private String age;

    public Man(String name, String age, String city, String country){
        this.city = city;
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public void introduce(String name) {
        System.out.println(name);

    }

    @Override
    public void sayAge(String age) {
        System.out.println(age);

    }

    @Override
    public void sayWhereFrom(String city, String country) {
        System.out.println(city);
        System.out.println(country);

    }
}
