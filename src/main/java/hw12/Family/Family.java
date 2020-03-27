package hw12.Family;

import hw12.Human.Human;
import hw12.Human.HumanCreator;
import hw12.Human.Woman;
import hw12.Pet.Pet;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Family implements HumanCreator {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pet;
    int id;
    static int num=0;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        children = new LinkedList<>();
        pet = new HashSet<>();
        mother.setFamily(this);
        father.setFamily(this);
        id = ++num;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Family.num = num;
    }

    @Override
    public String toString() {
        return String.format("%d:{mother=%s %s, father=%s %s, children=%s, pet=%s}",
                id,mother.getName(),mother.getSurname(), father.getName(),father.getSurname(),
                children.stream().map(h -> String.format("%s %s", h.getName(),h.getSurname() )).collect(Collectors.toList()),
                pet.stream().map(Pet::getNickname).collect(Collectors.toList()));
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



    public Human bornChild(String gender, String name) {
        Human child;
        if (gender.toLowerCase().equals("feminine")){
            child = new Woman(name,mother.getSurname(), LocalDate.now(),(mother.getIq()+father.getIq())/2);
        }
        else{
            child =  new Woman(name,father.getSurname(), LocalDate.now(),(mother.getIq()+father.getIq())/2);
        }
        this.addChild(child);
        child.setFamily(this);
        return child;
    }

    public String prettyFormat(){
        return String.format("family:\n\tmother:%s\n\tfather:%s\n\tchildren:\n%s\n\tpets:%s",
                mother,father,children.stream().map(c->c.getGender().
                        equals("feminine") ? String.format("\t\t\tgirl %s", c) : String.format("\t\t\tboy %s", c)).
                        collect(Collectors.joining("\n")),pet.stream().map(p->p.toString()).
                        collect(Collectors.joining(",")));
    }
}
