package dev.mihail.DAO;

import java.util.List;
import java.util.Optional;

public interface DAO <T> {

    List<T> listAll();

    void create(T t);

    Optional<T> get(int id);

    void update(T t, int id);

    void delete(T t, int id);
}
