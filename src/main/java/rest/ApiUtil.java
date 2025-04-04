package rest;

import java.util.List;
import java.util.Map;

import io.restassured.response.Response;

public class ApiUtil {

	private static final String BASE_URL = "https://healthapp.yaksha.com/api";

	/**
	 * @Test1 This method retrieves and verifies the list of stocks.
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 * @return CustomResponse - The API response includes HTTP status code, status
	 *         message, and a list of stocks in the "Results" field, containing
	 *         details such as ItemID, ItemName, SalePrice, and CostPrice.
	 */
	public CustomResponse getAllStocks(String endpoint, Object body) {
		// write your code here

		Response response = null;

		int statusCode = 0;
		String status = "";

		List<Object> itemIds = null;
		List<Object> itemNames = null;
		List<Object> genericNames = null;

		return new CustomResponse(response, statusCode, status, itemIds, itemNames, genericNames);
	}

	/**
	 * @Test2 This method retrieves and verifies the details of the main store.
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 * @return CustomResponse - The API response includes the HTTP status code,
	 *         status message, and details of the main store in the "Results" field,
	 *         containing details such as StoreId, ParentStoreId, Category, and
	 *         IsActive.
	 */
	public CustomResponse getMainStore(String endpoint, Object body) {
		// write your code here

		Response response = null;

		int statusCode = 0;
		String status = "";

		Object storeId = null;
		Object category = null;
		Object isActive = null;

		return new CustomResponse(response, statusCode, status, storeId, category, isActive);
	}

	/**
	 * @Test3 This method retrieves and verifies the requisition list by date range.
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 * @return CustomResponse - The API response includes the HTTP status code,
	 *         status message, and requisition list in the "Results" field,
	 *         containing details such as RequisitionId, RequisitionNo, and
	 *         RequisitionStatus.
	 */
	public CustomResponse getRequisitionByDateRange(String endpoint, Object body) {
		// write your code here

		Response response = null;

		int statusCode = 0;
		String status = "";

		List<Object> requisitionNos = null;
		List<Object> requisitionStatuses = null;
		List<Object> requisitionIds = null;

		return new CustomResponse(response, statusCode, status, requisitionNos, requisitionStatuses, requisitionIds);
	}

	/**
	 * @Test4 This method retrieves and verifies the patient consumptions list.
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 * @return CustomResponse - The API response includes the HTTP status code,
	 *         status message, and the patient consumptions list in the "Results"
	 *         field, containing details such as PatientId, HospitalNo, and
	 *         PatientVisitId.
	 */
	public CustomResponse getPatientConsumptions(String endpoint, Object body) {
		// write your code here

		Response response = null;

		int statusCode = 0;
		String status = "";

		List<Object> patientIds = null;
		List<Object> hospitalNos = null;
		List<Object> patientVisitIds = null;

		return new CustomResponse(response, statusCode, status, patientIds, hospitalNos, patientVisitIds);
	}

	/**
	 * @Test5 This method retrieves and verifies the patient consumption
	 *        information.
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 * @return CustomResponse - The API response includes the HTTP status code,
	 *         status message, and the patient consumption information in the
	 *         "Results" field, containing details such as PatientName, HospitalNo,
	 *         and StoreId.
	 */
	public CustomResponse getPatientConsumptionInfoByPatientIdAndVisitId(String endpoint, Object body) {
		// write your code here

		Response response = null;

		int statusCode = 0;
		String status = "";

		Object patientName = null;
		Object hospitalNo = null;
		Object storeId = null;

		return new CustomResponse(response, statusCode, status, patientName, hospitalNo, storeId);
	}

	/**
	 * @Test6 This method retrieves and verifies the billing scheme by scheme ID.
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 * @return CustomResponse - Contains HTTP status, status message, and Results
	 *         field, including SchemeCode, SchemeName, and SchemeId.
	 */
	public CustomResponse getBillingSchemeBySchemeId(String endpoint, Object body) {
		// write your code here

		Response response = null;

		int statusCode = 0;
		String status = "";

		Object schemeCode = null;
		Object schemeName = null;
		Object schemeId = null;

		return new CustomResponse(response, statusCode, status, schemeCode, schemeName, schemeId);
	}

	/**
	 * @Test7 This method retrieves and verifies the billing summary by patient ID.
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 * @return CustomResponse - Contains HTTP status, status message, and Results
	 *         field, including PatientId, TotalDue, and other billing details.
	 */
	public CustomResponse getBillingSummaryByPatientId(String endpoint, Object body) {
		// write your code here

		Response response = null;

		int statusCode = 0;
		String status = "";

		Object patientId = null;
		Object totalDue = null;

		return new CustomResponse(response, statusCode, status, patientId, totalDue);
	}

	/**
	 * @Test8 This method retrieves and verifies the consumptions list of a patient
	 *        by ID.
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 * @return CustomResponse - Contains HTTP status, status message, and Results
	 *         field, including PatientConsumptionId, ConsumptionReceiptNo, and
	 *         TotalAmount.
	 */
	public CustomResponse getConsumptionsListOfAPatientById(String endpoint, Object body) {
		// write your code here

		Response response = null;

		int statusCode = 0;
		String status = "";

		List<Object> patientConsumptionIds = null;
		List<Object> consumptionReceiptNos = null;
		List<Object> totalAmounts = null;

		return new CustomResponse(response, statusCode, status, patientConsumptionIds, consumptionReceiptNos,
				totalAmounts);
	}

	/**
	 * @Test9 This method retrieves and verifies the return consumptions list.
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 * @return CustomResponse - Contains HTTP status, status message, and Results
	 *         field, including ConsumptionReturnReceiptNo, HospitalNo, and
	 *         PatientId.
	 */
	public CustomResponse getReturnConsumptionsList(String endpoint, Object body) {
		// write your code here

		Response response = null;

		int statusCode = 0;
		String status = "";

		List<Object> consumptionReturnReceiptNos = null;
		List<Object> hospitalNos = null;
		List<Object> patientIds = null;

		return new CustomResponse(response, statusCode, status, consumptionReturnReceiptNos, hospitalNos, patientIds);
	}

	/**
	 * @Test10 This method retrieves and verifies the list of discharged patients.
	 * 
	 * @param endpoint - The API endpoint to which the GET request is sent.
	 * @param body     - Optional
	 * @return CustomResponse - Contains HTTP status, status message, and Results
	 *         field, including VisitCode, PatientVisitId, and PatientId.
	 */
	public CustomResponse getDischargedPatients(String endpoint, Object body) {
		// write your code here

		Response response = null;

		int statusCode = 0;
		String status = "";

		List<Object> visitCodes = null;
		List<Object> patientVisitIds = null;
		List<Object> patientIds = null;

		return new CustomResponse(response, statusCode, status, visitCodes, patientVisitIds, patientIds);
	}

	/**
	 * @Test11 This method retrieves the list of admitted patients.
	 * 
	 * @param endpoint - The API endpoint to retrieve the list of admitted patients.
	 * @param body     - Optional
	 * @return CustomResponse - Contains HTTP status, status message, and Results
	 *         list.
	 */
	public CustomResponse getAdmittedPatients(String endpoint, Object body) {
		// write your code here

		Response response = null;

		int statusCode = 0;
		String status = "";

		List<Object> patientIds = null;
		List<Object> visitIds = null;
		List<Object> dischargeDates = null;

		return new CustomResponse(response, statusCode, status, patientIds, visitIds, dischargeDates);
	}

	/**
	 * @Test12 This method retrieves IPD patients by a specific patient name.
	 * 
	 * @param endpoint - The API endpoint to retrieve IPD patients.
	 * @param body     - Optional
	 * @return CustomResponse - Contains HTTP status, status message, and Results
	 *         list.
	 */
	public CustomResponse searchIpdPatientByPatientId(String endpoint, Object body) {
		// write your code here

		Response response = null;

		int statusCode = 0;
		String status = "";

		List<Object> patientIds = null;
		List<Object> patientCodes = null;

		return new CustomResponse(response, statusCode, status, patientIds, patientCodes);
	}

	/**
	 * @Test13 This method retrieves provisional patient information.
	 * 
	 * @param endpoint - The API endpoint to retrieve patients' provisional
	 *                 information.
	 * @param body     - Optional
	 * @return CustomResponse - Contains HTTP status, status message, and Results
	 *         list.
	 */
	public CustomResponse getPatientProvisionalInfo(String endpoint, Object body) {
		// write your code here

		Response response = null;

		int statusCode = 0;
		String status = "";
		List<Object> patientIds = null;
		List<Object> patientCodes = null;

		return new CustomResponse(response, statusCode, status, patientIds, patientCodes);
	}

	/**
	 * @Test14 This method retrieves the provisional items list for a specific
	 *         patient and scheme ID.
	 * 
	 * @param endpoint - The API endpoint to retrieve provisional items list.
	 * @param body     - Optional request body.
	 * @return CustomResponse - Contains HTTP status, status message, and Results
	 *         list.
	 */
	public CustomResponse getProvisionalItemsListByPatientIdAndSchemeId(String endpoint, Object body) {
		// write your code here

		Response response = null;

		int statusCode = 0;
		String status = "";

		List<Map<String, Object>> results = null;

		return new CustomResponse(response, statusCode, status, results);
	}
}
