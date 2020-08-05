package hw13.Family;

import hw13.Logger.LogDAO;
import hw13.Logger.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FileFamilyDao implements DAO<Family> {
    private final File file;
    //private final File logfile;
    private final Logger logService;

    public FileFamilyDao(String filename, Logger logger) {
        this.file = new File(filename);
        this.logService =logger;
    }

    @Override
    public Collection<Family> getAll() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            Object readed = ois.readObject();
            @SuppressWarnings("unchecked")
            List<Family> families = (ArrayList<Family>) readed;
            logService.info("receiving a family list");
            return families;
        } catch (ClassNotFoundException ex) {
            logService.error("family list can't be get because of ClassNotFoundException");
            throw new RuntimeException("Deserialization error. Didn't you forget to include 'serialVersionUID field' in your entity?", ex);
        } catch (FileNotFoundException ex) {
            logService.error("family list can't be get because of FileNotFoundException");
            return new ArrayList<>();
        } catch (IOException ex) {
            logService.error("family list can't be get because of FileNotFoundException");
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
    public void create(Family family) {
        Collection<Family> families = getAll();
        families.add(family);
        logService.info("adding a new family");
        write(families);
    }

    public void update(int id, Family family){
        Collection<Family> families = getAllBy(s -> s.getId() != id);
        families.add(family);
        logService.info(String.format("updating family ID %d",id));
        write(families);
    }

    @Override
    public void delete(int id) {
        Collection<Family> families = getAllBy(s -> s.getId() != id);
        write(families);
        logService.info(String.format("deleting family ID %d",id));
    }

    @Override
    public void deleteBy(Predicate<Family> p) {
        Collection<Family> families = getAllBy(f -> !p.test(f));
        logService.info("receiving families");
        write(families);
    }

    private void write(Collection<Family> families) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file))))
        {
            oos.writeObject(families);
            logService.info("changed information writing to the file");
        } catch (IOException ex) {
            logService.error("information couldn't be write to the file");
            throw new RuntimeException("DAO:write:IOException", ex);
        }
    }

}
