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

'前置处理-批量发起提交'
Map TCcallback = WebUI.callTestCase(findTestCase('合同签署流程(批量)/ProcessSteps/批量发起提交-基于模板'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('进入待处理任务'), [('password') : GlobalVariable.password, ('username') : GlobalVariable.signapprover], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/btn_batchexecute'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/btn_signapprovercheck'))

WebUI.waitForPageLoad(30)

'对表格验证'
table = findTestObject('Page_ABI One Process Center/NeedToDoTask/table_approvelist')

WebUI.switchToFrame(findTestObject('Page_ABI One Process Center/NeedToDoTask/iframe'), 30)
WebUI.delay(2)
TableRows = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableRows'(table, 'tbody[1]')

TableRows_All = TableRows.size()

'断言记录数据数量大于0'
assert TableRows_All > 0
'遍历找到正确的批量发起申请'
int loc = 0
for(int i = 0;i<TableRows_All;i++) {
	TableColumns = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableColumns'(TableRows[i], 'td')
	var_summary = TableColumns[4].text
	if (var_summary == TCcallback.get('timestamp')) {
		var_approver = TableColumns[2].text
		assert var_approver.contains('杨云玖')
		var_batchcount = TableColumns[5].text
		assert var_batchcount == '2'
		var_needtodocount = TableColumns[6].text
		assert var_needtodocount == '2'
		loc = i
		break
	}else {
		continue
	}
}

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/input__chk-'+(loc+1).toString()))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/btn_morebatchapprove'))

WebUI.switchToWindowTitle('批量审批')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/Batchapprove_page/span_viewmore'))

var0 = WebUI.getText(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/Batchapprove_page/span_total'), 
    FailureHandling.STOP_ON_FAILURE)
assert var0.contains('合同条目,目前已展示')
var1 = WebUI.getText(findTestObject('Page_ABI One Process Center/NeedToDoTask/Batchapprove_page/span_contractno_row2'))

var2 = WebUI.getText(findTestObject('Page_ABI One Process Center/NeedToDoTask/Batchapprove_page/span_contractno_row1'))

String[] varstring1 = var1.split('-')

v1 = (varstring1[(varstring1.length - 1)]).substring(0, (varstring1[(varstring1.length - 1)]).length() - 1)

//assert v1 == '001M'
String[] varstring2 = var2.split('-')

v2 = (varstring2[(varstring2.length - 1)]).substring(0, (varstring2[(varstring2.length - 1)]).length() - 1)

//assert v2 == '002M'
assert v1 > v2

WebUI.closeBrowser()

'后置处理-签署审批人退回'
WebUI.callTestCase(findTestCase('合同签署流程(批量)/ProcessSteps/签署审批人退回起草'), [('applycontent') : TCcallback.get('timestamp')], FailureHandling.STOP_ON_FAILURE)

'后置处理-经办人取消实例'
WebUI.callTestCase(findTestCase('合同签署流程(批量)/ProcessSteps/经办人取消实例'), [('applycontent') : TCcallback.get('contractname'), ('contractcount') : 2],
	FailureHandling.STOP_ON_FAILURE)
