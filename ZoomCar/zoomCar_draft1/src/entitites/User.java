package entitites;

public class User {
    public Integer userId;
    public String name;
    public String drivingLicenseId;

    public User(Integer userId, String name, String drivingLicenseId) {
        this.userId = userId;
        this.name = name;
        this.drivingLicenseId = drivingLicenseId;
    }
}
