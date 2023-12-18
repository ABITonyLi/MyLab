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

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), 
    10)

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), 'autotest_add_批量测试')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAG_search'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/span_datagrid-row-expand'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/span_datagrid-row-expand'))

'对子表格挑选未签署的合同条目'
table = findTestObject('Page_ABI One Process Center/DAGDataPool/table_DAGlist-contractlist')

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
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_batchcontract'))

var_confirmbtn = WebUI.waitForElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/tip_existingdraftbox'), 
    5, FailureHandling.OPTIONAL)

if (var_confirmbtn == true) {
    '确定'
    WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_existingdraftcontract_confirm'))
}

WebUI.switchToWindowTitle('合同签署流程')

List<WebElement> plist = WebUI.findWebElements(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/p_submitchecking'), 
    10)

assert plist.size() == 2

long currenttimestamp = System.currentTimeMillis() / 1000

println(currenttimestamp)

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_batchcontractname'), 
    'autotest批量发起' + currenttimestamp.toString())

WebUI.clearText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_ownemail'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_ownemail'), 
    GlobalVariable.ownemail)

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

'本模块应用到所有合同'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_applyall_1'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/tip_applysuccess'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_tip_applysuccess_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_applyall_2'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/tip_applysuccess'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_tip_applysuccess_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_applyall_5'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/tip_applysuccess'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_tip_applysuccess_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_applyall_3'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/tip_othercontractwillreplace'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_tip_applysuccess_confirm'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/tip_applysuccess'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_tip_applysuccess_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_applyall_4'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/tip_checkattachment'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_tip_applysuccess_confirm'))

'切换合同'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/td_contract_row2'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/alert_savesuccess'), 
    10)

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

var_passothersbtn = WebUI.waitForElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/tip_passothersteps'), 
    5, FailureHandling.OPTIONAL)

if (var_passothersbtn == true) {
    '确定'
    WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/tip_passothersteps_confirm'))
}

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

//WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/11/label_'))
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/tip_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Submit_page/tip_confirm'))

WebUI.closeBrowser()

'后置处理-审批人退回起草'
WebUI.callTestCase(findTestCase('合同签署流程(批量)/ProcessSteps/签署审批人退回起草'), [('applycontent') : currenttimestamp.toString()], FailureHandling.STOP_ON_FAILURE)

'后置处理-经办人取消实例'
WebUI.callTestCase(findTestCase('合同签署流程(批量)/ProcessSteps/经办人取消实例'), [('applycontent') : 'autotest批量发起' + currenttimestamp.toString()
        , ('contractcount') : 2], FailureHandling.STOP_ON_FAILURE)

