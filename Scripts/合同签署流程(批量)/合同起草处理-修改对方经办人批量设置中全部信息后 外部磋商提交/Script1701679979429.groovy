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

'前置处理-审批人退回起草'
WebUI.callTestCase(findTestCase('合同签署流程(批量)/ProcessSteps/签署审批人退回起草'), [('applycontent') : TCcallback.get('timestamp')], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('进入待处理任务'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/btn_batchexecute'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/btn_contractdraftexecute'))

WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/btn_morebatchapprove'), 
    10)

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

for (int i = 0; i < TableRows_All; i++) {
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
    } else {
        continue
    }
}

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/btn_contractdraft-' + (loc + 1).toString()))

WebUI.switchToWindowTitle('合同签署流程')

WebUI.waitForPageLoad(30)

long currenttimestamp = System.currentTimeMillis() / 1000

println(currenttimestamp)

WebUI.clearText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_batchcontractname'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_batchcontractname'), 
    'autotest外部磋商' + currenttimestamp.toString())

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_applyall_1'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/tip_applysuccess'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_tip_applysuccess_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/Batchapprove_page/radio_vendorconsult'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_applyall_5'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/tip_applysuccess'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_tip_applysuccess_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_selecttemplate'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_selecttemplate_search'), 
    10)

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_selecttemplate_search'), 
    'autotest')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_selecttemplate_search'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/div_autotestV1.0.docx'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/div_autotestV1.0.docx'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_selecttemplate_search_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_applyall_3'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/tip_othercontractwillreplace'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_tip_applysuccess_confirm'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/tip_applysuccess'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_tip_applysuccess_confirm'))

'切换合同'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/td_contract_row2'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/alert_savesuccess'), 
    10)

'提交'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/btn_batchcontract_submit'))

WebUI.clearText(findTestObject('Page_ABI One Process Center/NeedToDoTask/Batchapprove_page/textarea_internalconsultremark'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/Batchapprove_page/textarea_internalconsultremark'), 
    'autotest外部磋商' + currenttimestamp.toString())

WebUI.click(findTestObject('Page_ABI One Process Center/NeedToDoTask/Batchapprove_page/btn_consult_submit'))

WebUI.click(findTestObject('Page_ABI One Process Center/NeedToDoTask/Batchapprove_page/btn_consult_submit_confirm'))

'模拟外部磋商处理'
WebUI.switchToWindowTitle('ABI One Process Center')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/span_appliedtask'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/AppliedTask/input_appliedtask_search'), 'autotest外部磋商' + 
    currenttimestamp.toString())

//WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/AppliedTask/btn_appliedtask_search'))
//WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/AppliedTask/table_appliedtasklist'))
//'对表格验证'
//table = findTestObject('Object Repository/Page_ABI One Process Center/AppliedTask/table_appliedtasklist')
//WebUI.switchToFrame(findTestObject('Object Repository/Page_ABI One Process Center/AppliedTask/iframe_concat(id(, , AppliedFram, , ))_AppliedFram'), 
//    30)
//TableSubRows = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableRows'(table, 'tbody[1]')
//TableSubRows_All = TableSubRows.size()
//WebUI.switchToDefaultContent()
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

'后置处理-外部磋商完成退回起草'
WebUI.callTestCase(findTestCase('进入待处理任务'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/btn_batchexecute'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/btn_batchvendorconsultdone'))

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
int loc2 = 0

for (int i = 0; i < TableRows_All; i++) {
	TableColumns = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableColumns'(TableRows[i], 'td')

	var_summary = TableColumns[4].text

	if (var_summary == currenttimestamp.toString()) {
		var_approver = TableColumns[2].text

		assert var_approver.contains('杨云玖')

		var_batchcount = TableColumns[5].text

		assert var_batchcount == '2'

		var_needtodocount = TableColumns[6].text

		assert var_needtodocount == '2'

		loc2 = i

		break
	} else {
		continue
	}
}

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/btn_vendorconsultdone-' + (loc2 + 1).toString()))

WebUI.switchToWindowTitle('批量外部磋商完成')

WebUI.callTestCase(findTestCase('合同签署流程(批量)/ProcessSteps/外部磋商退回起草'), [:], FailureHandling.STOP_ON_FAILURE)

'后置处理-经办人取消实例'
WebUI.callTestCase(findTestCase('合同签署流程(批量)/ProcessSteps/经办人取消实例'), [('applycontent') : 'autotest外部磋商' + currenttimestamp.toString()
        , ('contractcount') : 2], FailureHandling.STOP_ON_FAILURE)

