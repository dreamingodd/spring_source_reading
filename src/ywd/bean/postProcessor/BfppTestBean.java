package ywd.bean.postProcessor;

public class BfppTestBean {
    private String connectionStr;
    private String password;
    private String username;
    public String getConnectionStr() {
        return connectionStr;
    }
    public void setConnectionStr(String connectionStr) {
        this.connectionStr = connectionStr;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String toString() {
        return "BfppTestBean [connectionStr=" + connectionStr + ", password="
                + password + ", username=" + username + "]";
    }
}
