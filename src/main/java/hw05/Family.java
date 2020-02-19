package hw05;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human []children = new Human[5];
    private Pet pet;
    private int childNumber=0;
    Family(Human father, Human mother){
        this.mother=mother;
        this.father=father;
    }
    static {
        System.out.println("Family class is being loaded");
    }
    {
        System.out.println("Object of family class is created");
    }
    void setMother(Human mother){
        this.mother=mother;
    }
    Human getMother(){
        return this.mother;
    }
    void setFather(Human father){
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


    Human[] getChildren(){
        return children;
    }

    void addChild(Human child) {
        this.children[childNumber] = child;
        child.family = this;
        childNumber++;
    }
    boolean deleteChild(Human child){
        for(int j=0;j<childNumber;j++)
            if(children[j].hashCode()==child.hashCode()){
                children[j]=null;
                childNumber--;
                return true;
            }
        return false;
    }

    int countFamily(){
        return(childNumber+2);
    }
    java.lang.String[]childrenArray(){
        java.lang.String[]a = new java.lang.String[childNumber];
        for(int j=0;j<childNumber;j++)
            a[j]=children[j].getName()+" "+children[j].getSurname();
        return a;
    }

    public java.lang.String toString(){
        return String.format("Family{Father: %s %s, Mother: %s %s, Children: %s}", father.getName(),father.getSurname(),
                mother.getName(), mother.getSurname(), Arrays.toString(childrenArray()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return childNumber == family.childNumber &&
                Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father) &&
                Arrays.equals(children, family.children) &&
                Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father, pet, childNumber);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }
}
