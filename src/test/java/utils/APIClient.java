package utils;

import common.AbstractDTO;
import dto.request.UserRequestDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static data.TestData.getBaseUrl;
import static java.util.Objects.nonNull;

public class APIClient {

	private APIClient() {
		throw new IllegalStateException("APIClient is a Utility class, aren't to be instantiated ");
	}

	private static RequestSpecification getRequestSpecification(AbstractDTO requestDTO) {
		RestAssured.baseURI = getBaseUrl();

		RequestSpecification request = RestAssured.given();

		if (nonNull(requestDTO)) {
			request.header("Content-Type", requestDTO.getContentType());
			request.headers(requestDTO.headers());
			request.body(requestDTO.body());
			request.queryParams(requestDTO.queryParams());
		}

		return request;
	}

	private static Response post(AbstractDTO requestDTO, String requestUri) {
		RequestSpecification request = getRequestSpecification(requestDTO);
		Response response = request.post(requestUri);
		return response;
	}

	private static Response get(AbstractDTO requestDTO, String requestUri) {
		RequestSpecification request = getRequestSpecification(requestDTO);
		Response response = request.get(requestUri);
		return response;
	}

	public static Response postUser(UserRequestDTO userRequestDTO) {
		return post(userRequestDTO, "/users");
	}

	public static Response getUsers(UserRequestDTO userRequestDTO) {
		return get(userRequestDTO, "/users?page=2");
	}

}
