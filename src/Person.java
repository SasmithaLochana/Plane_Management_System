public class Person {
    private String name;
    private String surname;
    private String email;

    public Person (String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;

    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(){
        this.surname = surname;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(){
        this.email = email;
    }

    public void printInfo (){
        System.out.println("Person Info");
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("E-mail: " + email);
    }

}