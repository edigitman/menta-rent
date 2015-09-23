package ro.agitman.menta.entity;

/**
 * Created by gitmaal on 23/09/2015.
 */
public class Image {

    private Long id;
    private String cloudinaryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCloudinaryId() {
        return cloudinaryId;
    }

    public void setCloudinaryId(String cloudinaryId) {
        this.cloudinaryId = cloudinaryId;
    }
}
