package itmo.dev.repositories.interfaces;

import java.util.List;

public interface Repository <TClass, ID> {

    void save(TClass entity);

    TClass findById(ID id);

    List<TClass> findAll();

    TClass update(TClass entity);

    void delete(TClass entity);
}