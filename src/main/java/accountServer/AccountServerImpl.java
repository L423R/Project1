package accountServer;

/**
 * Created by Maxon on 06.06.2017.
 */
public class AccountServerImpl implements AccountServer {

    private int usersCount=0;
    private int usersLimit=10;

    public AccountServerImpl() {

    }

    @Override
    public void addNewUser() {
        usersCount++;
    }

    @Override
    public void removeUser() {
        usersCount--;
    }

    @Override
    public int getUsersLimit() {
        return this.usersLimit;
    }

    @Override
    public void setUsersLimit(int usersLimit) {
        this.usersLimit = usersLimit;
    }

    @Override
    public int getUsersCount() {
        return this.usersCount;
    }
}
