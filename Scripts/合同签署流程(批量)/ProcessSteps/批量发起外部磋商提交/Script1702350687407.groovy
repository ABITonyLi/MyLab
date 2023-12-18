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

WebUI.callTestCase(findTestCase('进入DAG数据池(批量)'), [:], FailureHandling.STOP_ON_FAILURE)

'搜索DAG'
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'),
	30)

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), 'autotest_add_批量测试')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAG_search'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/span_datagrid-row-expand'),
	30)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/span_datagrid-row-expand'))

'对子表格挑选未签署的合同条目'
table = findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/table_DAGlist-contractlist')

WebUI.switchToFrame(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/iframe__ifm'), 30)

TableSubRows = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableRows'(table, 'tbody')

List<WebElement> needcheckedcontract = new ArrayList()

for (int i = 0; i < TableSubRows.size(); i++) {
	TableSubColumns = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableColumns'(TableSubRows[i], 'td')

	if (TableSubColumns[8].text == '未签署') {
		println(needcheckedcontract.size())

		if (needcheckedcontract.size() < 2) {
			int val = i + 1

			needcheckedcontract.add(val)

			println(needcheckedcontract)
		} else {
			break
		}
	} else {
		continue
	}
}

WebUI.switchToDefaultContent()

if (needcheckedcontract.size() == 2) {
	for (int i = 0; i < needcheckedcontract.size(); i++) {
		String value = needcheckedcontract.get(i)

		String objectstring = 'Object Repository/Page_ABI One Process Center/DAGDataPool/input__ck-' + value

		WebUI.click(findTestObject(objectstring))
	}
} else {
	println('不足勾选未签署的合同条目数')

	assert false
}

//WebUI.switchToDefaultContent()
//WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__ck-1'))
//WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input__ck-2'))
'批量发起合同'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_batchcontract'))

'判断草稿箱中存在此合同'
var_confirmbtn = WebUI.waitForElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/tip_existingdraftbox'),
	5, FailureHandling.OPTIONAL)

if (var_confirmbtn == true) {
	'确定'
	WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_existingdraftcontract_confirm'))
}

WebUI.switchToWindowTitle('合同签署流程')

/*
'检查未验证条目'
List<WebElement> plist = WebUI.findWebElements(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/p_submitchecking'),
	10)

assert plist.size() == 2
*/
WebUI.waitForPageLoad(40)
long currenttimestamp = System.currentTimeMillis() / 1000

println(currenttimestamp)
'输入合同信息'
WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_batchcontractname'),
	'autotest批量发起外部磋商' + currenttimestamp.toString())

WebUI.clearText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_ownemail'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_ownemail'),
	GlobalVariable.ownemail)

'选择外部磋商'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/Batchapprove_page/radio_vendorconsult'))

'基本模板起草合同'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_selecttemplate'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_selecttemplate_search'),
	30)

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_selecttemplate_search'),
	'autotest')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_selecttemplate_search'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/div_autotestV1.0.docx'),
	30)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/div_autotestV1.0.docx'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_selecttemplate_search_confirm'))

//'检查价格清单框'
//WebUI.verifyElementNotVisible(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/div_priceremark'))
'本页面应用所有合同'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_applypageonallcontract'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/tip_pagecontentwillapplyallcontract'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_applyallcontract_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_applyallcontract_confirm'))

'设置对方经办人'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/btn_vendorsetting'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/btn_editvendor_row1'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/input_vendorname_row1'),
	'tester')

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/input_vendoremail_row1'),
	GlobalVariable.vendoremail)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/btn_row1_save'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/btn_edit_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/btn_editvendor_row2'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/input_vendorname_row2'),
	'tester')

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/input_vendoremail_row2'),
	GlobalVariable.vendoremail)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/btn_row2_save'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/btn_edit_confirm'))

//WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/btn_vendorsetting_submit'),
//	10)
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/btn_vendorsetting_submit'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/btn_vendorsetting_confirm'))

'提交'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/btn_batchcontract_submit'))

WebUI.clearText(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/Batchapprove_page/textarea_internalconsultremark'))

/*
var_passothersbtn = WebUI.waitForElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/tip_passothersteps'),
	5, FailureHandling.OPTIONAL)

if (var_passothersbtn == true) {
	'确定'
	WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/tip_passothersteps_confirm'))
}
*/
WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/Batchapprove_page/textarea_internalconsultremark'),
	currenttimestamp.toString())

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/Batchapprove_page/btn_consult_submit'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/Batchapprove_page/btn_consult_submit_confirm'))

'模拟外部磋商处理'
WebUI.switchToWindowTitle('ABI One Process Center')
'我的任务'
WebUI.click(findTestObject('Page_ABI One Process Center/span_mytask'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/span_appliedtask'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/AppliedTask/input_appliedtask_search'), 'autotest批量发起外部磋商' + currenttimestamp.toString())

'断言记录数据数量为2'
for (int i = 0; i < 6; i++) {
	WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/AppliedTask/btn_appliedtask_search'))

	'对表格验证'
	table = findTestObject('Object Repository/Page_ABI One Process Center/AppliedTask/table_appliedtasklist')

	WebUI.switchToFrame(findTestObject('Object Repository/Page_ABI One Process Center/AppliedTask/iframe_concat(id(, , AppliedFram, , ))_AppliedFram'),
		30)

	TableSubRows = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableRows'(table, 'tbody[1]')

	TableSubRows_All = TableSubRows.size()

	WebUI.switchToDefaultContent()

	if (TableSubRows_All == 2) {
		break
	} else {
		WebUI.delay(5)

		continue
	}
}

for (int i = 0; i < 2; i++) {
	WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/AppliedTask/a_contractlink_row' + (i + 1).toString()))

	WebUI.switchToWindowTitle('合同签署流程')

	WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/AppliedTask/btn_cpoylink'))

	WebUI.delay(2)

	url = CustomKeywords.'util.ClipboardTool.getClipboardString'()

	WebUI.navigateToUrl(url)

	WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/AppliedTask/btn_vendorsubmit'))

	WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/AppliedTask/input_owneremail'), GlobalVariable.ownemail)

	WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/AppliedTask/textarea_vendorremark'), 'autotest供应商通过')

	WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/AppliedTask/btn_finalvendorsubmit'))

	WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/AppliedTask/btn_finalvendorsubmit_confirm'))

	WebUI.closeWindowTitle('合同签署流程')

	WebUI.switchToWindowTitle('ABI One Process Center')
}

WebUI.closeBrowser()

'设置返回值'
Map map = [:]

map.put('timestamp', currenttimestamp.toString())

map.put('contractname', 'autotest批量发起外部磋商' + currenttimestamp.toString())

map.each({ def k, def v ->
		println("$k:$v")
	})

return map
