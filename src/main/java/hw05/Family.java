package hw05;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human []children;
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
        Human []newChildren = new Human[childNumber+1];
        for(int i=0;i<childNumber;i++)
            newChildren[i]=children[i];
        newChildren[childNumber++]=child;
        child.setFamily(this);
        children=newChildren;
    }

    boolean deleteChild(Human child){
        if(childNumber<1)
            return false;
        Human []newChildren = new Human[childNumber-1];
        for(int i=0;i<childNumber-1;i++){
            if(children[i].hashCode()!=child.hashCode())           //I wrote it like this to show
                newChildren[i]=children[i];                         //hashcode's and equals's differences
            if(children[i].hashCode()==child.hashCode()){
                if(children.equals(child))
                    continue;
                else
                    newChildren[i]=children[i];}
        }
        child.setFamily(null);
        childNumber--;
        children=newChildren;
        return true;
    }

    int countFamily(){
        return(childNumber+2);
    }
    String[]childrenArray(){
        String[]a = new String[childNumber];
        for(int j=0;j<childNumber;j++)
            a[j]=children[j].getName()+" "+children[j].getSurname();
        return a;
    }

    public String toString(){
        return String.format("Family{Father: %s %s, Mother: %s %s, Children: %s, Members: %d}", father.getName(),father.getSurname(),
                mother.getName(), mother.getSurname(), Arrays.toString(childrenArray()),countFamily());
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
