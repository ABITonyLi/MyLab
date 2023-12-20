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

WebUI.waitForPageLoad(60)

//WebUI.waitForPageLoad(30)
long currenttimestamp = System.currentTimeMillis() / 1000

println(currenttimestamp)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_batchcontractname'), 
    10)

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_batchcontractname'), 
    'autotest批量发起' + currenttimestamp.toString())

WebUI.clearText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_ownemail'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_ownemail'), 
    GlobalVariable.ownemail)

'基本模板起草合同'
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

'点击所有应用本模块到所有合同'
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

'保存'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_batchcontract_save'))

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/input_batchsummary'), 
    'value', 'autotest_add_批量测试', 10)

WebUI.clearText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Save_page/textarea_batchsummary'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/Save_page/textarea_batchsummary'), 
    currenttimestamp.toString())

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/span_batchcontract_submit'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/btn_save_confirm'))

WebUI.switchToWindowTitle('ABI One Process Center')

'设置返回值'
Map map = [:]

map.put('timestamp', currenttimestamp.toString())

map.put('contractname', 'autotest批量发起' + currenttimestamp.toString())

map.each({ def k, def v ->
        println("$k:$v")
    })

return map

