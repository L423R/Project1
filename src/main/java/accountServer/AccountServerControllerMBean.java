package accountServer;

/**
 * Created by Maxon on 06.06.2017.
 */
public interface AccountServerControllerMBean {
    int getUsersLimit();
    int getUsersCount();
    void setUsersLimit(int limit);
}
