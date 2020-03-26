package hw09.Family;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionFamilyDao implements FamilyDAO {
    private List<Family> families;

    public CollectionFamilyDao(){
        families=new LinkedList<>();
    }

    public CollectionFamilyDao(List<Family> families){
        this.families=families;
    }


    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyById(int id) {
        return families.get(id);
    }

    @Override
    public boolean deleteFamily(int index) {
        if(index<0 || index>families.size())
            return false;
        families.remove(index);
        return true;
    }

    @Override
    public boolean deleteFamily(Family family) {
        if(families.contains(family)){
            families.remove(family);
            return true;
        }
        return false;
    }

    @Override
    public void saveFamily(Family family) {
        families.add(family);
    }

    public List<Family> getFamilyBy(Predicate<Family> p){
        return getAllFamilies().stream().filter(p).collect(Collectors.toList());
    }
}
