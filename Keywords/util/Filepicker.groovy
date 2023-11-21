package util
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


import java.awt.AWTException
import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent

import com.kms.katalon.core.configuration.RunConfiguration


public class Filepicker {
	@Keyword
	def pickFile (TestObject to, String filePath) {
		WebUI.click(to)
		println filePath
		StringSelection ss = new StringSelection(filePath)
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null)
		// Robot robot = new Robot()
		Robot robot = null
		try{
			robot = new Robot()
			robot.delay(3000)
			robot.keyPress(KeyEvent.VK_ENTER)
			robot.keyRelease(KeyEvent.VK_ENTER)
			robot.delay(1000)
			robot.keyPress(KeyEvent.VK_CONTROL)
			robot.keyPress(KeyEvent.VK_V)
			robot.keyRelease(KeyEvent.VK_V)
			robot.delay(1000)
			robot.keyRelease(KeyEvent.VK_CONTROL)
			robot.keyPress(KeyEvent.VK_ENTER)
			robot.keyRelease(KeyEvent.VK_ENTER)
		}catch(AWTException e){
			println e.getStackTrace()
		}
	}

	@Keyword
	def pickProjectFile (TestObject to, String filePath) {
		String ProjectPath = RunConfiguration.getProjectDir()
		File file = new File(ProjectPath +  "/" + filePath)
		pickFile(to, file.getAbsolutePath())
	}
}
