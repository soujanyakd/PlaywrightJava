package pojoresource;

import apiutils.JsonFileHandler;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUser {

    public String name;
    public String email;
    public String gender;
    public String status;

    public static CreateUser getInstance() {
        CreateUser createUser = (CreateUser) JsonFileHandler.loadJSONTemplate("createUser.json", CreateUser.class, JsonFileHandler.resourceDirectory);
        return createUser;
    }

}
