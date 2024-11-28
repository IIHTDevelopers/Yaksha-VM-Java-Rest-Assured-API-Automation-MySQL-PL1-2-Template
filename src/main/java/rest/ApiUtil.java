package rest;

import java.util.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiUtil {

	private static final String BASE_URL = "https://healthapp.yaksha.com/api";

//	********* New Code *********

	/**
	 *@Test1 This method retrieves and verifies the list of stocks
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 *
	 * @return Response - The API response includes the HTTP status code, status
	 *         message, and a list of stocks in the "Results" field, containing
	 *         details such as ItemID, ItemName, SalePrice, and CostPrice.
	 */

	 public Response getAllStocks(String endpoint, Object body) {
		RequestSpecification request = RestAssured.given().header("Authorization", AuthUtil.getAuthHeader())
				.header("Content-Type", "application/json");
		System.out.print(BASE_URL + endpoint);
		// Only add the body if it's not null
		if (body != null) {
			request.body(body);
		}

		return request.get(BASE_URL + endpoint).then().extract().response();
	}

	/**
	 *@Test2 This method retrieves and verifies the details of the main store
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 *
	 * @return Response - The API response includes the HTTP status code, status
	 *         message, and details of the main store in the "Results" field,
	 *         containing details such as StoreId, ParentStoreId, Category, and
	 *         IsActive.
	 */

	public Response getMainStore(String endpoint, Object body) {
		RequestSpecification request = RestAssured.given().header("Authorization", AuthUtil.getAuthHeader())
				.header("Content-Type", "application/json");
		System.out.print(BASE_URL + endpoint);
		// Only add the body if it's not null
		if (body != null) {
			request.body(body);
		}

		return request.get(BASE_URL + endpoint).then().extract().response();
	}

	/**
	 *@Test3 This method retrieves and verifies the requisition list
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 *
	 * @return Response - The API response includes the HTTP status code, status
	 *         message, and the requisition list in the "Results" field, containing
	 *         details such as RequisitionId, RequistionNo, and RequisitionStatus.
	 */

	public Response getRequisitionByDateRange(String endpoint, Object body) {
		RequestSpecification request = RestAssured.given().header("Authorization", AuthUtil.getAuthHeader())
				.header("Content-Type", "application/json");
		System.out.print(BASE_URL + endpoint);
		// Only add the body if it's not null
		if (body != null) {
			request.body(body);
		}

		return request.get(BASE_URL + endpoint).then().extract().response();
	}

	/**
	 *@Test4 This method retrieves and verifies the patient consumptions list
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 *
	 * @return Response - The API response includes the HTTP status code, status
	 *         message, and the patient consumptions list in the "Results" field,
	 *         containing details such as PatientId, HospitalNo, and PatientVisitId.
	 */

	public Response getPatientConsumptions(String endpoint, Object body) {
		RequestSpecification request = RestAssured.given().header("Authorization", AuthUtil.getAuthHeader())
				.header("Content-Type", "application/json");
		System.out.print(BASE_URL + endpoint);
		// Only add the body if it's not null
		if (body != null) {
			request.body(body);
		}

		return request.get(BASE_URL + endpoint).then().extract().response();
	}

	/**
	 *@Test5 This method retrieves and verifies the patient consumption information
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 *
	 * @return Response - The API response includes the HTTP status code, status
	 *         message, and the patient consumption information in the "Results"
	 *         field, containing details such as PatientName, HospitalNo, and
	 *         StoreId.
	 */

	public Response getPatientConsumptionInfoByPatientIdAndVisitId(String endpoint, Object body) {
		RequestSpecification request = RestAssured.given().header("Authorization", AuthUtil.getAuthHeader())
				.header("Content-Type", "application/json");
		System.out.print(BASE_URL + endpoint);
		// Only add the body if it's not null
		if (body != null) {
			request.body(body);
		}

		return request.get(BASE_URL + endpoint).then().extract().response();
	}

	/**
	 *@Test6 This method retrieves and verifies the billing scheme by scheme ID
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 *
	 * @return Response - The API response includes the HTTP status code, status
	 *         message, and the billing scheme by scheme ID in the "Results" field,
	 *         containing details such as SchemeCode, SchemeName, and CommunityName.
	 */

	public Response getBillingSchemeBySchemeId(String endpoint, Object body) {
		RequestSpecification request = RestAssured.given().header("Authorization", AuthUtil.getAuthHeader())
				.header("Content-Type", "application/json");
		System.out.print(BASE_URL + endpoint);
		// Only add the body if it's not null
		if (body != null) {
			request.body(body);
		}

		return request.get(BASE_URL + endpoint).then().extract().response();
	}

	/**
	 *@Test7 This method retrieves and verifies the billing summary by patient ID
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 *
	 * @return Response - The API response includes the HTTP status code, status
	 *         message, and the billing summary by patient ID in the "Results"
	 *         field, containing details such as CreditAmount, ProvisionalAmt, and
	 *         TotalDue.
	 */

	public Response getBillingSummaryByPatientId(String endpoint, Object body) {
		RequestSpecification request = RestAssured.given().header("Authorization", AuthUtil.getAuthHeader())
				.header("Content-Type", "application/json");
		System.out.print(BASE_URL + endpoint);
		// Only add the body if it's not null
		if (body != null) {
			request.body(body);
		}

		return request.get(BASE_URL + endpoint).then().extract().response();
	}

	/**
	 *@Test8 This method retrieves and verifies the consumptions list of a patient by
	 * patient ID
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 *
	 * @return Response - The API response includes the HTTP status code, status
	 *         message, and the consumptions list of a patient by patient ID in the
	 *         "Results" field, containing details such as PatientConsumptionId,
	 *         ConsumptionReceiptNo, and TotalAmount.
	 */

	public Response getConsumptionsListOfAPatientById(String endpoint, Object body) {
		RequestSpecification request = RestAssured.given().header("Authorization", AuthUtil.getAuthHeader())
				.header("Content-Type", "application/json");
		System.out.print(BASE_URL + endpoint);
		// Only add the body if it's not null
		if (body != null) {
			request.body(body);
		}

		return request.get(BASE_URL + endpoint).then().extract().response();
	}

	/**
	 *@Test9 This method retrieves and verifies the return consumptions list
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 *
	 * @return Response - The API response includes the HTTP status code, status
	 *         message, and the return consumptions list in the "Results" field,
	 *         containing details such as ConsumptionReturnReceiptNo, HospitalNo,
	 *         and PatientId.
	 */

	public Response getReturnConsumptionsList(String endpoint, Object body) {
		RequestSpecification request = RestAssured.given().header("Authorization", AuthUtil.getAuthHeader())
				.header("Content-Type", "application/json");
		System.out.print(BASE_URL + endpoint);
		// Only add the body if it's not null
		if (body != null) {
			request.body(body);
		}

		return request.get(BASE_URL + endpoint).then().extract().response();
	}

	/**
	 *@Test10 This method retrieves and verifies the list of discharged patients
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 *
	 * @return Response - The API response includes the HTTP status code, status
	 *         message, and the list of discharged patients in the "Results" field,
	 *         containing details such as VisitCode, PatientVisitId, and PatientId.
	 */

	public Response getDischargedPatients(String endpoint, Object body) {
		RequestSpecification request = RestAssured.given().header("Authorization", AuthUtil.getAuthHeader())
				.header("Content-Type", "application/json");
		System.out.print(BASE_URL + endpoint);
		// Only add the body if it's not null
		if (body != null) {
			request.body(body);
		}

		return request.get(BASE_URL + endpoint).then().extract().response();
	}

	/**
	 * This method cancels an existing appointment with authorization.
	 * 
	 * @param endpoint - The API endpoint to which the request is sent for changing
	 *                 the password
	 * @param body     - It requires a set object that includes username, password,
	 *                 wrongNewPassword, and confirmPassword
	 * @description This method builds a PUT request with the authorization header
	 *              and specified endpoint. If a body is provided, it includes that
	 *              in the request; otherwise, it sends the request with a body.
	 * @return Response - The response from the API after attempting to change the
	 *         password
	 */
	public Response changePasswordWithIncorrectDetails(String endpoint, Object body) {
		RequestSpecification request = RestAssured.given().header("Authorization", AuthUtil.getAuthHeader())
				.header("Content-Type", "application/json");

		// Only add the body if it's not null
		if (body != null) {
			request.body(body);
		}

		return request.get(BASE_URL + endpoint).then().extract().response();
	}

	/**
	 *@Test11 This method cancels an existing appointment with authorization.
	 * 
	 * @param endpoint - The API endpoint to which the request is sent to get the
	 *                 list of admitted patients.
	 * @param body     - Optional
	 * @description This method builds a PUT request with the authorization header
	 *              and specified endpoint. If a body is provided, it includes that
	 *              in the request; otherwise, it sends the request with a body.
	 * @return Response - The response from the API after attempting to get the list
	 *         of admitted patients.
	 */
	public Response getAdmittedPatients(String endpoint, Object body) {
		RequestSpecification request = RestAssured.given().header("Authorization", AuthUtil.getAuthHeader())
				.header("Content-Type", "application/json");

		// Only add the body if it's not null
		if (body != null) {
			request.body(body);
		}

		return request.get(BASE_URL + endpoint).then().extract().response();
	}

	/**
	 *@Test12 This method cancels an existing appointment with authorization.
	 * 
	 * @param endpoint - The API endpoint to which the request is sent to get the
	 *                 IPD patient by patient ID
	 * @param body     - Optional
	 * @description This method builds a PUT request with the authorization header
	 *              and specified endpoint. If a body is provided, it includes that
	 *              in the request; otherwise, it sends the request with a body.
	 * @return Response - The response from the API after attempting to get the IPD
	 *         patient by patient ID
	 */
	public Response searchIpdPatientByPatientId(String endpoint, Object body) {
		RequestSpecification request = RestAssured.given().header("Authorization", AuthUtil.getAuthHeader())
				.header("Content-Type", "application/json");

		// Only add the body if it's not null
		if (body != null) {
			request.body(body);
		}

		return request.get(BASE_URL + endpoint).then().extract().response();
	}

	/**
	 *@Test13 This method cancels an existing appointment with authorization.
	 * 
	 * @param endpoint - The API endpoint to which the request is sent to get
	 *                 patient's provisional information
	 * @param body     - Optional
	 * @description This method builds a PUT request with the authorization header
	 *              and specified endpoint. If a body is provided, it includes that
	 *              in the request; otherwise, it sends the request with a body.
	 * @return Response - The response from the API after attempting to get
	 *         patient's provisional information
	 */
	public Response getPatientProvisionalInfo(String endpoint, Object body) {
		RequestSpecification request = RestAssured.given().header("Authorization", AuthUtil.getAuthHeader())
				.header("Content-Type", "application/json");

		// Only add the body if it's not null
		if (body != null) {
			request.body(body);
		}

		return request.get(BASE_URL + endpoint).then().extract().response();
	}

	/**
	 *@Test14 This method cancels an existing appointment with authorization.
	 * 
	 * @param endpoint - The API endpoint to which the request is sent to get
	 *                 provisional items list by patient ID and scheme ID
	 * @param body     - Optional
	 * @description This method builds a PUT request with the authorization header
	 *              and specified endpoint. If a body is provided, it includes that
	 *              in the request; otherwise, it sends the request with a body.
	 * @return Response - The response from the API after attempting to get
	 *         provisional items list by patient ID and scheme ID
	 */
	public Response getProvisionalItemsListByPatientIdAndSchemeId(String endpoint, Object body) {
		RequestSpecification request = RestAssured.given().header("Authorization", AuthUtil.getAuthHeader())
				.header("Content-Type", "application/json");

		// Only add the body if it's not null
		if (body != null) {
			request.body(body);
		}

		return request.get(BASE_URL + endpoint).then().extract().response();
	}

	/**
	 *@Test15 This method cancels an existing appointment with authorization.
	 * 
	 * @param endpoint - The API endpoint to which the request is sent to get the
	 *                 billing invoices
	 * @param body     - Optional
	 * @description This method builds a PUT request with the authorization header
	 *              and specified endpoint. If a body is provided, it includes that
	 *              in the request; otherwise, it sends the request with a body.
	 * @return Response - The response from the API after attempting to get the
	 *         billing invoices
	 */
	public Response getInvoicesByDateRange(String endpoint, Object body) {
		RequestSpecification request = RestAssured.given().header("Authorization", AuthUtil.getAuthHeader())
				.header("Content-Type", "application/json");

		// Only add the body if it's not null
		if (body != null) {
			request.body(body);
		}

		return request.get(BASE_URL + endpoint).then().extract().response();
	}

	/**
	 *@Test16 This method cancels an existing appointment with authorization.
	 * 
	 * @param endpoint - The API endpoint to which the request is sent to get the
	 *                 Providers list
	 * @param body     - Optional
	 * @description This method builds a PUT request with the authorization header
	 *              and specified endpoint. If a body is provided, it includes that
	 *              in the request; otherwise, it sends the request with a body.
	 * @return Response - The response from the API after attempting to get the
	 *         Providers list
	 */
	public Response getProviderList(String endpoint, Object body) {
		RequestSpecification request = RestAssured.given().header("Authorization", AuthUtil.getAuthHeader())
				.header("Content-Type", "application/json");

		// Only add the body if it's not null
		if (body != null) {
			request.body(body);
		}

		return request.get(BASE_URL + endpoint).then().extract().response();
	}

	/**
	 *@Test17 This method cancels an existing appointment with authorization.
	 * 
	 * @param endpoint - The API endpoint to which the request is sent to get the
	 *                 Users list
	 * @param body     - Optional
	 * @description This method builds a PUT request with the authorization header
	 *              and specified endpoint. If a body is provided, it includes that
	 *              in the request; otherwise, it sends the request with a body.
	 * @return Response - The response from the API after attempting to get the
	 *         Users list
	 */
	public Response getUserslist(String endpoint, Object body) {
		RequestSpecification request = RestAssured.given().header("Authorization", AuthUtil.getAuthHeader())
				.header("Content-Type", "application/json");

		// Only add the body if it's not null
		if (body != null) {
			request.body(body);
		}

		return request.get(BASE_URL + endpoint).then().extract().response();
	}

	/**
	 *@Test18 This method cancels an existing appointment with authorization.
	 * 
	 * @param endpoint - The API endpoint to which the request is sent to get the
	 *                 current fiscal year details
	 * @param body     - Optional
	 * @description This method builds a PUT request with the authorization header
	 *              and specified endpoint. If a body is provided, it includes that
	 *              in the request; otherwise, it sends the request with a body.
	 * @return Response - The response from the API after attempting to get the
	 *         current fiscal year details
	 */
	public Response getCurrentFiscalYearDetails(String endpoint, Object body) {
		RequestSpecification request = RestAssured.given().header("Authorization", AuthUtil.getAuthHeader())
				.header("Content-Type", "application/json");

		// Only add the body if it's not null
		if (body != null) {
			request.body(body);
		}

		return request.get(BASE_URL + endpoint).then().extract().response();
	}

}