package juanra.github.model;



import java.io.Serializable;

public class Details implements Serializable {


    private String name;
    private String userName;
    private String description;
    private String avatarUrl;
    private String url;

    public Details(String name, String userName, String description, String avatarUrl, String url) {
        this.name = name;
        this.userName = userName;
        this.description = description;
        this.avatarUrl = avatarUrl;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}