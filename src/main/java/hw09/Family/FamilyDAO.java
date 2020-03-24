package hw09.Family;

import java.util.List;

public interface FamilyDAO {
    List<Family> getAllFamilies();
    Family getFamilyById(int id);
    boolean deleteFamily(int id);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);



}
