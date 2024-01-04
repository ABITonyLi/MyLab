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

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), 'autotest_add_签署中/已签署')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAG_search'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__cb'), 10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__cb'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_changecontract'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/tab_numinfo'))

WebUI.clearText(findTestObject('Page_ABI One Process Center/DAGDataPool/ContractChange_page/input_contractprice'))

String contractprice = Integer.valueOf((((Math.random() * 1000) + 100) as int)).toString() + '.00'

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractChange_page/input_contractprice'), 
    contractprice)

'切换到招标文件tab'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/tab_zhaobiaofile'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractChange_page/span_Others'))

uploadbtn = findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractChange_page/btn_fileupload')

CustomKeywords.'util.Filepicker.pickProjectFile'(uploadbtn, 'Include/resources/书签测试+(37)+(1)+(3).docx')

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/btn_zhaobiaofile_confirm'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/btn_zhaobiaofile_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractChange_page/btn_changecontract_submit'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractChange_page/btn_changecontract_submit_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAGdatapool_refresh'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/span_datagrid-row-expand'))

'对子表格验证'
table = findTestObject('Page_ABI One Process Center/DAGDataPool/table_DAGlist-contractlist')

WebUI.switchToFrame(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/iframe__ifm'), 30)

TableSubRows = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableRows'(table, 'tbody')

TableSubRows_All = TableSubRows.size()

'断言记录数据数量大于0'
assert TableSubRows_All > 0

TableSubColumns = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableColumns'(TableSubRows[0], 'td')

DAG_changestatus = TableSubColumns[14].text

assert DAG_changestatus == '已变更'

amount = TableSubColumns[22].text

assert amount == contractprice

WebUI.switchToDefaultContent()

WebUI.closeBrowser()

