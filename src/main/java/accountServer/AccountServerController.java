package accountServer;

/**
 * Created by Maxon on 06.06.2017.
 */
public class AccountServerController implements AccountServerControllerMBean {

    private final AccountServer accountServer;

    public AccountServerController(AccountServer accountServer) {
        this.accountServer = accountServer;
    }

    @Override
    public int getUsersLimit() {
        return accountServer.getUsersLimit();
    }

    @Override
    public int getUsersCount() {
        return accountServer.getUsersCount();
    }

    @Override
    public void setUsersLimit(int limit) {
        accountServer.setUsersLimit(limit);
    }
}
