package rest;

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
		// write your logic here

		// return new CustomResponse(response, statusCode, status, results);
		return new CustomResponse(null, null, null, null);
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
		// write your logic here

		// return new CustomResponse(response, statusCode, status, results);
		return new CustomResponse(null, null, null, null);
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
		// write your logic here

		// return new CustomResponse(response, statusCode, status, requisitionList);
		return new CustomResponse(null, null, null, null);
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
		// write your logic here

		// return new CustomResponse(response, statusCode, status, results);
		return new CustomResponse(null, null, null, null);
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
		// write your logic here

		// return new CustomResponse(response, statusCode, status, results);
		return new CustomResponse(null, null, null, null);
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
		// write your logic here

		// return new CustomResponse(response, statusCode, status, results);
		return new CustomResponse(null, null, null, null);
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
		// write your logic here

		// return new CustomResponse(response, statusCode, status, results);
		return new CustomResponse(null, null, null, null);
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
		// write your logic here

		// return new CustomResponse(response, statusCode, status, results);
		return new CustomResponse(null, null, null, null);
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
		// write your logic here

		// return new CustomResponse(response, statusCode, status, results);
		return new CustomResponse(null, null, null, null);
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
		// write your logic here

		// return new CustomResponse(response, statusCode, status, results);
		return new CustomResponse(null, null, null, null);
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
		// write your logic here

		// return new CustomResponse(response, statusCode, status, results);
		return new CustomResponse(null, null, null, null);
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
		// write your logic here

		// return new CustomResponse(response, statusCode, status, results);
		return new CustomResponse(null, null, null, null);
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
		// write your logic here

		// return new CustomResponse(response, statusCode, status, results);
		return new CustomResponse(null, null, null, null);
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
		// write your logic here

		// return new CustomResponse(response, statusCode, status, results);
		return new CustomResponse(null, null, null, null);
	}

	/**
	 * @Test15 This method retrieves the list of billing invoices within a specified
	 *         date range.
	 * 
	 * @param endpoint - The API endpoint to retrieve billing invoices.
	 * @param body     - Optional request body.
	 * @return CustomResponse - Contains HTTP status, status message, and Results
	 *         list.
	 */
	public CustomResponse getInvoicesByDateRange(String endpoint, Object body) {
		// write your logic here

		// return new CustomResponse(response, statusCode, status, results);
		return new CustomResponse(null, null, null, null);
	}

	/**
	 * @Test16 This method retrieves the Providers list with authorization.
	 *
	 * @param endpoint - The API endpoint to retrieve the Providers list.
	 * @param body     - Optional request body.
	 * @return CustomResponse - Contains HTTP status, status message, and Results
	 *         list.
	 */
	public CustomResponse getProviderList(String endpoint, Object body) {
		// write your logic here

		// return new CustomResponse(response, statusCode, status, results);
		return new CustomResponse(null, null, null, null);
	}

	/**
	 * @Test17 This method retrieves the Users list with authorization.
	 *
	 * @param endpoint - The API endpoint to retrieve the Users list.
	 * @param body     - Optional request body.
	 * @return CustomResponse - Contains HTTP status, status message, and Results
	 *         list.
	 */
	public CustomResponse getUsersList(String endpoint, Object body) {
		// write your logic here

		// return new CustomResponse(response, statusCode, status, results);
		return new CustomResponse(null, null, null, null);
	}

	/**
	 * @Test18 This method retrieves the current fiscal year details with
	 *         authorization.
	 *
	 * @param endpoint - The API endpoint to retrieve the current fiscal year
	 *                 details.
	 * @param body     - Optional request body.
	 * @return CustomResponse - Contains HTTP status, status message, and Results
	 *         list.
	 */
	public CustomResponse getCurrentFiscalYearDetails(String endpoint, Object body) {
		// write your logic here

		// return new CustomResponse(response, statusCode, status, results);
		return new CustomResponse(null, null, null, null);
	}
}