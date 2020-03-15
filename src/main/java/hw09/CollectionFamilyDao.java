package hw09;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    List <Family> families = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return families.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        if(!(index>0 && index<families.size()))
            return false;
        families.remove(index);
        return true;
    }

    @Override
    public boolean deleteFamily(Family family) {
        if(!families.contains(family))
            return false;
        families.remove(family);
        return true;
    }

    @Override
    public void saveFamily(Family family) {
        if(!families.contains(family))
            families.add(family);

    }
}
