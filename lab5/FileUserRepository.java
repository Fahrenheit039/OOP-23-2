import java.util.ArrayList;

class FileUserRepository implements IUserRepository {

    ArrayList<User> users;

    public FileUserRepository(){
        this.users = new ArrayList<User>();
        users.add(new User("guest", "guest", "guest"));
        users.add(new User("qwe", "asd", "zxc"));
    }

    @Override
    public User get(int id) {
        try {
            if (users.size() > id && id >= 1) return users.get(id);
            return null;
        } catch (Exception e) {
            System.out.println("get Exception: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean add(User user) {
        try {
            for ( int i = 1; i < users.size(); i++ )
                if ( user.getName() == users.get(i).getName() && user.getLogin() == users.get(i).getLogin() && user.getPassword() == users.get(i).getPassword() ) {
                    System.out.println("this user already exists");
                    return false;
                }
            users.add( new User( user.getName(), user.getLogin(), user.getPassword() ) );
            return true;
        } catch (Exception e) {
            System.out.println("add Exception: " + e.getMessage());
            return false;
        }
    }

    @Override
    public User pop(int id) {
        try {
            if (users.size() > id && id >= 1) return users.remove(id);
            return null;
        } catch (Exception e) {
            System.out.println("pop Exception: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean update(int id, User newValue) {
        try {
            User tmp = searchById(id);
            if (tmp != null) {
                users.get(id).setName(newValue.getName());
                users.get(id).setLogin(newValue.getLogin());
                users.get(id).setPassword(newValue.getPassword());
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("update Exception: " + e.getMessage());
            return false;
        }
    }

    @Override
    public User searchById(int id) {
        return this.get(id);
    }

    @Override
    public User searchByName(String name) {
        try {
            for ( int i = 1; i < users.size(); i++ ) {
                User tmp = users.get(i);
                if (tmp.getName().equals(name))
                    return tmp;
            }
            return null;
        } catch (Exception e) {
            System.out.println("searchByName Exception: " + e.getMessage());
            return null;
        }
    }

    int isExist(String login, String password) {
        try {
            for ( int i = 1; i < users.size(); i++ )
                if ( users.get(i).getLogin().equals(login) && users.get(i).getPassword().equals(password) )
                    return i;
            return -1;
        } catch (Exception e) {
            System.out.println("isExist Exception: " + e.getMessage());
            return -1;
        }
    }

}

