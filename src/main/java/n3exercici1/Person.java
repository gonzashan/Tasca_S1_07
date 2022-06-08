
package n3exercici1;

@JsonFile
@JsonPathFile
@JsonSerializable(action = "Reading annotation", value = "@JsonSerializable")
public class Person {
    @JsonElement
    private String firstName;
    @JsonElement
    private String lastName;
    @JsonElement(key = "Edad")
    private String age;
    @JsonElement(key = "Dirección")
    private String address;

    public Person(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(String firstName, String lastName, String age, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    @Init
    private void initNames() {
        this.firstName = this.firstName.substring(0, 1)
                .toUpperCase() + this.firstName.substring(1);
        this.lastName = this.lastName.substring(0, 1)
                .toUpperCase() + this.lastName.substring(1);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}