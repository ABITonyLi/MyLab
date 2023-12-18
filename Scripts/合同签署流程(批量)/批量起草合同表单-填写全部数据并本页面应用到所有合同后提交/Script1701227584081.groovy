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

Map TCcallback = WebUI.callTestCase(findTestCase('合同签署流程(批量)/ProcessSteps/批量发起提交-基于模板'), [:], FailureHandling.STOP_ON_FAILURE)

'后置处理-审批人退回起草'
WebUI.callTestCase(findTestCase('合同签署流程(批量)/ProcessSteps/签署审批人退回起草'), [('applycontent') : TCcallback.get('timestamp')], FailureHandling.STOP_ON_FAILURE)

'后置处理-经办人取消实例'
WebUI.callTestCase(findTestCase('合同签署流程(批量)/ProcessSteps/经办人取消实例'), [('applycontent') : TCcallback.get('contractname'), ('contractcount') : 2], 
    FailureHandling.STOP_ON_FAILURE)

