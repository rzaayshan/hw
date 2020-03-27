package hw13.Family;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FileFamilyDao implements DAO<Family> {
    private final File file;

    public FileFamilyDao(String filename) {
        this.file = new File(filename);
    }

    @Override
    public Collection<Family> getAll() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            Object readed = ois.readObject();
            @SuppressWarnings("unchecked")
            List<Family> as = (ArrayList<Family>) readed;
            return as;
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Deserialization error. Didn't you forget to include 'serialVersionUID field' in your entity?", ex);
        } catch (FileNotFoundException ex) {
            return new ArrayList<>();
        } catch (IOException ex) {
            throw new RuntimeException("Something went wrong", ex);
        }
    }

    @Override
    public Collection<Family> getAllBy(Predicate<Family> p) {
        return
                getAll().stream().filter(p).collect(Collectors.toList());
    }

    @Override
    public Optional<Family> get(int id) {
        return getAll().stream().filter(f->f.getId() == id).findFirst();
    }

    @Override
    public void create(Family a) {
        Collection<Family> as = getAll();
        as.add(a);
        write(as);
    }

    public void update(int id, Family family){
        delete(id);
        create(family);
    }

    @Override
    public void delete(int id) {
        Collection<Family> as = getAllBy(s -> s.getId() != id);
        write(as);
    }

    @Override
    public void deleteBy(Predicate<Family> p) {
        Collection<Family> as = getAllBy(a -> !p.test(a));
        write(as);
    }

    private void write(Collection<Family> as) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file))))
        {
            oos.writeObject(as);
        } catch (IOException ex) {
            throw new RuntimeException("DAO:write:IOException", ex);
        }
    }
}
