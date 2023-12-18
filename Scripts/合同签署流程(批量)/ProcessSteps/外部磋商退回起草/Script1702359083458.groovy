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

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/Batchvendorconsult_page/radio_returndraft'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/Batchvendorconsult_page/input_vendorconsultapproveremark'),
	'autotest外部磋商退回起草')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/Batchvendorconsult_page/btn_vendorconsult_applythisallcontract'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/Batchvendorconsult_page/tip_vendorconsult_haveapplied'),
	10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/Batchvendorconsult_page/btn_vendorconsult_haveapplied'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/Batchvendorconsult_page/btn_vendorconsultdone_submit'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/Batchvendorconsult_page/tip_vendorconsultdone_isreturn'),
	10)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/Batchvendorconsult_page/btn_vendorconsult_isreturn'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/NeedToDoTask/Batchvendorconsult_page/btn_vendorconsult_haveapplied'))

WebUI.closeBrowser()