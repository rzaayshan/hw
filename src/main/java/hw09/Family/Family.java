package hw09.Family;

import hw09.Human.*;
import hw09.Pet.Pet;

import java.util.*;
import java.util.stream.Collectors;

public class Family implements HumanCreator {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pet;

    public Family(Human mother, Human father){
        this.mother=mother;
        this.father=father;
        children=new LinkedList<>();
        pet=new HashSet<>();
        mother.setFamily(this);
        father.setFamily(this);
    }

    public void addChild(Human child){
        children.add(child);
    }

    public boolean deleteChild(Human child){
        if(children.contains(child)){
            children.remove(child);
            return true;
        }
        return false;
    }

    public Human deleteChild(int index){
        if(index>-1 && index<children.size())
            return children.remove(index);
        return new Human();
    }

    public int countMembers(){
        return 2+children.size()+pet.size();
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
        if (o == null) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Family object was deleted");
        super.finalize();
    }

    public Human bornChild(String gender) {
        Human child;
        String []boyName = {"Ramin", "Kənan", "Ruslan", "Eldar"};
        String []girlName = {"Jalə", "Gülşən", "Aidə", "Zümrüd"};

        //int ranNum = (int)(Math.random()*101);
        int name = (int)(Math.random()*4);

        if (gender.toLowerCase().equals("feminine")){
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
