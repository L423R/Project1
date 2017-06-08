package accountServer;

/**
 * Created by Maxon on 06.06.2017.
 */
public interface AccountServer {
    void addNewUser();

    void removeUser();

    int getUsersLimit();

    void setUsersLimit(int usersLimit);

    int getUsersCount();
}
