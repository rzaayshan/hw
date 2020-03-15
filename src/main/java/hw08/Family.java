package hw08;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Family {
    private Woman mother;
    private Man father;
    private List<Human> children;
    private Pet pet;
    Family(Man father, Woman mother){
        this.mother=mother;
        this.father=father;
        createChildren();
    }
    static {
        System.out.println("Family class is being loaded");
    }
    {
        System.out.println("Object of family class is created");
    }
    void setMother(Woman mother){
        this.mother=mother;
    }
    Human getMother(){
        return this.mother;
    }
    void setFather(Man father){
        this.father=father;
    }
    Human getFather(){
        return this.father;
    }
    void setPet(Pet pet){
        this.pet=pet;
    }
    Pet getPet(){
        return this.pet;
    }

    List <Human> getChildren(){
        return children;
    }

    void createChildren(){
        children = new LinkedList<>();
    }

    void addChild(Human child) {
        children.add(child);
        child.setFamily(this);
    }

    boolean deleteChild(Human child){
        children.remove(child);
        return true;
       }

    void deleteChild(int index){
       children.remove(index);
    }

    int countFamily(){
        return (2+children.size());
    }


    public String toString(){
        return String.format("Family{Father: %s %s, Mother: %s %s, Children: %s, Members: %d}", father.getName(),father.getSurname(),
                mother.getName(), mother.getSurname(), children,countFamily());
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object of family is deleted");
        super.finalize();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father) &&
                Objects.equals(children, family.children) &&
                Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children, pet);
    }
}
