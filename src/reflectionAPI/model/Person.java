package reflectionAPI.model;

public abstract class Person {

    private Long id;

    public Person(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}
