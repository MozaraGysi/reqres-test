package dto.response;

import com.google.gson.Gson;
import common.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Type;

@Getter
@Setter
public class UserResponseDTO extends AbstractDTO<UserResponseDTO> {

	private String name;
	private String job;
	private String id;
	private String createdAt;
}
