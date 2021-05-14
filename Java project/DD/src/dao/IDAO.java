package dao;

import java.util.List;

public interface IDAO<T,K> {

    public List<T> findAll();

    public T findById(K id);

    public T insert(T object);

    public T update(T object);

}
