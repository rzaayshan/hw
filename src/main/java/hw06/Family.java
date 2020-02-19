package hw06;



import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human []children = new Human[5];
    private Pet pet;
    private int i=0;
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
        Human []a = new Human[i];
        for(int j=0;j<i;j++)
            a[j]=children[j];
        return a;
    }

    void addChild(Human child) {
        this.children[i] = child;
        child.family = this;
        i++;
    }
    boolean deleteChild(Human child){
        for(int j=0;j<i;j++)
            if(children[j].hashCode()==child.hashCode()){
                children[j]=null;
                i--;
                return true;
            }
        return false;
    }
    String deleteChild(int index){
        if(index>0 && index<i){
            Human k = children[i];
            children[i]=null;
            i--;
            return k.toString();
        }
        System.out.println("There isn't any change");
        return null;
    }

    int countFamily(){
        return(i+2);
    }

    String []childrenArray(){
        String []a = new String [i];
        for(int j=0;j<i;j++)
            a[j]=children[j].getName()+" "+children[j].getSurname();
        return a;
    }

    public String toString(){
        return String.format("Family{Father: %s %s, Mother: %s %s, Children: %s}", father.getName(),father.getSurname(),
                mother.getName(), mother.getSurname(), Arrays.toString(childrenArray()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return i == family.i &&
                Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father) &&
                Arrays.equals(children, family.children) &&
                Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father, pet, i);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }
    public void finalize() {
        System.out.println("Family removed");

    }

}
