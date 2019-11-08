package uiObjInfo;

public class UILocators {

	// gLogin
	public String gsiginlink_xp = "//a[text()='Sign in']";
	public String gUserName_id = "id=identifierId";
	public String gnext_xp = "//span[text()='Next']";
	public String gPassword_xp = "//input[@name='password']";
	public String gLoginbtn_xp = "//span[text()='Next']";

	// gLogout
	public String guser_xp = "//a[contains(text(),'Google Account')]";
	// this can also used instead of text "//a[contains(.,'Google Account')]"
	public String glogout_xp = "//a[.='Sign out']";

	// Login page
	public String username_id = "id=userid";
	public String password_id = "id=password";
	public String signin_id = "id=btnActive";

	// Home page
	public String home_id = "id=pt1:_UIShome::icon";
	public String Payables_id = "id=groupNode_payables";
	public String Invoices_xp = "//div[@title='Invoices']";
	public String Payments_xp = "//div[@title='Payments']";
	public String Sudarshan_xp = "//span[@title='Vulavala Sudarshanreddy']";

	// Task bar
	public String TaskBar_xp = "//div[@title='Tasks']";
	
	
	
	//Validation For Supplier Search Results
	public String SuppNoResults_xp = "//div[text()='No rows to display']";
	//Validation For Invoice Number Results
	public String InvNoResults_xp = "//div/span[contains(text(),'This invoice number already exists.')]";
	
	
	
	
	// Create invoice
	public String create_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:_FOTRaT:0:RAtl1']";
	//Create Mass Additions
	public String CreateMassAdditions_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:_FOTRaT:0:RAtl16']";
	//Accounting Date
	public String AccountingDate_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:ap1:r1:basicReqBody:paramDynForm_ATTRIBUTE1_ATTRIBUTE1::content']";
	//Asset Book
	public String AssetBook_xp = "//option[@title='CYTK US CORP BOOK']";
	//Assetbook
	public String AssetBook1_xp = "//select[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:ap1:r1:basicReqBody:paramDynForm_ATTRIBUTE2_ATTRIBUTE2::content']";

	//Submit
	public String Submit_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:ap1:r1:requestBtns:submitButton']";
	//Ok
	public String SubmitOk_xp = "//button[text()='OK']";
	//Fixed Assets
	public String FixedAssets_xp = "//a[text()='Fixed Assets']";
	//Assets
	public String Assets_xp = "//a[text()='Assets']";
	
	
	
	//Multiperiod Accounting Invoice
	public String MultiperiodAccounting_xp = "//a[text()='Multiperiod Accounting']";
	//Accrual Account
	public String AccrualAccount_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:kf10KBIMG']";
	//Accrual Department Drop down
	public String AccrualDepartmentDD_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:kf10SPOP_query:value10::lovIconId']";
	
	
	//Accrual Department
	public String AccrualDepartment_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:kf10SPOP_query:value10::content']";
	//Accrual AutoSearch
	public String AccrualSearch_xp = "//table[@class='x1nj']/tbody/tr/td";
	//Accrual Account
	public String AccrualAccount1_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:kf10SPOP_query:value20::content']";
	//Accrual Account Dropdown
	public String AccrualAccountDD_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:kf10SPOP_query:value20::lovIconId']";
	//Accrual Ok
	public String AccrualOk_xp = "//button[text()='O']";
	//Start Date
	public String AccrualStartDate_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:id3::content']";
	//End Date
	public String AccrualEndDate_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:id6::content']";
	
	
	// Invoice Header-Identifying PO
	public String PO_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r2:0:ic1::content']";
	// Business Unit
	public String BU_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r2:0:ic2::content']";
	// Business Drop Down
	public String BUdrop_xp = "//span[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:r2:0:ic2::cntnrSpan']";
	// BU Select Option
	public String BUselect_xp = "//tr[@_afrrk='0']";
	// Supplier
	public String Supp_xp = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:r2:0:ic3::content']";
	// Supplier Select
	public String Suppselect_xp = "//tr[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:r2:0:pl3']";
	// Supplier Number label
	public String Suppnum_xp = "//label[text()='Supplier Number']";
	// Supplier Advanced Search controls
	// Supplier Search
	public String SupplierSearch1_xp = "//a[contains(@title,'Search: Supplier')]";
	// Advanced
	public String SupplierAdvanced_xp = "//button[@accesskey='d']";
	// Supplier name
	public String Suppliernameadv_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r2:0:ic3::_afrLovInternalQueryId:value00::content']";
	// Supplier number
	public String Suppliernoadv_xp = "//select[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r2:0:ic3::_afrLovInternalQueryId:operator1::content']";
	// Taxpayer dd
	public String Suppliertaxpayerdd_xp = "//select[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r2:0:ic3::_afrLovInternalQueryId:operator2::content']";
	// Search
	public String Suppsearch_xp = "//button[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r2:0:ic3::_afrLovInternalQueryId::search']";
	public String SuppSelect1_xp = "//table[@_afrit='1']//tr/td[1]/span";
	// ok
	public String Suppok_xp = "//button[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r2:0:ic3::lovDialogId::ok']";
	// Goods Line Select
	public String Goodsline_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:p14']";
	// Click
	public String Goodsclick_xp = "//label[@for='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r11:1:at1:_ATp:ta1:0:sb1::content']";
	// Quantity
	public String Goodsquantity_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r11:1:at1:_ATp:ta1:0:i1::content']";
	// Unit Price
	public String GoodsUnitPrice_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r11:1:at1:_ATp:ta1:0:i2::content']";
	// Goods Ok
	public String GoodsOk_xp = "//button[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:cb17']";
	// Amount
	public String ServicesAmount_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r11:1:at1:_ATp:ta1:0:i3::content']";
	// Supplier Site
	public String Site_xp = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:r2:0:ic4::content']";
	// Attribute pop-up
	public String pop_xp = "//button[@id='d1::msgDlg::cancel']";
	// Number
	public String Number_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r2:0:i2::content']";
	// Amount
	public String Amount_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r2:0:i3::content']";
	// Type
	public String Type_xp = "//select[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:r2:0:so1::content']";
	// Debit Memo
	public String Debit_xp = "//option[@title='Debit memo']";
	// Credit Memo
	public String Credit_xp = "//option[@title='Credit memo']";
	// Date
	public String Date_xp = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:r2:0:id2::content']";
	// Date Calendar
	public String Datecal_xp = "//a[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:r2:0:id2::glyph']";
	// Payment Terms
	public String Payment_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r2:0:so3::content']";
	// Payment drop Terms
	public String Paymentdd_xp = "//span[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r2:0:so3::cntnrSpan']";
	// Terms Date
	public String Terms_xp = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:r2:0:id5::content']";
	// Requester
	public String Requester_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r2:0:ic6::content']";
	// Show More
	public String Showmore_xp = "//table[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:p4']";
	// Show Less
	public String Showless_xp = "//a[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:cl2']";
	// Accounting
	public String Accounting_xp = "//a[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:sm2::disAcr']";
	// Accounting Date
	public String Datecalendar_xp = "//a[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:id4::glyph']";
	public String Datemanual_xp = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:id4::content']";
	// Lines Tilt
	public String Lines_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:sh2::_afrDscl']";
	// Lines tilt for edit
	public String Linestilt_xp = "//a[@title='Expand Lines']";
	// Select line
	public String SelectLine_xp = "//table/tbody/tr[@_afrrk='0']";
	// Cancel Line
	public String Linecancel_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:1:ap1:at2:_ATp:ctb2']";
	// Save Cancelled Line
	public String SaveLine_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:1:ap1:ct5']";
	// Amount
	public String Lineamount_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:i26::content']";
	// Distribution select
	public String Linedistribution1_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:so13::content']";
	// Distribution Set
	public String Linedistributiondd_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:so13::lovIconId']";
	// Distribution Combination
	public String Linedistributioncomb_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:kf1KBIMG']";
	// Department
	public String Department_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:kf1SPOP_query:value10::content']";
	// 1
	public String Department1_xp = "//tr[@_afrrk='0']";
	// public String Deptdpdn_xp="//span[@class='p_AFDepressed x1tq']";
	public String Deptdpdn_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:kf1SPOP_query:value10::lovIconId']";
	// Account
	public String Account_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:kf1SPOP_query:value20::content']";
	// 1
	public String Account1_xp = "//div[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:kf1SPOP_query:value20::dropdownPopup::dropDownContent::db']/table/tbody/tr/td/span";
	// Account Dropdown
	public String Accountdd_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:kf1SPOP_query:value20::lovIconId']";
	public String Acclist_xp = "//table[@class='x1no']//tbody/tr/td";
	
	//Distribution Set Search
	public String DistributionSet_xp = "//a[text() = 'Search...']";
	//Advanced
	public String DistributionSetAdv_xp = "//button[text() = 'A']";
	//Set
	public String DistributionSet1_xp = "//input[@id = 'pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:so13::_afrLovInternalQueryId:value00::content']";
	//Search
	public String DistributionSetSearch_xp = "//button[text() = 'Search']";
	//Select
	public String DistributionSet2_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:so13_afrLovInternalTableId::db']//table/tbody/tr";
	//Ok Button
	public String DistributionSetOk_xp = "//button[text() = 'OK']";
	

	// Tax Refresh
	public String TaxRefresh_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:cil2']";
	
	//Distribution Combination Click
	public String DistributionCombination_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:kf1CS::content']";

	// Ok
	public String Selectok_xp = "//button[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:kf1SEl']";
	// Line accounting date
	public String Linedate_xp = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:id1::content']";

	// Description
	public String Linedescription_xp = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:i34::content']";
	// Line Requester
	public static String Linerequester_xp = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:ic202::content']";
	// Number
	public String Linenumber_xp = "//span[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:ic21']";
	// Track as Asset
	public String Trackasset_xp = "//label[@for='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at2:_ATp:ta2:0:sb5::content']";
	// Invoice Actions
	public String Invoiceactions_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:me1']";
	//Invoice Actions
	public String Invoiceactions1_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:1:ap1:me1']";
	//CancelInv
	public String CancelInv_xp = "//td[text()='Cancel Invoice']";
	//CancelInv ok
	public String CancelInvOk_xp = "//span[text()='K']";
	//Post
	public String PL_xp = "//td[text()='Post to Ledger']";
	//ViewAccounting
	public String viewAccount_xp = "//button[text()='View Accounting']";
	//ViewAccounting done
	public String viewAccountdone_xp = "//span[text()='o']";
	
	// Manage Installments
	public String Manageinstallments_xp = "//tr[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:cm3']";
	// SaveAndClose
	public String InstallmentsSave_xp = "//button[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:cb27']";
	// Correct Matched invoice Lines
	public String MatchedInvoice_xp = "//select[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:so3::content']";
	// Click Matched invoice Lines
	public String MatchedInvoice1_xp = "//option[@title='Correct Matched Invoices']";
	// Lines Go
	public String LinesGo_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:p14']";
	// Correct
	public String Correct_xp = "//label[@for='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r10:1:at1:_ATp:ta1:0:sb1::content']";
	// Correction Type
	public String CorrectionType_xp = "//select[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r10:1:at1:_ATp:ta1:0:so1::content']";
	// Amount
	public String CorrectionAmount_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r10:1:at1:_ATp:ta1:0:i3::content']";
	// Ok
	public String CorrectionOk_xp = "//button[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:cm7']";

	// Calculate Tax
	public String Calculatetax_xp = "//tr[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:cmi1']";
	// Tax amount
	public String TaxAmount_xp = "//table/tbody/tr/td/span[@class='xmo']";
	// Due amount
	public String TaxAmountDC_xp = "//table/tbody/tr/td/span[@class='xmj'] and contains(text, 'Due')";
	// Validate
	public String Validate_xp = "//tr[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:cm1']";
	// Apply or Unapply prepayments
	public static String Prepayments_xp = "//tr[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:cm2']";
	// Manage Holds
	public String Manageholds_xp = "//tr[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:cm4']";
	// Approval
	public String Approval_xp = "//tr[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:me2']";
	// 1.Initiate
	public String Initiate_xp = "//tr[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:1:MAnt2:1:pm1:r1:0:ap1:cm5']";
	// 2.Withdraw
	public static String Withdraw_xp = "//tr[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:cm9']";
	// 3.Hold
	public static String Hold_xp = "//tr[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:cm10']";
	// 4.Resubmit
	public static String Resubmit_xp = "//tr[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:cm12']";
	// 5.Approve
	public static String Approve_xp = "//tr[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:cmi4']";
	// 6.Reject
	public static String Reject_xp = "//tr[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:cmi8']";
	// 7.Force Approve
	public String ForceApprove_xp = "//tr[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:cm11']";
	// Delete Invoice
	public String Deleteinvoice_xp = "//tr[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:cm15']";
	// Delete Yes
	public String Deleteinvoiceyes_xp = "//button[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:d49::yes']";
	// Save and Create next
	public static String Saveandnext_xp = "//div[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:ct4']";
	// Save
	public String Save_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:ct5']";
	// Save and Close
	public String Saveandclose_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:cb14']";
	// Cancel
	public String Cancel_xp = "//div[@id='pt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:cb33']";
	// post to ledger
	public String PosttoLedger_xp = "//tr[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:cm16']";
	// Pay in Full
	public String PayinFull_xp = "//tr[@id='pt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:cmi2']";
	// Needs revalidation
	public String Needsrevalidation_xp = "//table[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:pg2']";
	// System holds
	public String SystemHolds_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r22:0:ta1:4:cl2']";
	// System Holds Save and close
	public String SystemHoldsSaveandclose_xp = "//button[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:cb9']";
	// Manage Actions
	public String Actions_xp = "//div[@aria-label='Actions']";
	// Cancel invoice
	// public String CancelInvoice_xp =
	// "//tr[@id='pt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:0:pm1:r1:0:ap1:at1:_ATp:cm10']";
	public String CancelInvoice_xp = "//td[@class='xnr'] and contains(text(),'Cancel Invoice')";
	// Cancel Ok
	public String CancelInvoiceOk_xp = "//button[@id='pt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:0:pm1:r1:0:ap1:at1:cb40']";
	// Actions Post to Ledger
	public String ActionsPosttoLed_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at1:_ATp:ATm']";
	// View Accounting
	public String ViewAccounting_xp = "//button[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:cb42']";
	// View Accounting Done
	public String ViewAccountingDone_xp = "//button[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:cb99']";

	// Manage Invoice
	public String Manage_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:_FOTRaT:0:RAtl4']";
	// Invoice Number
	public String Invoiceno_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:q1:value10::content']";
	// Invoice Date
	public String Invoicedate_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:q1:value30::content']";
	// Supplier or Party
	public String Invoicesupplier_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:q1:value40::content']";
	// Supplier Number
	public String Invsupplierno_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:q1:value50::content']";
	// Invoice group
	public String Invgroup_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:q1:value80::content']";
	// Search
	public String Search_xp = "//button[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:q1::search']";

	// select search
	public String InvoiceSearch_xp = "//table[@class='x1no x1oc']/tbody/tr/td";
	// Edit Mode
	public String InvoiceEdit_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at1:_ATp:ct1']";

	// Tools
	public String Tools_xp = "//div[@title='Tools']";
	// Reports and Analytics
	public String Reports_xp = "//a[@id='itemNode_tools_reports_and_analytics_3']";
	// Browse Catalog
	public String Browse_xp = "//button[@title='Browse Catalog']";
	// Shared folders
	public String Sharedfolder_xp = "//img[contains(@id,'shared_disclosure')]";
	// Expand
	public String Expand_xp = "//a[@class='CatalogTasksActionListItem']";
	// Custom
	public String Custom_xp = "//img[contains(@id,'shared/Custom_disclosure')]";
	// Financial
	public String Financials_xp = "//img[contains(@id,'shared/Custom/Financials_disclosure')]";
	// Payable
	public String Payables_xp = "//img[contains(@id,'shared/Custom/Financials/Payables_disclosure')]";
	// Reports Expand
	public String ReportsExpand_xp = "//span[@title='Payables']";
	// Data Model
	public String DataModels_xp = "//img[contains(@id,'shared/Custom/Financials/Payables/Data Models_disclosure')]";
	// Data Model Expand
	public String DataModelexpand_xp = "//span[@title='Data Models']";
	// Report Click
	public String ReportClick_xp = "//td/span[text()='CYTK AP Invoice Aging Report by Invoice Date']";
	// Invoice Aging
	public String Aging_xp = "//table[@cellspacing='3']";
	// Open
	public String Open_xp = "//a[@class='CatalogTasksActionListItem']";
	// Report as of date
	public String Reportdate_xp = "//img[@src='/xmlpserver/theme/alta/images/timedate_ena.png']";
	// Date ok
	public String Dateok_xp = "//button[@class='button']";
	// Apply
	public String Apply_xp = "//button[@title='Apply']";

	// Procurement Reports
	public String Procurement_xp = "//img[contains(@id,'shared/Custom/Procurement_disclosure')]";
	// Procurement Expand
	public String Procurementexp_xp = "//span[@title='Procurement']";
	// Report Click Supplier Listing Report
	public String ReportClick1_xp = "//td/span[text()='CYTK Suppliers Listing Report With Approvals']";
	// Invoice Aging
	public String Listing_xp = "//table[@cellspacing='4']";

	// Schedule Process
	public String Scheduleprocess_xp = "//a[@id='itemNode_tools_scheduled_processes_fuse_plus_4']";
	// Schedule New Process
	public String Schedulenewprocess_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:panel:scheduleProcess']";
	// Name
	public String ScheduleName_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:selectOneChoice2::content']";
	// Name DropDown
	public String Scheduledd_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:selectOneChoice2::lovIconId']";
	// Schedule Search
	public String Schedulesearch_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:selectOneChoice2::dropdownPopup::popupsearch']";
	// Name
	public String ScheduleName1_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:selectOneChoice2::_afrLovInternalQueryId:value00::content']";
	// Schedule Search
	public String Schedulesearch1_xp = "//button[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:selectOneChoice2::_afrLovInternalQueryId::search']";
	// Select
	// public String Scheduleselect_xp = "//tr[@class='p_AFSelected p_AFFocused
	// xep']/td[2]/div/table/tbody/tr/td";
	public String Scheduleselect_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:selectOneChoice2_afrLovInternalTableId::db']//table/tbody/tr/td";
	// Ok
	public String ScheduleOk_xp = "//button[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:selectOneChoice2::lovDialogId::ok']";
	// Ok1
	public String ScheduleOk1_xp = "//button[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:snpokbtnid']";
	// Business Unit
	public String Businessunit_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_BusinessUnit::content']";
	// Tax Reporting Entity
	public String Taxreporting_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_RepEntity::content']";
	// Tax Reporting Entity Us Report
	public String Taxreporting1_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_TaxReportingEntity::content']";
	// From Accounting Date
	public String Fromaccounting_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_FromDate::content']";
	// From Accounting Date Us Report
	public String Fromaccounting1_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_FromPaymentDate::content']";
	// To Accounting Date
	public String Toaccounting_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_ToPaymentDate::content']";
	// Schedule Aging Period
	public String ScheduleAging_xp = "//select[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_ATTRIBUTE13_ATTRIBUTE13::content']";
	// Schedule Aging Period select
	public String ScheduleAging1_xp = "//select[@title='Monthly Aging Periods']";
	// Schedule Submit
	public String Schedulesubmit_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:r1:0:r1:requestBtns:submitButton']";
	// Process ok
	public String Scheduleprocess1_xp = "//button[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:r1:0:r1:requestBtns:confirmationPopup:confirmSubmitDialog::ok']";
	// Process Refresh
	public String Scheduleprocess2_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:panel:processRefreshId']";
	// Schedule Process Succeeded
	public String Scheduleprocess3_xp = "//a[@title='Succeeded']";
	// Job Status
	public String JobStatus_xp = "//button[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:stsmsginfopwid::ok']";
	// Schedule Process Republish
	public String Scheduleprocess4_xp = "//button[text()='Republish']";
	
	
	//Schedule Process iFrame1
	public String Scheduleprocess4iframe1_xp = "//iframe[@id='afr::PushIframe']";
	
	//Schedule Process Republish iframe
	public String Scheduleprocess4iframe_xp = "//iframe[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:r61:0:if1']";
	//Click Republish
	public String TraverseRepublish_xp = "//iframe/html/body/div/div/div/div/div/div/div/button[@type='button']";
	
	public String ScheduleprocessRepublish_xp = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/span[5]/button[1]";
	
	
	
	// Schedule Actions
	public String Scheduleprocess5_xp = "//img[@title='Actions']";
	// Schedule Actions Export
	public String Scheduleprocess6_xp = "//div[@id='_xdoFMenu0']";
	// Schedule excel download
	public String Scheduleprocess7_xp = "//li[@fmid='105']";
	// Schedule From Date
	public String Schedulefromdate_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_FromDate::content']";
	// Schedule To Date
	public String Scheduletodate_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:r1:0:r1:basicReqBody:paramDynForm_ToDate::content']";

	
	//Parameters
	public String ClickParameters_xp = "//a[@title='Expand Parameters']";
	//Output
	public String ClickOutput_xp = "//h1[contains(text(),'Output')]";
		
	//XML Data
	public String ClickXMLdata_xp = "//label[contains(text(),'XML Data')]";
	//Download Icon
	public String ClickDownloadIcon_xp = "//span[@class='downloadIconEnabled']";
	
	
	
	// Invoice from Spreadsheet
	public String Spreadsheet_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:_FOTRaT:0:RAtl2']";

	// Payments Task Bar
	public String PaymentTaskbar_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:_FOTsdi__PaymentLanding_itemNode__FndTasksList::ti']";
	// Payments
	public String CreatePayment_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:_FOTRaT:0:RAtl4']";
	// Business Unit
	public String BusinessUnit_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:1:AP1:OrgUiId::content']";
	// Supplier or Party
	public String SupplierorParty_xp = "//span[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:1:AP1:payeeNameId::cntnr']";
	// Disbursement Bank Account
	public String DisbursementBank_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:1:AP1:bankAccountNameId::content']";
	// Payment Method
	public String PaymentMethod_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:_FOTRaT:0:RAtl4']";
	// Payment Method DD
	public String PaymentMethodDD_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:1:AP1:paymentMethodNameUiId::lovIconId']";
	// Payment Process Profile
	public String PaymentProcess_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:1:AP1:paymentProfileUICompId::content']";
	// Remit to account
	public String RemitAccount_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:1:AP1:remitToBankAccountNumberId::content']";
    //Invoices to Pay
	public String SelectandAdd_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:1:AP1:AT1:_ATp:commandToolbarButton1']";
	//Invoice Number
	public String Invoicenumber_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:1:coVOId:value00::content']";
	//Search
	public String SearchInvoice_xp = "//button[@id='pt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:0:coVOId::search']";
	//Invoice Search
	public String InvSearch_xp = "//table/tbody/tr[@_afrrk='11']";
	//Invoice Ok
	public String InvoiceOk_xp = "//button[@id='pt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:0:dialog1::ok']";
	//Save and close
	public String PaymentSave_xp = "//button[@id='pt1:_FOr1:0:_FOSritemNode_payables_payables_payments:0:MAnt2:0:AP1:cb5']";
	
	
	
	//Pay in Full
	public String PayFull_xp = "//td[text()='Pay in Full']";
	//PPR
	public String PPR_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r9:1:paymentProfileNameId::content']";
	//PPR DD
	public String PPRDD_xp = "//span[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r9:1:paymentProfileNameId::cntnrSpan']";
	//Submit
	public String PPRSubmit_xp = "//button[text()='Sub']";
	//Submit Ok
	public String PPRSubmitOk_xp = "//button[text()='OK']";
	
	//PPR Search
	public String PPRSearch_xp = "//a[text()='Search...']";
	//Name
	public String PPRname_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r9:1:paymentProfileNameId::_afrLovInternalQueryId:value00::content']";
	//Name Search
	public String PPRnameSearch_xp = "//button[text()='Search']";
	//Name Select
	public String PPRnameSelect_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r9:1:paymentProfileNameId_afrLovInternalTableId::db']//table/tbody/tr";
	//Name Ok
	public String PPRNameok_xp = "//button[text()='OK']";
	
	
	// Manage Payment
	public String ManagePayment_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:_FOTRaT:0:RAtl5']";
	// Manage Supplier
	public String ManageSupplier_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:1:AP1:q1:value00::content']";
	// Payment Date
	public String ManagePaymentDate_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:1:AP1:q1:value10::content']";
	// Payment Number
	public String ManagePaymentNumber_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:1:AP1:q1:value20::content']";
	// Disbursement Bank Account
	public String ManageDisbursement_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:1:AP1:q1:value30::content']";
	// Payment Type
	public String ManagePaymentType_xp = "//select[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:2:AP1:q1:value40::content']";
	// Payment Process Request
	public String ManagePaymentProcess_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:1:AP1:q1:value50::content']";
	// Search payment
	public String SearchPayment_xp = "//button[text()='Search']";

	// Submit Payment Process Request
	public String SubmitPPR_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:_FOTRaT:0:RAtl1']";
	// Payment Name
	public String PaymentName_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:3:ap1:inputText1::content']";
	// Template
	public String Template_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:3:ap1:templateNameId::content']";
	// Template Drop Down
	public String Templatedd_xp = "//span[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:3:ap1:templateNameId::cntnrSpan']";
	// Pay Through Date
	public String Paythroughdate_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:3:ap1:inputDate2::content']";
	// Payment Method
	public String Paymentmethod_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:1:ap1:paymentMethodNameId::content']";
	// Supplier
	public String SupplierPPR_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:1:ap1:partyNameId::content']";
	// Pay From Date
	public String Payfromdate_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:1:ap1:inputDate4::content']";

	// Payment Processing Options
	// Payment Date
	public String PaymentDate_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_payments:0:MAnt2:1:ap1:inputDate1::content']";

	//InvoiceSelect
	public String InvoiceSelect_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:at1:_ATp:ta1:0:cl1']";
	//Payments
	public String PaymentsCol_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r7:1:sm3::disAcr']";
	//Select Payment Line
	public String PaymentLine_xp = "//table/tbody/tr[@_afrrk='0']";
	//Payment number
	public String Paymentnumber_xp = "//table/tbody/tr/td[@class='xeq']";
	//Select Payment number
	public String PaymentNumSelect_xp = "//table/tbody/tr[@_afrrk='0']";
	//Payment Actions
	public String PaymentNumActions_xp = "//div[@class='xmi']";
	//Void Payment
	public String PaymentVoid_xp = "//td[text()='Void']";
	//Void Submit
	public String SubmitVoid_xp = "//button[text()='Sub']";
	//Void Done
	public String VoidDone_xp = "//span[text()='D']";
	
	
	//Manage Supplier
	public String ManageSupp_xp = "//a[text()='Manage Suppliers']";
	//Keywords
	public String Keywords_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_procurement_suppliers:0:MAt2:0:pt1:Suppl1:0:AP1:q1:value00::content']";
	//Search Keywords
	public String SearchKeywords_xp = "//button[text()='Search']";
	//Select Supplier
	public String SelectSupplier_xp = "//table/tbody/tr/td/span[@class='x2rx']";
	//Select Supplier Num
	public String SelectSupplier1_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_procurement_suppliers:0:MAt2:0:pt1:Suppl1:0:AP1:AT1:_ATp:Table:0:cl1']";
	//Edit
	public String SupplierEdit_xp = "//span[text()='Edit']";
	
	
	//Procurement Icon
	public String Procurement_id = "id=groupNode_procurement_9";
	//Suppliers Icon
	public String SuppliersIcon_xp = "//div[@title='Suppliers']";
	//Supplier Task
	public String SuppliersTaskbar_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_procurement_suppliers:0:_FOTsdiPrcPozSuppliersDashboard__FndTasksList::ti']";
	//Create Supplier
	public String CreateSupplier_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_procurement_suppliers:0:_FOTRaT:0:RAtl3']";
	//Supplier Name
	public String SupplierName_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_procurement_suppliers:0:_FOTRaT:0:dynam1:0:it1::content']";
	//Tax Organization Type
	public String TaxOrganization_xp = "//select[@id='pt1:_FOr1:1:_FOSritemNode_procurement_suppliers:0:_FOTRaT:0:dynam1:0:soc1::content']";
	//Corporation
	public String TaxOrganizationType_xp = "//option[@title='Corporation']";
	//Create
	public String Create_xp = "//button[text()='Create']";
	//Supplier Type
	public String SupplierType_xp = "//select[@id='pt1:_FOr1:1:_FOSritemNode_procurement_suppliers:0:MAt2:0:ap1:selectOneChoice4::content']";
	//Supplier Type 1
	public String SupplierType1_xp = "//option[@title='Supplier']";
	//Income Tax Tab
	public String IncomeTax_xp = "//a[text()='Income Tax']";
	//Tax Payer Country
	public String TaxPayerCountrydd_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_procurement_suppliers:0:MAt3:0:ap1:territoryShortNameId::lovIconId']";
	//Tax Payer Country Search
	public String TaxPayerCountrySearch_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_procurement_suppliers:0:MAt3:0:ap1:territoryShortNameId::dropdownPopup::popupsearch']";
	//Tax Payer Country Advanced
	public String TaxPayerCountryAdvanced_xp = "//button[text()='A']";
	//Name
	public String TaxPayerCountryName_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_procurement_suppliers:0:MAt3:0:ap1:territoryShortNameId::_afrLovInternalQueryId:value00::content']";
	//Search
	public String TaxPayerSearch_xp = "//button[text()='Search']";
	//Select Tax Payer Country
	public String TaxPayerSelect_xp = "//table/tbody/tr/td/span[text()='United States']";
	//Ok
	public String TaxPayerSearchOk_xp = "//button[text()='OK']";
	
	
	
	//Tax Payer Id
	public String TaxPayerId_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_procurement_suppliers:0:MAt3:0:ap1:text32a::content']";
	//Federal Reportable
	public String FederalReportable_xp = "//label[@for='pt1:_FOr1:1:_FOSritemNode_procurement_suppliers:0:MAt3:0:ap1:FdrlReportableFlagId::content']";
	//Federal Income Tax Type Drop Down
	public String FederalIncomeTaxDD_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_procurement_suppliers:0:MAt3:0:ap1:type1099Id::content']";
	//Federal Income Tax Type
	public String FederalSearch_xp = "//a[@id='pt1:_FOr1:1:_FOSritemNode_procurement_suppliers:0:MAt4:0:ap1:type1099Id::dropdownPopup::popupsearch']";
	//Federal Advanced
	public String FederalAdvanced_xp = "//button[@id='pt1:_FOr1:1:_FOSritemNode_procurement_suppliers:0:MAt4:0:ap1:type1099Id::_afrLovInternalQueryId::mode']";
	//Income Tax Type
	public String FederalIncomeTax_xp = "//input[@id='pt1:_FOr1:1:_FOSritemNode_procurement_suppliers:0:MAt4:0:ap1:type1099Id::_afrLovInternalQueryId:value00::content']";
	//Income Tax Search
	public String FederalIncomeTaxSearch_xp = "//button[@id='pt1:_FOr1:1:_FOSritemNode_procurement_suppliers:0:MAt4:0:ap1:type1099Id::_afrLovInternalQueryId::search']";
	//Select Income Tax Type
	public String IncomeTaxSearch_xp = "//table/tbody/tr[@_afrrk='0']";
	//Ok
	public String IncomeTaxOk_xp = "//button[text()='OK']";
	//Payments
	public String Payments1_xp = "//a[text()='Payments']";
	//Payment Methoda
	public String PaymentsMethods_xp = "//a[text()='Payment Methods']";
	//Select Payment Type
	public String PaymentType_xp = "//table/tbody/tr/td[@class='xeq']";
	//Payment Electronic
	public String PaymentElectronic_xp = "//span[@id='pt1:_FOr1:0:_FOSritemNode_procurement_suppliers:0:MAt3:0:ap1:Payee3:0:ibyAT1:_ATp:ibypanelGroupLayout2']";
	//Select Line
	public String SelectPaymentLine_xp = "//div[@id='pt1:_FOr1:1:_FOSritemNode_procurement_suppliers:0:MAt3:0:ap1:Payee3:0:ibyAT1:_ATp:ATtb1::eoi']";
	//Select Enable
	public String SelectEnable_xp = "//img[@id='pt1:_FOr1:1:_FOSritemNode_procurement_suppliers:0:MAt3:0:ap1:Payee3:0:ibyAT1:_ATp:ibycommandImageLink1::icon']";
	//Payments
	public String BankAccounts_xp = "//a[text()='Bank Accounts']";
	//Add BankAccount
	public String AddBankAccount_xp = "//div[@id='pt1:_FOr1:0:_FOSritemNode_procurement_suppliers:0:MAt9:0:ap1:r9:1:AT1:_ATp:create']";
	//Country
	public String Country_xp = "//input[@id='pt1:_FOr1:0:_FOSritemNode_procurement_suppliers:0:MAt9:0:ap1:r9:1:territoryShortNameId::content']";
	
	
	
	// logout
	public String Logout_xp = "//td[@id='pt1:_UISgc5']";
	public String Signout_xp = "//a[@id='pt1:_UISlg1']";
	public String Confirm_xp = "//button[@id='Confirm']";

}
