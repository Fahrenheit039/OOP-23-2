

interface IUserRepository extends IDataRepository<User> {


    @Override
    public User get(int id);

    @Override
    public boolean add(User user);

    @Override
    public User pop(int id);

    @Override
    public boolean update(int id, User newValue);

    public User searchById(int id);

    public User searchByName(String name);


}

