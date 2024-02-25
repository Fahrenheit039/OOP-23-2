

interface IDataRepository<T> {

    T get(int id);

    boolean add(T t);

    T pop(int id);

    boolean update(int id, T newValue);

}

