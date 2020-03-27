package hw13.Family;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public interface DAO<A> {
    Collection<A> getAll();
    Collection<A> getAllBy(Predicate<A> p);
    Optional<A> get(int id);
    void create(A data);
    void delete(int id);
    void deleteBy(Predicate<A> p);
}
