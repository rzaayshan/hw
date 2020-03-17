package hw08;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Family implements HumanCreator {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pet;

    static {
        System.out.println("A new Family class is created");
    }

    Family(Human mother, Human father){
        this.mother=mother;
        this.father=father;
        children=new LinkedList<>();
        mother.setFamily(this);
        father.setFamily(this);
        System.out.println("A new Family object is created");
    }

    void addChild(Human child){
        children.add(child);
    }

    boolean deleteChild(Human child){
        if(children.contains(child)){
            children.remove(child);
            return true;
        }
        return false;
    }

    Human deleteChild(int index){
        if(index>-1 && index<children.size())
            return children.remove(index);
        return new Human();
    }

    int countFamily(){
        return 2+children.size();
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

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Set<Pet> getPet() {
        return pet;
    }

    public void setPet(Set<Pet> pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return String.format("Family{mother=%s %s, father=%s %s, children=%s, pet=%s}",
                mother.getName(),mother.getSurname(), father.getName(),father.getSurname(),
                children.stream().map(h -> String.format("%s %s", h.getName(),h.getSurname() )).collect(Collectors.toList()),
                pet.stream().map(p -> p.getNickname()).collect(Collectors.toList()));
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

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Family object was deleted");
        super.finalize();
    }

    @Override
    public Human bornChild() {
        Human child;
        String []boyName = {"Ramin", "Kənan", "Ruslan", "Eldar"};
        String []girlName = {"Jalə", "Gülşən", "Aidə", "Zümrüd"};

        int ranNum = (int)(Math.random()*101);
        int name = (int)(Math.random()*4);

        if (ranNum>49){
            child = new Woman();
            child.setName(girlName[name]);
            child.setSurname(mother.getSurname());
        }
        else{
            child = new Man();
            child.setName(boyName[name]);
            child.setSurname(father.getSurname());
        }

        child.setIq((mother.getIq()+father.getIq())/2);
        child.setYear(2020);

        this.addChild(child);
        child.setFamily(this);

        return child;

    }
}
