package juanra.github.model;


import java.io.Serializable;

public class ListGit implements Serializable {

    private String id;
    private String name;
    private String userName;
    private String description;
    private String avatarUrl;

    public ListGit() {
    }

    public ListGit(String id, String name, String userName, String description, String avatarUrl) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.description = description;
        this.avatarUrl = avatarUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
