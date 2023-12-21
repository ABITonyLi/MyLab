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

long timestamp = System.currentTimeMillis()

String content = 'autotest_add_' + timestamp

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_DAG_describe'), 
    content)

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_country_select'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/country_China'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_CMmodel'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_RPSS'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_dag_category'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_Commercial'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_sub_category'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_Sales'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_oneoff_contract'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_oneoff_contract_yes'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_classification'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_classification_material'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_payment_run'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_1x run per month'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_baseline'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_baseline_EOM'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_curreny'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_curreny_CNY'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_low_big'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_low_big_yes'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_iprice'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_NA'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_budget'), '200')

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_pre_price'), 
    '100')

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_best_price'), 
    '300')

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/textarea_project_desrcibe'), 
    'this is autotest testcase: submit')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_jingbiao'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_jingbiao_no'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_jingbiao_type'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_jingbiaotype_English'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_existingvendor'), 
    '1')

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_newvendor'), 
    '2')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_needvendor'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_needvendor_no'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/textarea_tip'), 'autotest test submit')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_SpotBuy'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_SpotBuy_other'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_PR ID'), '333')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_startdate'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/a_startdate_today'))

'切换到合同条目数信息tab'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/tab_numinfo'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/btn_numinfo_add'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_contractlevel'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_contract_duli'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_contractuser'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_user_search'), 
    10)

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_user_search'), 
    '28070907')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/btn_user_search'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input__chk'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/btn_adduser_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_contractsatrtdate'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/a_numinfo_contractstartdate'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_contractenddate'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div__calendar-nav calendar-nextyear calenda_b62f14'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/td_13'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_contractprice'), 
    '2500')

'滚到元素出现'
WebUI.scrollToElement(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/a__textbox-icon combo-arrow'), 
    30)

//WebUI.executeJavaScript("window.scrollTo(100,400);", null)
//'Use Javascript to make an alert'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/a__textbox-icon combo-arrow'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/div_3 input tax, China'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_company'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_company_search'), 
    'CN17')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/btn_company_search'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input__ck'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/btn_addcompany_confirm'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_vendor'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_vendor_search'), 
    'baiwei')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/btn_vendor_search'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input__ck (1)'))

//WebUI.scrollToElement(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/btn_addcompany_confirm'),
//	30)
//WebUI.executeJavaScript("window.scrollTo(100,400);", null)
'滚到元素出现'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/btn_addvendor_confirm'))

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_paymentcondition'), 
    '1')

WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_prepaymentcondition'), 
    '1')

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/input_changepaymentcondition'), 
    FailureHandling.STOP_ON_FAILURE)

'切换到招标文件tab'
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/tab_zhaobiaofile'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/span_zhaobiaofile_DAG'))

//WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/span_zhaobiaofile_Others'))
uploadbtn = findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/btn_zhaobiaofile_upload')

CustomKeywords.'util.Filepicker.pickProjectFile'(uploadbtn, 'Include/resources/书签测试+(37)+(1)+(3).docx')

//WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/btn_zhaobiaofile_upload'))
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/btn_zhaobiaofile_confirm'))

//WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/btn_uploadfile_confirm'))
WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/btn_addDAGdatapool_submit'))

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/DAG_add_page/btn_submit_confirm'))

int i = 10

while (i) {
    WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAGdatapool_refresh'))

    WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), content)

    WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAG_search'))

    varexistingdata = WebUI.verifyElementPresent(findTestObject('Page_ABI One Process Center/DAGDataPool/div_tip_nodata'),
            10,FailureHandling.OPTIONAL)
	
    if (!varexistingdata) {
            break
    }
    
    i--
}

'对表格验证'
table = findTestObject('Page_ABI One Process Center/DAGDataPool/table_DAGlist')

WebUI.switchToFrame(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/iframe__ifm'), 30)

TableRows = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableRows'(table, 'tbody')

TableRows_All = TableRows.size()

'断言记录数据数量大于0'
assert TableRows_All > 0

TableColumns = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableColumns'(TableRows[0], 'td')

DAG_describe = TableColumns[5].text

assert DAG_describe == content

DAG_source = TableColumns[23].text

assert DAG_source == '手动录入'

DAG_status = TableColumns[25].text

assert DAG_status == '有效'

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/span_datagrid-row-expand'))

'对子表格验证'
table = findTestObject('Page_ABI One Process Center/DAGDataPool/table_DAGlist-contractlist')

WebUI.switchToFrame(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/iframe__ifm'), 30)

TableSubRows = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableRows'(table, 'tbody')

TableSubRows_All = TableSubRows.size()

'断言记录数据数量大于0'
assert TableSubRows_All > 0

TableSubColumns = CustomKeywords.'util.WebUICustomKeywords.getHtmlTableColumns'(TableSubRows[0], 'td')

DAG_contractstatus = TableSubColumns[8].text

assert DAG_contractstatus == '未签署'

WebUI.switchToDefaultContent()

//WebUI.clearText(findTestObject('Page_ABI One Process Center/DAGDataPool/input_DAG_search'))
//WebUI.setText(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/input_DAG_search'), content)
//WebUI.click(findTestObject('Object Repository/Page_ABI One Process Center/DAGDataPool/btn_DAG_search'))
WebUI.click(findTestObject('Page_ABI One Process Center/DAGDataPool/input__cb'))

WebUI.click(findTestObject('Page_ABI One Process Center/DAGDataPool/btn_DAGdatapool_delete'))

WebUI.check(findTestObject('Page_ABI One Process Center/DAGDataPool/btn_delete_confirm'))

WebUI.check(findTestObject('Page_ABI One Process Center/DAGDataPool/btn_delete_confirm'))

WebUI.closeBrowser()

