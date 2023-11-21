import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.util.Date
import java.text.SimpleDateFormat

WebUI.callTestCase(findTestCase('进入DAG数据池(批量)'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), 
    10)

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), 'autotest_add_1条未签署')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAG_search'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__cb'), 10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__cb'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAGinfosupplement'))

WebUI.clearText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_infosupplement_page/input_PR ID_DAGinfosupplement'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_infosupplement_page/input_PR ID_DAGinfosupplement'), 
    '334')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_infosupplement_page/a_startdate'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_infosupplement_page/a_today'))

WebUI.click(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_infosupplement_page/a_enddate'))

WebUI.click(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_infosupplement_page/a_enddate_today'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_infosupplement_page/btn_DAGinfosupplement_submit'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_infosupplement_page/btn_DAGinfosupplement_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAGdatapool_modify'))

WebUI.verifyElementAttributeValue(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_modify_page/input_PR ID_nextinput'), 
    'value', '334', 10)

Date currentDate = new Date()
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd")
String dateString = dateFormat.format(currentDate)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_modify_page/input_checkdate_nextinput'), 
    'value', dateString, 10)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_modify_page/input_startdate_nextinput'),
	'value', dateString, 10)


WebUI.closeBrowser()

