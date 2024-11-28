package testcases;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import coreUtilities.utils.FileOperations;
import io.restassured.response.Response;
import rest.ApiUtil;

public class RestAssured_TestCases_PL1 {


	FileOperations fileOperations = new FileOperations();
	private final String EXCEL_FILE_PATH = "src/main/resources/config.xlsx"; // Path to the Excel file
	private final String FILEPATH = "src/main/java/rest/ApiUtil.java";
	ApiUtil apiUtil;

	@Test(priority = 1, groups = { "PL1" }, description = "1. Send a GET request to get list of stocks\n"
			+ "2. Validate that all the ItemId, ItemName, and GenericName are not null.\n" 
			+ "3. Verify the response status code is 200.")
	public void getAllStocks() throws IOException {
		apiUtil = new ApiUtil();

		Response allStocksResponse = apiUtil.getAllStocks("/PharmacyStock/AllStockDetails", null);

		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH, "getAllStocks",
				List.of("given", "then", "extract", "response"));

		System.out.println("---------------------------------------------" + isValidationSuccessful
				+ "------------------------------");

		// 1. Verify Status is "200 OK"
		String status = allStocksResponse.jsonPath().getString("Status");
		Assert.assertEquals(status, "OK", "Status should be OK.");

		// 2. Verify Status code is 200
		Assert.assertEquals(allStocksResponse.statusCode(), 200, "Status code should be 200.");

		// 3. Validate that ItemID, ItemName, and GenericName are not null
		List<Map<String, Object>> results = allStocksResponse.jsonPath().getList("Results");
		results.forEach(result -> {
			Assert.assertNotNull(result.get("ItemId"), "ItemId should not be null.");
			Assert.assertNotNull(result.get("ItemName"), "ItemName should not be null.");
			Assert.assertNotNull(result.get("GenericName"), "GenericName should not be null.");
		});

		// Print the response
		System.out.println("All Stocks Response:");
		allStocksResponse.prettyPrint();
	}

	@Test(priority = 2, groups = { "PL1" }, description = "1. Send a GET request to get details of main store\n"
			+ "2. Validate that all StoreId are not null .\n" 
			+ "3. Verify the response status code is 200.")
	public void getMainStore() throws IOException {
		apiUtil = new ApiUtil();

		Response mainStoreResponse = apiUtil.getMainStore("/PharmacySettings/MainStore", null);

		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH, "getMainStore",
				List.of("given", "then", "extract", "response"));

		System.out.println("---------------------------------------------" + isValidationSuccessful
				+ "------------------------------");

		// 1. Verify Status is "OK"
		String status = mainStoreResponse.jsonPath().getString("Status");
		Assert.assertEquals(status, "OK", "Status should be OK.");

		// 2. Verify Status code is 200
		Assert.assertEquals(mainStoreResponse.statusCode(), 200, "Status code should be 200.");

		// 3. Validate that StoreId is not null
		Integer storeId = mainStoreResponse.jsonPath().getInt("Results.StoreId");
		Assert.assertNotNull(storeId, "StoreId should not be null.");

		// Print the response
		System.out.println("Main Store Response:");
		mainStoreResponse.prettyPrint();
	}

	@Test(priority = 3, groups = { "PL1" }, description = "1. Send a GET request to get dispensary requisition by date range\n"
			+ "2. Validate that RequistionNo, RequisitionStatus are not null and requisitionIds are unique.\n"
			 + "3. Verify the response status code is 200.")
	public void getRequisitionByDateRange() throws IOException {
		apiUtil = new ApiUtil();
		String fromDate = "2020-01-01";
		String toDate = "2024-11-19";

		Response requisitionResponse = apiUtil.getRequisitionByDateRange(
				"/DispensaryRequisition/Dispensary/1?FromDate=" + fromDate + "&ToDate=" + toDate, null);

		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH,
				"getRequisitionByDateRange", List.of("given", "then", "extract", "response"));

		System.out.println("---------------------------------------------" + isValidationSuccessful
				+ "------------------------------");

		// 1. Verify Status is "OK"
		String status = requisitionResponse.jsonPath().getString("Status");
		Assert.assertEquals(status, "OK", "Status should be OK.");

		// 2. Verify Status code is 200
		Assert.assertEquals(requisitionResponse.statusCode(), 200, "Status code should be 200.");

		// 3. Validate that RequisitionIds are unique
		List<Integer> requisitionIds = requisitionResponse.jsonPath()
				.getList("Results.requisitionList.RequisitionId");
		Set<Integer> uniqueRequisitionIds = new HashSet<>(requisitionIds);
		Assert.assertEquals(uniqueRequisitionIds.size(), requisitionIds.size(), "RequisitionIds should be unique.");

		// 4. Validate that RequisitionNo and RequisitionStatus are not null
		List<Map<String, Object>> requisitionList = requisitionResponse.jsonPath()
				.getList("Results.requisitionList");
		for (Map<String, Object> requisition : requisitionList) {
			Assert.assertNotNull(requisition.get("RequistionNo"), "RequistionNo should not be null.");
			Assert.assertNotNull(requisition.get("RequisitionStatus"), "RequisitionStatus should not be null.");
		}

		// Print the response
		System.out.println("Requisition Response:");
		requisitionResponse.prettyPrint();
	}

	@Test(priority = 4, groups = { "PL1" }, description = "1. Send a GET request to get details of patient's consumption.\n"
			+ "2. Validate that all the patient IDs and Hospital No. are not null.\n" 
			+ "3. Verify the response status code is 200.")
	public void getPatientConsumptions() throws IOException {
		apiUtil = new ApiUtil();

		Response patientConsumptionsResponse = apiUtil.getPatientConsumptions("/PatientConsumption/PatientConsumptions",
				null);

		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH,
				"getPatientConsumptions", List.of("given", "then", "extract", "response"));

		System.out.println("---------------------------------------------" + isValidationSuccessful
				+ "------------------------------");

		// 1. Verify Status is "OK"
		String status = patientConsumptionsResponse.jsonPath().getString("Status");
		Assert.assertEquals(status, "OK", "Status should be OK.");

		// 2. Verify Status code is 200
		Assert.assertEquals(patientConsumptionsResponse.statusCode(), 200, "Status code should be 200.");

		// 3. Validate that PatientId and HospitalNo are not null
		List<Map<String, Object>> patientConsumptions = patientConsumptionsResponse.jsonPath().getList("Results");
		for (Map<String, Object> patientConsumption : patientConsumptions) {
			Assert.assertNotNull(patientConsumption.get("PatientId"), "PatientId should not be null.");
			Assert.assertNotNull(patientConsumption.get("HospitalNo"), "HospitalNo should not be null.");
		}

		// Print the response
		System.out.println("Patient Consumptions Response:");
		patientConsumptionsResponse.prettyPrint();
	}

	@Test(priority = 5, groups = { "PL1" }, description = "1. Send a GET request to get get Patient Consumption Info By Patient Id And Visit Id\n"
			+ "2. Validate that patient Visit Id is unique and patient Id From Response is same as sent in the request.\n" 
			+ "3. Verify the response status code is 200.")
	public void getPatientConsumptionInfoByPatientIdAndVisitId() throws IOException {
		apiUtil = new ApiUtil();
		String patientId = "114";
		String patientVisitId = "53";

		Response consumptionInfoResponse = apiUtil
				.getPatientConsumptionInfoByPatientIdAndVisitId("/PatientConsumption/PatientConsumptionInfo?patientId="
						+ patientId + "&patientVisitId=" + patientVisitId, null);

		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH,
				"getPatientConsumptionInfoByPatientIdAndVisitId", List.of("given", "then", "extract", "response"));

		System.out.println("---------------------------------------------" + isValidationSuccessful
				+ "------------------------------");

		// 1. Verify Status is "OK"
		String status = consumptionInfoResponse.jsonPath().getString("Status");
		Assert.assertEquals(status, "OK", "Status should be OK.");

		// 2. Verify Status code is 200
		Assert.assertEquals(consumptionInfoResponse.statusCode(), 200, "Status code should be 200.");

		// 3. Verify PatientId is the same
		int patientIdFromResponse = consumptionInfoResponse.jsonPath().getInt("Results.PatientConsumption.PatientId");
		Assert.assertEquals(String.valueOf(patientIdFromResponse), patientId, "PatientId should be " + patientId + ".");

		// 4. Validate that PatientVisitId is not null
		Integer patientVisitIdFromResponse = consumptionInfoResponse.jsonPath()
				.getInt("Results.PatientConsumption.PatientVisitId");
		Assert.assertNotNull(patientVisitIdFromResponse, "PatientVisitId should not be null.");

		// Print the response
		System.out.println("Consumption Information Response:");
		consumptionInfoResponse.prettyPrint();
	}

	@Test(priority = 6, groups = { "PL1" }, description = "1. Send a GET request to get Billing Scheme By Scheme Id\n"
			+ "2. Validate that all scheme Code is not null and scheme Id From Response is same as in request.\n" 
			+ "3. Verify the response status code is 200.")
	public void getBillingSchemeBySchemeId() throws IOException {
		apiUtil = new ApiUtil();
		String schemeId = "4";

		Response billingSchemeResponse = apiUtil.getBillingSchemeBySchemeId(
				"/PatientConsumption/PharmacyIpBillingScheme?schemeId=" + schemeId + "", null);

		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH,
				"getBillingSchemeBySchemeId", List.of("given", "then", "extract", "response"));

		System.out.println("---------------------------------------------" + isValidationSuccessful
				+ "------------------------------");

		// 1. Verify Status is "OK"
		String status = billingSchemeResponse.jsonPath().getString("Status");
		Assert.assertEquals(status, "OK", "Status should be OK.");

		// 2. Verify Status code is 200
		Assert.assertEquals(billingSchemeResponse.statusCode(), 200, "Status code should be 200.");

		// 3. Verify SchemeId is the same
		int schemeIdFromResponse = billingSchemeResponse.jsonPath().getInt("Results.SchemeId");
		Assert.assertEquals(String.valueOf(schemeIdFromResponse), schemeId, "SchemeId should be " + schemeId + ".");

		// 4. Validate that SchemeCode is not null
		String schemeCode = billingSchemeResponse.jsonPath().getString("Results.SchemeCode");
		Assert.assertNotNull(schemeCode, "SchemeCode should not be null.");

		// Print the response
		System.out.println("Billing Scheme  Response:");
		billingSchemeResponse.prettyPrint();
	}

	@Test(priority = 7, groups = { "PL1" }, description = 
	"1. Send a GET request to retrieve the billing summary for a specific patient by PatientId.\n"
	+ "2. Validate the following:\n"
	+ "   - PatientId in the response matches the requested PatientId.\n"
	+ "   - Status field in the response is 'OK'.\n"
	+ "   - TotalDue field in the response is not null.\n"
	+ "3. Verify the response status code is 200."
)
	public void getBillingSummaryByPatientId() throws IOException {
		apiUtil = new ApiUtil();
		String patientId = "114";

		Response billingSummaryResponse = apiUtil
				.getBillingSummaryByPatientId("/PharmacySales/PatientBillingSummary?patientId=" + patientId, null);

		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH,
				"getBillingSummaryByPatientId", List.of("given", "then", "extract", "response"));

		System.out.println("---------------------------------------------" + isValidationSuccessful
				+ "------------------------------");

		// 1. Verify Status is "OK"
		String status = billingSummaryResponse.jsonPath().getString("Status");
		Assert.assertEquals(status, "OK", "Status should be OK.");

		// 2. Verify Status code is 200
		Assert.assertEquals(billingSummaryResponse.statusCode(), 200, "Status code should be 200.");

		// 3. Verify PatientId is the same
		int patientIdFromResponse = billingSummaryResponse.jsonPath().getInt("Results.PatientId");
		Assert.assertEquals(String.valueOf(patientIdFromResponse), patientId, "PatientId should be " + patientId + ".");

		// 4. Validate that TotalDue is not null
		Double totalDue = billingSummaryResponse.jsonPath().getDouble("Results.TotalDue");
		Assert.assertNotNull(totalDue, "TotalDue should not be null.");

		// Print the response
		System.out.println("Billing Summary Response:");
		billingSummaryResponse.prettyPrint();
	}

	@Test(priority = 8, groups = { "PL1" }, description = 
	"1. Send a GET request to retrieve the consumption list for a specific patient by PatientId and PatientVisitId.\n"
	+ "2. Validate the following:\n"
	+ "   - Status field in the response is 'OK'.\n"
	+ "   - PatientConsumptionId values in the response are unique.\n"
	+ "   - TotalAmount field in each result is not null.\n"
	+ "3. Verify the response status code is 200."
)
	public void getConsumptionsListOfAPatientById() throws IOException {
		apiUtil = new ApiUtil();
		String patientId = "114";
		String patientVisitId = "53";

		Response consumptionOfPatientResponse = apiUtil
				.getConsumptionsListOfAPatientById("/PatientConsumption/ConsumptionsOfPatient?patientId=" + patientId
						+ "&patientVisitId=" + patientVisitId, null);

		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH,
				"getConsumptionsListOfAPatientById", List.of("given", "then", "extract", "response"));

		System.out.println("---------------------------------------------" + isValidationSuccessful
				+ "------------------------------");

		// 1. Verify Status is "OK"
		String status = consumptionOfPatientResponse.jsonPath().getString("Status");
		Assert.assertEquals(status, "OK", "Status should be OK.");

		// 2. Verify Status code is 200
		Assert.assertEquals(consumptionOfPatientResponse.statusCode(), 200, "Status code should be 200.");

		// 3. Verify PatientConsumptionId is unique
		List<Integer> patientConsumptionIds = consumptionOfPatientResponse.jsonPath().getList("Results.PatientConsumptionId");
		Set<Integer> uniqueIds = new HashSet<>(patientConsumptionIds);
		Assert.assertEquals(patientConsumptionIds.size(), uniqueIds.size(), "PatientConsumptionId should be unique.");

		// 4. Validate that TotalAmount is not null
		List<Float> totalAmounts = consumptionOfPatientResponse.jsonPath().getList("Results.TotalAmount");
		for (Float totalAmount : totalAmounts) {
			Assert.assertNotNull(totalAmount, "TotalAmount should not be null.");
		}

		// Print the response
		System.out.println("Consumptions Of Patient Response:");
		consumptionOfPatientResponse.prettyPrint();
	}

	@Test(priority = 9, groups = { "PL1" },description = "1. Send a GET request to retrieve the return consumption list.\n"
	+ "2. Validate the following:\n"
	+ "   - Status field in the response is 'OK'.\n"
	+ "   - ConsumptionReturnReceiptNo values in the response are unique.\n"
	+ "   - PatientId field in each result is not null.\n"
	+ "3. Verify the response status code is 200."
)
	public void getReturnConsumptionsList() throws IOException {
		apiUtil = new ApiUtil();

		Response consumptionReturnResponse = apiUtil.getReturnConsumptionsList("/PatientConsumption/Returns", null);

		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH,
				"getReturnConsumptionsList", List.of("given", "then", "extract", "response"));

		System.out.println("---------------------------------------------" + isValidationSuccessful
				+ "------------------------------");

		// 1. Verify Status is "OK"
		String status = consumptionReturnResponse.jsonPath().getString("Status");
		Assert.assertEquals(status, "OK", "Status should be OK.");

		// 2. Verify Status code is 200
		Assert.assertEquals(consumptionReturnResponse.statusCode(), 200, "Status code should be 200.");

		// 3. Verify ConsumptionReturnReceiptNo is unique
		List<Integer> consumptionReturnReceiptNos = consumptionReturnResponse.jsonPath()
				.getList("Results.ConsumptionReturnReceiptNo");
		Set<Integer> uniqueReceiptNos = new HashSet<>(consumptionReturnReceiptNos);
		Assert.assertEquals(consumptionReturnReceiptNos.size(), uniqueReceiptNos.size(),
				"ConsumptionReturnReceiptNo should be unique.");

		// 4. Validate that PatientId is not null
		List<Integer> patientIds = consumptionReturnResponse.jsonPath().getList("Results.PatientId");
		for (Integer patientId : patientIds) {
			Assert.assertNotNull(patientId, "PatientId should not be null.");
		}

		// Print the response
		System.out.println("Consumption Return Response:");
		consumptionReturnResponse.prettyPrint();
	}

	@Test(priority = 10, groups = { "PL1" },description =
		"1. Send a GET request to retrieve the list of discharged patients within a specified date range.\n"
	+ "2. Validate the following:\n"
	+ "   - Status field in the response is 'OK'.\n"
	+ "   - PatientVisitId values in the response are unique.\n"
	+ "   - PatientAdmissionId values in the response are unique.\n"
	+ "   - PatientId field in each result is not null.\n"
	+ "3. Verify the response status code is 200."
)
	public void getDischargedPatients() throws IOException {
		apiUtil = new ApiUtil();
		String fromDate = "2020-01-01";
		String toDate = "2024-11-19";

		Response dischargedPatientResponse = apiUtil.getDischargedPatients(
				"/Admission/DischargedPatients?admissionStatus=discharged&FromDate=" + fromDate + "&ToDate=" + toDate,
				null);

		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH, "getDischargedPatients",
				List.of("given", "then", "extract", "response"));

		System.out.println("---------------------------------------------" + isValidationSuccessful
				+ "------------------------------");

		// 1. Verify Status is "OK"
		String status = dischargedPatientResponse.jsonPath().getString("Status");
		Assert.assertEquals(status, "OK", "Status should be OK.");

		// 2. Verify Status code is 200
		Assert.assertEquals(dischargedPatientResponse.statusCode(), 200, "Status code should be 200.");

		// 3. Verify PatientVisitId and PatientAdmissionId are unique
		List<Integer> patientVisitIds = dischargedPatientResponse.jsonPath().getList("Results.PatientVisitId");
		Set<Integer> uniquePatientVisitIds = new HashSet<>(patientVisitIds);
		Assert.assertEquals(patientVisitIds.size(), uniquePatientVisitIds.size(), "PatientVisitId should be unique.");

		List<Integer> patientAdmissionIds = dischargedPatientResponse.jsonPath().getList("Results.PatientAdmissionId");
		Set<Integer> uniquePatientAdmissionIds = new HashSet<>(patientAdmissionIds);
		Assert.assertEquals(patientAdmissionIds.size(), uniquePatientAdmissionIds.size(),
				"PatientAdmissionId should be unique.");

		// 4. Validate that PatientId is not null
		List<Integer> patientIds = dischargedPatientResponse.jsonPath().getList("Results.PatientId");
		for (Integer patientId : patientIds) {
			Assert.assertNotNull(patientId, "PatientId should not be null.");
		}

		// Print the response
		System.out.println("Billing Counters Response:");
		dischargedPatientResponse.prettyPrint();
	}

	@Test(priority = 11, groups = { "PL1" }, description =
	 "1. Send a GET request to retrieve the list of admitted patients.\n"
	+ "2. Validate the following:\n"
	+ "   - Status field in the response is 'OK'.\n"
	+ "   - PatientId values in the response are unique.\n"
	+ "   - VisitId values in the response are unique.\n"
	+ "   - DischargeDate field for all patients is null.\n"
	+ "3. Verify the response status code is 200."
)
	public void getAdmittedPatients() throws IOException {
		apiUtil = new ApiUtil();

		Response admittedPatientsResponse = apiUtil.getAdmittedPatients("/IpBilling/AdmittedPatients", null);

		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH, "getAdmittedPatients",
				List.of("given", "then", "extract", "response"));

		System.out.println("---------------------------------------------" + isValidationSuccessful
				+ "------------------------------");

		// 1. Verify Status is "OK"
		String status = admittedPatientsResponse.jsonPath().getString("Status");
		Assert.assertEquals(status, "OK", "Status should be 'OK'.");

		// 2. Verify Status code is 200
		Assert.assertEquals(admittedPatientsResponse.statusCode(), 200, "Status code should be 200.");

		// Extract the results array
		List<Map<String, Object>> results = admittedPatientsResponse.jsonPath().getList("Results");

		// 3. Verify PatientId and VisitId are unique
		Set<Integer> uniquePatientIds = new HashSet<>();
		Set<Integer> uniqueVisitIds = new HashSet<>();

		for (Map<String, Object> patient : results) {
			int patientId = (int) patient.get("PatientId");
			int visitId = (int) patient.get("VisitId");

			Assert.assertTrue(uniquePatientIds.add(patientId), "Duplicate PatientId found: " + patientId);
			Assert.assertTrue(uniqueVisitIds.add(visitId), "Duplicate VisitId found: " + visitId);
		}

		// 4. Verify DischargeDate is null for all patients
		for (Map<String, Object> patient : results) {
			Assert.assertNull(patient.get("DischargeDate"),
					"DischargeDate should be null for PatientId: " + patient.get("PatientId"));
		}

		// Print the response
		System.out.println("Admitted Patients Response:");
		admittedPatientsResponse.prettyPrint();
	}

	@Test(priority = 12, groups = { "PL1" }, description = "1. Send a GET request to search for IPD patients by patient name.\n"
	+ "2. Validate the following:\n"
	+ "   - Status field in the response is 'OK'.\n"
	+ "   - PatientId is not null for all patients.\n"
	+ "   - PatientCode is not null for all patients.\n"
	+ "3. Verify the response status code is 200."
)
	public void searchIpdPatientByPatientId() throws IOException {
		apiUtil = new ApiUtil();
		String patientName = "Devid8 Roy8";

		Response ipdResponse = apiUtil.searchIpdPatientByPatientId("/Patient/IPDPatientSearch?search=" + patientName,
				null);

		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH,
				"searchIpdPatientByPatientId", List.of("given", "then", "extract", "response"));

		System.out.println("---------------------------------------------" + isValidationSuccessful
				+ "------------------------------");

		// 1. Verify Status is "OK"
		String status = ipdResponse.jsonPath().getString("Status");
		Assert.assertEquals(status, "OK", "Status should be 'OK'.");

		// 2. Verify Status code is 200
		Assert.assertEquals(ipdResponse.statusCode(), 200, "Status code should be 200.");

		// Extract the results array
		List<Map<String, Object>> results = ipdResponse.jsonPath().getList("Results");

		// 3. Validate that PatientId and PatientCode are not null
		for (Map<String, Object> patient : results) {
			Assert.assertNotNull(patient.get("PatientId"), "PatientId should not be null.");
			Assert.assertNotNull(patient.get("PatientCode"), "PatientCode should not be null.");
		}

		// Print the response for visibility
		System.out.println("IPD Response:");
		ipdResponse.prettyPrint();
	}

	@Test(priority = 13, groups = { "PL1" },description = 
	"1. Send a GET request to retrieve patients' provisional information.\n"
	+ "2. Validate the following:\n"
	+ "   - Status field in the response is 'OK'.\n"
	+ "   - Status code of the response is 200.\n"
	+ "   - PatientId is not null for all patients.\n"
	+ "   - PatientCode is not null for all patients.\n"
)
	public void getPatientProvisionalInfo() throws IOException {
		apiUtil = new ApiUtil();

		Response patientProvisionalResponse = apiUtil.getPatientProvisionalInfo("/Billing/PatientsProvisionalInfo",
				null);

		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH,
				"getPatientProvisionalInfo", List.of("given", "then", "extract", "response"));

		System.out.println("---------------------------------------------" + isValidationSuccessful
				+ "------------------------------");

		// 1. Verify Status is "OK"
		String status = patientProvisionalResponse.jsonPath().getString("Status");
		Assert.assertEquals(status, "OK", "Status should be 'OK'.");

		// 2. Verify Status code is 200
		Assert.assertEquals(patientProvisionalResponse.statusCode(), 200, "Status code should be 200.");

		// Extract the results array
		List<Map<String, Object>> results = patientProvisionalResponse.jsonPath().getList("Results");

		// 3. Validate that PatientId and PatientCode are not null
		for (Map<String, Object> patient : results) {
			Assert.assertNotNull(patient.get("PatientId"), "PatientId should not be null.");
			Assert.assertNotNull(patient.get("PatientCode"), "PatientCode should not be null.");
		}

		// Print the response for debugging
		System.out.println("Patient Provisional Response:");
		patientProvisionalResponse.prettyPrint();
	}

	@Test(priority = 14, groups = { "PL1" },description = "1. Send a GET request to retrieve the list of provisional items for a specific patient and scheme.\n"
	+ "2. Validate the following:\n"
	+ "   - Status field in the response is 'OK'.\n"
	+ "   - Status code of the response is 200.\n"
	+ "   - Patient data is not null.\n"
	+ "   - PatientId from the response matches the requested patient ID.\n"
	+ "   - ProvisionalItems is a non-empty list of JSON objects.\n"
	+ "   - PatientId in ProvisionalItems matches the response PatientId."
)
	public void getProvisionalItemsListByPatientIdAndSchemeId() throws IOException {
		apiUtil = new ApiUtil();
		String patientId = "188";
		String schemeId = "4";

		// Make API call
		Response provisionalItemListResponse = apiUtil.getProvisionalItemsListByPatientIdAndSchemeId(
				"/Billing/ProvisionalItemsByPatientId?patientId=" + patientId + "&schemeId=" + schemeId, null);

		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH,
				"getProvisionalItemsListByPatientIdAndSchemeId", List.of("given", "then", "extract", "response"));

		System.out.println("---------------------------------------------" + isValidationSuccessful
				+ "------------------------------");

		// 1. Verify Status is "OK"
		String status = provisionalItemListResponse.jsonPath().getString("Status");
		Assert.assertEquals(status, "OK", "Status should be 'OK'.");

		// 2. Verify Status code is 200
		Assert.assertEquals(provisionalItemListResponse.statusCode(), 200, "Status code should be 200.");

		// Extract the Patient object
		Map<String, Object> patient = provisionalItemListResponse.jsonPath().getMap("Results.Patient");
		Assert.assertNotNull(patient, "Patient data should not be null.");

		// 3. Verify PatientId matches
		int responsePatientId = (int) patient.get("PatientId");
		Assert.assertEquals(responsePatientId, Integer.parseInt(patientId), "PatientId should match the request.");

		// 4. Validate ProvisionalItems is a list of JSON objects
		List<Map<String, Object>> provisionalItems = provisionalItemListResponse.jsonPath()
				.getList("Results.ProvisionalItems");
		Assert.assertNotNull(provisionalItems, "ProvisionalItems should not be null.");
		Assert.assertTrue(provisionalItems.size() > 0, "ProvisionalItems should contain at least one item.");

		// Check PatientId consistency in ProvisionalItems
		for (Map<String, Object> item : provisionalItems) {
			Assert.assertEquals(item.get("PatientId"), responsePatientId,
					"PatientId in ProvisionalItems should match the PatientId.");
		}

		// Print the response for debugging
		System.out.println("Provisional Items list Response:");
		provisionalItemListResponse.prettyPrint();
	}

	@Test(priority = 15, groups = { "PL1" }, description = "1. Send a GET request to fetch the list of invoices based on a specific date range (FromDate to ToDate).\n"
	+ "2. Validate the following:\n"
	+ "   - Status field in the response is 'OK'.\n"
	+ "   - Status code of the response is 200.\n"
	+ "   - Results array (invoices) is not null and contains at least one invoice.\n"
	+ "   - InvoiceNumber and InvoiceCode are not null for each invoice."
)
	public void getInvoicesByDateRange() throws IOException {
		apiUtil = new ApiUtil();
		String fromDate = "2020-01-01";
		String toDate = "2024-11-21";

		// Make API call
		Response billingInvoicesResponse = apiUtil
				.getInvoicesByDateRange("/Billing/Invoices?FromDate=" + fromDate + "&ToDate=" + toDate, null);

		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH,
				"getInvoicesByDateRange", List.of("given", "then", "extract", "response"));

		System.out.println("---------------------------------------------" + isValidationSuccessful
				+ "------------------------------");

		// 1. Verify Status is "OK"
		String status = billingInvoicesResponse.jsonPath().getString("Status");
		Assert.assertEquals(status, "OK", "Status should be 'OK'.");

		// 2. Verify Status code is 200
		Assert.assertEquals(billingInvoicesResponse.statusCode(), 200, "Status code should be 200.");

		// Extract Results array
		List<Map<String, Object>> invoices = billingInvoicesResponse.jsonPath().getList("Results");
		Assert.assertNotNull(invoices, "Results array should not be null.");
		Assert.assertTrue(invoices.size() > 0, "Results array should contain at least one invoice.");

		// 3. Validate InvoiceNumber and InvoiceCode are not null for each invoice
		for (Map<String, Object> invoice : invoices) {
			Assert.assertNotNull(invoice.get("InvoiceNumber"), "InvoiceNumber should not be null.");
			Assert.assertNotNull(invoice.get("InvoiceCode"), "InvoiceCode should not be null.");
		}

		// Print the response for debugging
		System.out.println("Billing Invoices Response:");
		billingInvoicesResponse.prettyPrint();
	}

	@Test(priority = 16, groups = { "PL1" }, description = "1. Send a GET request to fetch the list of providers.\n"
	+ "2. Validate the following:\n"
	+ "   - Status field in the response is 'OK'.\n"
	+ "   - Status code of the response is 200.\n"
	+ "   - Results array (providers) is not null and contains at least one provider.\n"
	+ "   - EmployeeId and EmployeeName are not null for each provider."
)
	public void getProviderList() throws IOException {
		apiUtil = new ApiUtil();

		// Make API call
		Response providersListResponse = apiUtil.getProviderList("/Billing/GetProviderList", null);

		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH, "getProviderList",
				List.of("given", "then", "extract", "response"));

		System.out.println("---------------------------------------------" + isValidationSuccessful
				+ "------------------------------");

		// 1. Verify Status is "OK"
		String status = providersListResponse.jsonPath().getString("Status");
		Assert.assertEquals(status, "OK", "Status should be 'OK'.");

		// 2. Verify Status code is 200
		Assert.assertEquals(providersListResponse.statusCode(), 200, "Status code should be 200.");

		// Extract Results array
		List<Map<String, Object>> providers = providersListResponse.jsonPath().getList("Results");
		Assert.assertNotNull(providers, "Results array should not be null.");
		Assert.assertTrue(providers.size() > 0, "Results array should contain at least one provider.");

		// 3. Validate EmployeeId and EmployeeName are not null for each provider
		for (Map<String, Object> provider : providers) {
			Assert.assertNotNull(provider.get("EmployeeId"), "EmployeeId should not be null.");
			Assert.assertNotNull(provider.get("EmployeeName"), "EmployeeName should not be null.");
		}

		// Print the response for debugging
		System.out.println("Providers list Response:");
		providersListResponse.prettyPrint();
	}

	@Test(priority = 17, groups = { "PL1" }, description = "1. Send a GET request to fetch the list of users.\n"
	+ "2. Validate the following:\n"
	+ "   - Status field in the response is 'OK'.\n"
	+ "   - Status code of the response is 200.\n"
	+ "   - Results array (users) is not null and contains at least one user.\n"
	+ "   - UserId is unique across all users.\n"
	+ "   - ShortName and DepartmentName are not null for each user."
)
	public void getUserslist() throws IOException {
		apiUtil = new ApiUtil();

		// Make API call
		Response usersListReponse = apiUtil.getUserslist("/Billing/ListUsers", null);

		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH, "getUserslist",
				List.of("given", "then", "extract", "response"));

		System.out.println("---------------------------------------------" + isValidationSuccessful
				+ "------------------------------");

		// 1. Verify Status is "OK"
		String status = usersListReponse.jsonPath().getString("Status");
		Assert.assertEquals(status, "OK", "Status should be 'OK'.");

		// 2. Verify Status code is 200
		Assert.assertEquals(usersListReponse.statusCode(), 200, "Status code should be 200.");

		// Extract Results array
		List<Map<String, Object>> users = usersListReponse.jsonPath().getList("Results");
		Assert.assertNotNull(users, "Results array should not be null.");
		Assert.assertTrue(users.size() > 0, "Results array should contain at least one user.");

		// 3. Ensure UserId is unique
		Set<Integer> userIds = new HashSet<>();
		for (Map<String, Object> user : users) {
			Integer userId = (Integer) user.get("UserId");
			Assert.assertNotNull(userId, "UserId should not be null.");
			Assert.assertTrue(userIds.add(userId), "UserId " + userId + " is not unique.");
		}

		// 4. Validate ShortName and DepartmentName are not null for each user
		for (Map<String, Object> user : users) {
			Assert.assertNotNull(user.get("ShortName"), "ShortName should not be null.");
			Assert.assertNotNull(user.get("DepartmentName"), "DepartmentName should not be null.");
		}

		// Print the response for debugging
		System.out.println("Users list Response:");
		usersListReponse.prettyPrint();
	}

	@Test(priority = 18, groups = { "PL1" }, description = "1. Send a GET request to fetch the current fiscal year details.\n"
	+ "2. Validate the following:\n"
	+ "   - Status field in the response is 'OK'.\n"
	+ "   - Status code of the response is 200.\n"
	+ "   - Results object is not null.\n"
	+ "   - FiscalYearId is not null.\n"
	+ "   - FiscalYearName is not null."
)
	public void getCurrentFiscalYearDetails() throws IOException {
		apiUtil = new ApiUtil();

		// Make API call
		Response currentFiscalYearResponse = apiUtil.getCurrentFiscalYearDetails("/Billing/CurrentFiscalYear", null);

		boolean isValidationSuccessful = TestCodeValidator.validateTestMethodFromFile(FILEPATH,
				"getCurrentFiscalYearDetails", List.of("given", "then", "extract", "response"));

		System.out.println("---------------------------------------------" + isValidationSuccessful
				+ "------------------------------");

		// 1. Verify Status is "OK"
		String status = currentFiscalYearResponse.jsonPath().getString("Status");
		Assert.assertEquals(status, "OK", "Status should be 'OK'.");

		// 2. Verify Status code is 200
		Assert.assertEquals(currentFiscalYearResponse.statusCode(), 200, "Status code should be 200.");

		// 3. Extract Results object
		Map<String, Object> results = currentFiscalYearResponse.jsonPath().getMap("Results");
		Assert.assertNotNull(results, "Results object should not be null.");

		// 4. Ensure FiscalYearId and FiscalYearName are not null
		Integer fiscalYearId = (Integer) results.get("FiscalYearId");
		String fiscalYearName = (String) results.get("FiscalYearName");

		Assert.assertNotNull(fiscalYearId, "FiscalYearId should not be null.");
		Assert.assertNotNull(fiscalYearName, "FiscalYearName should not be null.");

		// Print the response for debugging
		System.out.println("Current Fiscal Year Response:");
		currentFiscalYearResponse.prettyPrint();
	}


}
