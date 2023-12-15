package pojoResource;

import com.api.util.JsonFileHandler;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUser {
    public String id;
    public String name;
    public String email;
    public String gender;
    public String status;

    public static UpdateUser getInstance() {
        UpdateUser updateUser = (UpdateUser) JsonFileHandler.loadJSONTemplate("updateUser.json", UpdateUser.class, JsonFileHandler.resourceDirectory);
        return updateUser;
    }
}
