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
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.annotation.Keyword as Keyword
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.callTestCase(findTestCase('进入DAG数据池(批量)'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAGdatapool_add'))

long timestamp = System.currentTimeMillis()

String content = 'autotest_add_' + timestamp

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_DAG_describe'), 
    content)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_country_select'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/country_China'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_CMmodel'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_RPSS'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_dag_category'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_Commercial'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_sub_category'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_Sales'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_oneoff_contract'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_oneoff_contract_yes'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_classification'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_classification_material'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_payment_run'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_1x run per month'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_baseline'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_baseline_EOM'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_curreny'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_curreny_CNY'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_low_big'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_low_big_yes'))

WebUI.click(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_iprice'))

WebUI.click(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_NA'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/btn_addDAGdatapool_draft'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/btn_drafttip_yes'))

int i = 10

while (i) {
	WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAGdatapool_refresh'))

	WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), content)

	WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAG_search'))

	varexistingdata = WebUI.verifyElementPresent(findTestObject('Page_ABI One Process Center/DAGDataPool/div_tip_nodata'),
			10,FailureHandling.OPTIONAL)
	
	if (!varexistingdata) {
			break
	}
	
	i--
}

'对表格验证'
table = findTestObject('Page_ABI One Process Center/DAGDataPool/table_DAGlist')

WebUI.switchToFrame(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/iframe__ifm'), 30)

TableRows = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableRows'(table, 'tbody')

TableRows_All = TableRows.size()

'断言记录数据数量大于0'
assert TableRows_All > 0

TableColumns = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableColumns'(TableRows[0], 'td')

DAG_describe = TableColumns[5].text

assert DAG_describe == content

DAG_source = TableColumns[23].text

assert DAG_source == '手动录入'

DAG_status = TableColumns[25].text

assert DAG_status == '草稿'

WebUI.switchToDefaultContent()
'删除草稿数据'
WebUI.click(findTestObject('Page_ABI One Process Center/DAGDataPool/input__cb'))

WebUI.click(findTestObject('Page_ABI One Process Center/DAGDataPool/btn_DAGdatapool_delete'))

WebUI.check(findTestObject('Page_ABI One Process Center/DAGDataPool/btn_delete_confirm'))

WebUI.check(findTestObject('Page_ABI One Process Center/DAGDataPool/btn_delete_confirm'))

WebUI.closeBrowser()

