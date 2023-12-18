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
    10)

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), 'autotest_add_批量测试')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAG_search'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/span_datagrid-row-expand'), 
    10)

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

        if (needcheckedcontract.size() < 1) {
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

if (needcheckedcontract.size() == 1) {
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

var_confirmbtn = WebUI.waitForElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/tip_existingdraftbox'), 
    5, FailureHandling.OPTIONAL)

if (var_confirmbtn == true) {
    '确定'
    WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_existingdraftcontract_confirm'))
}

WebUI.switchToWindowTitle('合同签署流程')
long currenttimestamp = System.currentTimeMillis() / 1000

println(currenttimestamp)
WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_batchcontractname'), 
    'autotest批量发起'+ currenttimestamp.toString())

WebUI.clearText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_ownemail'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_ownemail'), 
    GlobalVariable.ownemail)

'修改起草方式'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/a_draftstyle'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/div_draftstyle_upload'))

uploadbtn = findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_uploadfile')

CustomKeywords.'util.Filepicker.pickProjectFile'(uploadbtn, 'Include/resources/百威土建合同forAutotest.docx')

'设置对方经办人'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/btn_vendorsetting'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/btn_editvendor_row1'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/input_vendorname_row1'), 
    'tester')

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/input_vendoremail_row1'), 
    GlobalVariable.vendoremail)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/btn_row1_save'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/btn_edit_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/btn_vendorsetting_submit'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/VendorSetting_Page/btn_vendorsetting_confirm'))

'提交'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/btn_batchcontract_submit'))

'提示需要法务审批'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/tip_needlegalcheck'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_needlegalcheck_confirm'))

'选择法务'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_legalselect'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_legal_search'), 
    GlobalVariable.legal)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_legal_search'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input__chk'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_legal_search_confirm'))

'提交'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/btn_batchcontract_submit'))

var_passothersbtn = WebUI.waitForElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/tip_passothersteps'), 
    5, FailureHandling.OPTIONAL)

if (var_passothersbtn == true) {
    '确定'
    WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/tip_passothersteps_confirm'))
}

'选择签署审批人'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/btn_approver_select'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/input_approver_search'), 
    10)

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/input_approver_search'), 
    GlobalVariable.signapprover)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/btn_approver_search'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/input__chk'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/btn_approver_select_confirm'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/textarea_batchsummary'), 
    currenttimestamp.toString())

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/btn_batchcontract_finalsubmit'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/tip_confirm'))

WebUI.closeBrowser()
'法务审批处理'
WebUI.callTestCase(findTestCase('进入待处理任务'), [('username') : GlobalVariable.legal, ('password') : GlobalVariable.password], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/input_contractsignprocess_search'), 
    'autotest批量发起' + currenttimestamp.toString())

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/btn_contractsignprocess_search'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/a_contractapplycontent_link_1'))

WebUI.switchToWindowTitle('合同签署流程')

WebUI.click(findTestObject('Page_ABI One Process Center/NeedToDoTask/Legalapprove_page/btn_submitorreject_legal'))

WebUI.click(findTestObject('Page_ABI One Process Center/NeedToDoTask/Legalapprove_page/btn_checkcontractisok'))

WebUI.click(findTestObject('Page_ABI One Process Center/NeedToDoTask/Legalapprove_page/btn_submitorreject_legal'))

WebUI.setText(findTestObject('Page_ABI One Process Center/NeedToDoTask/Legalapprove_page/textarea_legalapproveremark'), 
    '法务审批通过')

WebUI.click(findTestObject('Page_ABI One Process Center/NeedToDoTask/Legalapprove_page/btn_legalsubmit'))

WebUI.click(findTestObject('Page_ABI One Process Center/NeedToDoTask/Legalapprove_page/btn_checkcontractisok'))

WebUI.closeBrowser()

'后置处理-审批人退回起草'
WebUI.callTestCase(findTestCase('合同签署流程(批量)/ProcessSteps/签署审批人退回起草'), [('applycontent') : currenttimestamp.toString(),('count'):'1'], FailureHandling.STOP_ON_FAILURE)

'后置处理-经办人取消实例'
WebUI.callTestCase(findTestCase('合同签署流程(批量)/ProcessSteps/经办人取消实例'), [('applycontent') : 'autotest批量发起' + currenttimestamp.toString()
		, ('contractcount') : 1], FailureHandling.STOP_ON_FAILURE)
