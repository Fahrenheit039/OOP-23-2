

interface IUserManager {

    boolean auth(FileUserRepository FUR);

    boolean logout(FileUserRepository FUR);

    boolean isAuth();

    boolean registration(FileUserRepository FUR);

}



