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

WebUI.callTestCase(findTestCase('进入DAG数据池(批量)'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), 
    10)

'DAG数据负责人非本人'
WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), '1026TEST001')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAG_search'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__cb'), 10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__cb'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAGdatapool_modify'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/tip_modifyDAG_nopermission'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_modifyDAG_nopermission_confirm'))

'DAG数据负责人本人,未签署a'
WebUI.clearText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), 'autotest_add_1条未签署')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAG_search'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__cb'), 10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__cb'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAGdatapool_modify'))

var_vendorchangednowbtn = WebUI.waitForElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_modify_page/tip_vendorchangednow'), 5)

if (var_vendorchangednowbtn == true) {

	WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_modify_page/btn_tip_vendorchangednow_confirm'))
}

WebUI.verifyElementNotHasAttribute(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_modify_page/input_DAGdescribe'), 
    'readonly', 10)

WebUI.verifyElementNotHasAttribute(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_modify_page/input_DAGemail'), 
    'readonly', 10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/tab_numinfo'))

WebUI.verifyElementNotHasAttribute(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_modify_page/input_contractuser_row1'), 
    'disabled', 10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_modify_page/btn_modifyDAG_close'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_modify_page/btn_modifyDAG_close_confirm'))

'DAG数据负责人本人，存在签署中b'
WebUI.clearText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), 'autotest_add_未签署/签署中')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAG_search'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__cb'), 10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__cb'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAGdatapool_modify'))

WebUI.verifyElementHasAttribute(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_modify_page/input_DAGdescribe'), 
    'readonly', 10)

WebUI.verifyElementHasAttribute(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_modify_page/input_DAGemail'), 
    'readonly', 10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/tab_numinfo'))

WebUI.verifyElementNotHasAttribute(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_modify_page/input_contractuser_row1'), 
    'disabled', 10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_modify_page/btn_modifyDAG_close'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_modify_page/btn_modifyDAG_close_confirm'))

'DAG数据负责人本人，无未签署c'
WebUI.clearText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), 'autotest_add_1条签署中')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAG_search'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__cb'), 10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__cb'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAGdatapool_modify'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_modify_page/tip_modifyDAG_norightdata'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_modify_page/btn_modifyDAG_norightdata_confirm'))

WebUI.closeBrowser()


