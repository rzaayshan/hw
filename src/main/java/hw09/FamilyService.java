package hw09;

import java.util.List;
import java.util.Set;

public class FamilyService extends CollectionFamilyDao{

    void deleteAllChildrenOlderThen(int age){
        for(Family f : families){
            for(int i=0;i<f.getChildren().size();i++){
                if((2020-f.getChildren().get(i).getYear())>age)
                    f.getChildren().remove(i);
            }
        }
    }

    int count(){
        return families.size();
    }
    Family getFamilyById(int index){
        return families.get(index);
    }
    Set<Pet> getPet(int index){
        return families.get(index).getPet();
    }
    void addPet(int index, Pet pet){
        families.get(index).addPet(pet);
    }




}
