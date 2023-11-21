package util

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.By as By

import internal.GlobalVariable

public class WebUICustomKeywords {
	/**
	 * Get all rows of HTML table 获取HTML表格的总行数
	 * @param table Katalon test object represent for HTML table 参数1：HTML表格
	 * @param outerTagName outer tag name of TR tag, usually is TBODY 参数2：HTML表格下面的tag标签，一般为tbody
	 * @return All rows inside HTML table 返回HTML表格行的所有行数
	 */
	@Keyword
	def List getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUI.findWebElement(table)
		List selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}

	/**
	 * Get all cells of HTML table row 获取HTML表格行的所有单元格
	 * @param row a WebElement instance represent for HTML table row 参数1：HTML表格的总行数
	 * @param tagName HTML column tag name, usually is TD/TH 参数2：HTML表格下面的tag标签，一般为：TD或TH
	 * @return All cells inside HTML table row 返回HTML表格行的所有单元格
	 */
	@Keyword
	def List getHtmlTableColumns(WebElement row, String tagName) {
		List selectedColumns = row.findElements(By.tagName(tagName))
		return selectedColumns
	}
}
