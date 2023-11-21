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

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAGdatapool_add'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_country_select'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/country_Korea'))

var1 = WebUI.verifyElementNotVisible(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_add_page/label_Auction Type'))

assert var1 == true

var2 = WebUI.verifyElementNotVisible(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_add_page/label_Best RFQ'))

assert var2 == true

var3 = WebUI.verifyElementNotVisible(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_add_page/label_Budget'))

assert var3 == true

var4 = WebUI.verifyElementNotVisible(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_add_page/label_DAG'))

assert var4 == true

var5 = WebUI.verifyElementNotVisible(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_add_page/label_E-auction Required'))

assert var5 == true

var6 = WebUI.verifyElementNotVisible(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_add_page/label_Exclusive supplier approval is required'))

assert var6 == true

var7 = WebUI.verifyElementNotVisible(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_add_page/label_Incumbent'))

assert var7 == true

var8 = WebUI.verifyElementNotVisible(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_add_page/label_Kickoff Date'))

assert var8 == true

var9 = WebUI.verifyElementNotVisible(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_add_page/label_Lowest Offer Largest Share'))

assert var9 == true

var16 = WebUI.verifyElementNotVisible(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_add_page/label_LPP'))

assert var16 == true

var10 = WebUI.verifyElementNotVisible(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_add_page/label_New Supplier'))

assert var10 == true

var11 = WebUI.verifyElementNotVisible(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_add_page/label_PR ID'))

assert var11 == true

var12 = WebUI.verifyElementNotVisible(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_add_page/label_Saving vs. Best RFQ'))

assert var12 == true

var13 = WebUI.verifyElementNotVisible(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_add_page/label_Saving vs. Budget'))

assert var13 == true

var14 = WebUI.verifyElementNotVisible(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_add_page/label_Saving vs. LPP'))

assert var14 == true

var15 = WebUI.verifyElementNotVisible(findTestObject('Page_ABI One Process Center/DAGDataPool/DAG_add_page/label_Supplier Invited'))

assert var15 == true

WebUI.closeBrowser()

