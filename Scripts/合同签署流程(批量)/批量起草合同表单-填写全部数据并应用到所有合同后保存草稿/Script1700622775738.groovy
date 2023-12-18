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

Map TCcallback = WebUI.callTestCase(findTestCase('合同签署流程(批量)/ProcessSteps/批量起草合同保存'), [:], FailureHandling.STOP_ON_FAILURE)

'验证草稿箱中生成'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/span_mytask'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DraftBox/span_draft'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DraftBox/input_draft_search'), TCcallback.get(
        'timestamp'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DraftBox/btn_draft_search'))

'对表格验证'
table = findTestObject('Object Repository/Page_ABI One Process Center/DraftBox/table_draftlist')

WebUI.switchToFrame(findTestObject('Object Repository/Page_ABI One Process Center/DraftBox/iframe_concat(id(, , CGXFram, , ))_CGXFram'), 
    30)

TableRows = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableRows'(table, 'tbody')

TableRows_All = TableRows.size()

'断言记录数据数量大于0'
assert TableRows_All > 0

TableColumns = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableColumns'(TableRows[0], 'td')

savetime = CustomKeywords.'util.TimeConversion.StringToTimestamp'(TableColumns[6].text)

WebUI.switchToDefaultContent()

println(savetime)

assert savetime >= Long.valueOf(TCcallback.get('timestamp'))

'后置处理-删除保存在草稿的合同'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DraftBox/input__chk'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DraftBox/btn_delete'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DraftBox/btn_delete_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DraftBox/btn_delete_confirm'))

WebUI.closeBrowser()