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

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_deletecontract_row1'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_batchcontract'))

WebUI.switchToWindowTitle('合同签署流程')

List<WebElement> plist = WebUI.findWebElements(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/ContractBatchSignProcess_Page/p_submitchecking'), 
    10)

assert plist.size() == 1

WebUI.closeBrowser()

