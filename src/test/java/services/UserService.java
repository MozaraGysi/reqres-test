package services;

import common.validators.StatusCodeCreatedValidator;
import common.validators.StatusCodeOKValidator;
import common.validators.Validator;
import dto.request.UserRequestDTO;
import fixture.UserRequestDTOFixture;
import io.restassured.response.Response;
import utils.APIClient;
import utils.Utils;
import validators.UserValidator;

import java.util.List;

public class UserService {

	private UserService() {
		throw new IllegalStateException("CreateUserService is a Service Class, is not to be instantiated");
	}

	public static void postUser() {
		UserRequestDTO userRequestDTO = UserRequestDTOFixture.get().withData().build();

		Response response = APIClient.postUser(userRequestDTO);

		List<Validator> validators = List.of(new StatusCodeCreatedValidator(), new UserValidator());
		validators.forEach(validator -> validator.validate(response));

		Utils.validateSchema(response, "reqres-schema.json");
	}

	public static void getUser() {
		UserRequestDTO userRequestDTO = UserRequestDTOFixture.get().build();

		Response response = APIClient.getUsers(userRequestDTO);

		System.out.println(response.getBody().asString());

		List<Validator> validators = List.of(new StatusCodeOKValidator(), new UserValidator());
		validators.forEach(validator -> validator.validate(response));

	}
}
