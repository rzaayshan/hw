package hw06;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human []children;
    private Pet pet;

    static {
        System.out.println("A new Family class is created");
    }

    Family(Human mother, Human father){
        this.mother=mother;
        this.father=father;
        children=new Human[0];
        System.out.println("A new Family object is created");
    }

    void addChild(Human child){
        int l = children.length;
        Human [] newChildren = new Human[l+1];
        for(int i=0;i<l;i++)
            newChildren[i]=children[i];
        newChildren[l]=child;
        children=newChildren;
        child.setFamily(this);
    }

    boolean deleteChild(Human child){
        int l = children.length;
        if(l==1){
            if(children[0].equals(child)){
                children=new Human[0];
                return true;
            }
            return false;
        }
        else if(l>1){
            Human []newChildren = new Human[l-1];
            int i=0,j=0;
            boolean flag=false;
            for(;i<l;){
                if(children[i].hashCode()==child.hashCode() && children[i].equals(child)){
                    flag=true;
                    i++;}
                else
                    newChildren[j++]=children[i++];
                if(j==l-1)
                    break;
            }
            if (flag) {
                child.setFamily(null);
                children=newChildren;
                return true;
            }}
        return false;
    }

    boolean deleteChild(int index){
        if(index>-1 && index<children.length){
            int l = children.length;
            Human []newChildren = new Human[l-1];
            int j=0;
            for(int i=0;i<l;i++){
                if(i==index)
                    continue;
                newChildren[j++]=children[i];
            }
            children=newChildren;
            return true;
        }
        return false;
    }

    int countFamily(){
        return 2+children.length;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return String.format("Family{mother=%s %s, father=%s %s, children=%s, pet=%s}",
                mother.getName(),mother.getSurname(), father.getName(),father.getSurname(), Arrays.toString(children), pet.getNickname());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father) &&
                Arrays.equals(children, family.children) &&
                Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father, pet);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Family object was deleted");
        super.finalize();
    }
}
