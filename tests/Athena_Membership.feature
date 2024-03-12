@MEMBERSHIP
Feature: Membership Test cases

  @AT-T001
    @TestCaseId:AT-T001:1:15 @AT-T002:25-30
    @PRIORITY:1
    @SMOKE
    @REGRESSION
  Scenario Outline: Create new Membership
  Step: Login-Page: I login to Athena as "User Type" with following details "${env.url}", "<username>" and "<password>"
#  Result: Home-Page: I verify I am in Athena homepage
#  Step: Menu: I navigate to "Membership Management" > "Memberships"
#  Result: Membership-Page: I verify I am in Athena Membership page


Examples: {'dataFile':'resources/data/athena_membership_data.csv', 'filter':'_ID==\"AT-T001\" and _ENV==\"${env.code}\" and _STATUS==\"yes\"'}


  @AT-T002
    @TestCaseId:AT-T002
  Scenario Outline: D365 Global Regression Test
  Step: Login-Page: I login to Athena as "User Type" with following details "${env.url}", "<username>" and "<password>"
  Step: D365CRM: Wait-And-Verify-Page-Header Text:"Dashboard Notification" Page:"Home"
  Step: D365CRM: Table-Select By-Instance:"3" Page:"Home"
  Step: D365CRM: Wait-And-Verify-Page-Header Text:"NOI Expiring in 3 Months" Page:"Notice of intents"
  Step: D365CRM: Click-Menu-Button Text:"Go back"
  Step: D365CRM: Wait-And-Verify-Page-Header Text:"Dashboard Notification" Page:"Home"
  Step: D365CRM: Click-Link Text:"Home" Page:"Notice of intents"
  Step: D365CRM: Wait-And-Verify-Page-Header Text:"Dashboard Notification" Page:"Home"
#  Step: D365CRM: Click-Menu-Button Text:"Go back"
#
#  Step: D365CRM: Table-Select By-Instance:"5"
#  Step: D365CRM: Verify-Input-Value Text:"+61734384934983948" Field:"Office Telephone" Page:"Memberships" - Done
#  Step: D365CRM: Verify-Date-Value Text:"+61734384934983948" Field:"Office Telephone" Page:"Memberships" - Done
#  Step: D365CRM: Verify-Lookup-Value Text:"+61734384934983948" Field:"Office Telephone" Page:"Memberships" - Done
#  Step: D365CRM: Verify-Error-Text Text:"+61734384934983948" Field:"Office Telephone" Page:"Memberships"
#  Step: D365CRM: Click-Tab-Dropdown Text:"Membership Details"
##  Step: D365CRM: Verify-Error-Text Text:"+61734384934983948" Field:"Office Telephone" Page:"Memberships"

#  Step: I wait for "2" seconds
  Step: D365CRM: Click-Main-Menu-Link Text:"Membership Management" Then-Sub-Menu-Link Text:"Membership Applications"
  Step: D365CRM: Wait-And-Verify-Page-Header Text:"Active Membership Applications" Page:"Membership Applications"
  Step: D365CRM: Get-Table-Cell-Value Row:"3" Column:"1" To-Variable:"var.test.1" Page:"Membership Applications"
  Step: D365CRM: Get-Table-Cell-Value Row:"3" Column:"2" To-Variable:"var.test.2" Page:"Membership Applications"
  Step: I comment "===>>>> ${var.test.1}"
  Step: I comment "===>>>> ${var.test.2}"
  Step: D365CRM: Click-Menu-Button Text:"Create a new Membership Application record."
  Step: D365CRM: Wait-And-Verify-Page-Header Text:"New Membership Application" Page:"Membership Applications"
  Step: D365CRM: Click-Tab Text:"Payment Details" Page:"Membership Applications"
  Step: D365CRM: Click-Tab Text:"Administration" Page:"Membership Applications"
#  Step: D365CRM: Verify-Table-Header Text:"Termination Reason (D)" Column:"12" Page:"Memberships"
#  Step: D365CRM: Verify-Table-Header-All Text:"Full Name,Membership Status" Page:"Memberships"
#  Step: D365CRM: Click-Main-System-View Text:"Union Memberships" Then-Sub-System-View Text:"Active Members" Page:"Memberships"
#  Step: D365CRM: Verify-Table-Header-By-Edit-Column Text:"Full Name" Column:"1" Page:"Memberships"
#  Step: D365CRM: Verify-Table-Header-All-By-Edit-Column Text:"Full Name,Membership Status,Membership Type" Page:"Memberships"
#  Step: D365CRM: Table-Input-Filter Text:"AFFAR MEDIA" Page:"Memberships"
#  Step: D365CRM: Table-Input-Filter Text:"AFFAR MEDIA" By-Instance:"1" Page:"Memberships"
#  Step: D365CRM: Click-Link Text:"AFFAR MEDIA"
#  Step: D365CRM: Wait-And-Verify-Page-Header Text:"AFFAR MEDIA" Page:"Memberships"
#  Step: D365CRM: Verify-Header-Control-List Text:"S9562553C" Page:"Memberships"
#  Step: D365CRM: Click-Tab Text:"Membership Details"
#  Step: D365CRM: Verify-Input-Value Text:"AFFAR MEDIA" Field:"Full Name" Page:"Memberships"
#  Step: D365CRM: Verify-Input-Date Text:"3/1/1995" Field:"Date of Birth (DD/MM/YYYY)" Page:"Memberships"
#  Step: D365CRM: Verify-Input-Lookup Text:"GB" Field:"Membership Type" Page:"Memberships"
#  Step: D365CRM: Verify-Select Text:"Female" Field:"Gender" Page:"Memberships"
#  Step: I wait for "10" seconds
#  Step: D365CRM: Click-Menu-Button Text:"Go back"
#  Step: D365CRM: Click-Menu-Button Text:"Create a new Membership record"
  Step: D365CRM: Input Text:"Renish" Field:"Given Name" Page:"Memberships"
#  Step: D365CRM: Scroll Value:"1000" From-Visible Field:"Given Name" Page:"Memberships"
#  Step: D365CRM: Input Text:"+61734384934983948" Field:"Office Telephone" Page:"Memberships"
#  Step: D365CRM: Input-Date Text:"12/20/2023" Field:"Member Start Date" Page:"Memberships"
#  Step: D365CRM: Input Text:"Kozhithottathil" Field:"Surname" Page:"Memberships"
#  Step: D365CRM: Input-Date Text:"10/20/2023" Field:"Member Start Date" Page:"Memberships"
#  Step: D365CRM: Input Text:"Renish Kozhithottathil" Field:"Full Name" Page:"Memberships"
#  Step: D365CRM: Input-Lookup Text:"Freelancer" Field:"Company, Lookup" Page:"Membership"
##  Step: D365CRM: Input-Lookup Text:"Freelancer" Field:"Company" Page:"Memberships" Wait-In-Secs:"5"
#  Step: D365CRM: Input Text:"K" Field:"Surname" Page:"Membership"
#  Step: D365CRM: Input-Lookup Text:"Test" By-Clearing-Value:"Freelancer" Field:"Company" Page:"Memberships"
#  Step: D365CRM: Select Text:"Union Membership" Field:"Membership Category" Page:"Memberships"
#  Step: D365CRM: Select Text:"Retired" Field:"Employment Type" Page:"Memberships"
#  Step: D365CRM: Select Index:"2" Field:"Relationship to Main Honorary Member" Page:"Memberships"
#  Step: D365CRM: Select Text:"Female" Field:"Gender" Page:"Memberships"
#  Step: D365CRM: Select Index:"2" Field:"Highest Education Level" Page:"Memberships"
#  Step: D365CRM: Select Index:"1" Field:"Marital Status" Page:"Memberships"
#  Step: D365CRM: Select Index:"3" Field:"Race" Page:"Memberships"
#  Step: D365CRM: Click-Tab Text:"Social Membership Details"
#  Step: D365CRM: Click-Tab Text:"Membership Charge Items"
#  Step: D365CRM: Click-Main-Menu-Button Text:"Create a new record" Then-Sub-Menu-Button Text:"Company"
  Step: I wait for "5" seconds
#  Step: D365: Input:{0} field:{1} page:{2}

    Examples: {'dataFile':'resources/data/athena_membership_data.csv', 'filter':'_ID==\"AT-T002\" and _STATUS==\"yes\"'}


  @AT-T003
    @TestCaseId:AT-T003
  Scenario Outline: Table Clicks, Checking Disable fields
  Step: I store value "Ellis - B8688 - 2912230928" into variable "var.record"
  Step: I store value "11/21/2023 11:29 AM" into variable "var.record.2"
  Step: Login-Page: I login to Athena as "User Type" with following details "${env.url}", "<username>" and "<password>"
  Step: D365CRM-Wait-And-Verify-Page-Header Text:"Dashboard Notification" Page:"Home"
#  Step: D365CRM: Switch-App From:"NTUC ATHENA" To:"Batch Jobs Administration"
#  Step: D365CRM: Wait-And-Verify-Page-Header Text:"Active Master Batch Jobs" Page:"Batch Jobs Administration - Home"
#  Step: D365CRM: Switch-App From:"Batch Jobs Administration" To:"NTUC ATHENA"
#  Step: D365CRM: Wait-And-Verify-Page-Header Text:"Dashboard Notification" Page:"NTUC ATHENA - Home"
#  Step: I wait for "5" seconds
#  Step: D365CRM: Table-Input-Filter Text:"123::2" Page:"Membership Applications"
#  Step: D365CRM: Table-Input-Filter Text:"567" Page:"Membership Applications"
#  Step: I wait for "10" seconds
#  Step: D365CRM: Table-Select By-Instance:"3" Page:"Home"
#  Step: I wait for "10" seconds
  Step: D365CRM: Click-Left-Menu Text:"Membership Management" Then-Sub-Menu Text:"Membership Applications"
  Step: D365CRM: Wait-And-Verify-Page-Header Text:"Active Membership Applications" Page:"Membership Applications"
  Step: D365CRM: Assign-Table-Cell-Value-To-Variable Row:"1" Column:"11" To-Variable:"var_test_1" Page:"Membership Applications"
  Step: I comment "===var.test.1====> ${var_test_1}"
  Step: D365CRM: Table-Input-Filter Text:"${var.record}" Page:"Membership Applications"
  Step: D365CRM: Store-Table-Row-Count To-Variable:"var.test.2" Page:"Membership Applications"
  Step: I comment "===var.test.2====> ${var.test.2}"
  Step: D365CRM: Verify-Table-Cell-Value Text:"NCS" Row:"1" Column:"7" Page:"Membership Applications"
  Step: D365CRM: Verify-Table-Header-All Text:"Full Name (as per NRIC),Application Status,Record Created On,Member No." Page:"Membership Applications"
  Step: D365CRM: Verify-Table-Header Text:"Created On" Column:"11" Page:"Membership Applications"
  Step: D365CRM: Table-Click-Header Text:"Created On" Column:"11" Then-Click-Dropdown-Button Text:"Sort newer to older" Page:"Membership Applications"
  Step: D365CRM: Double-Click-Table-Cell Row:"1" Column:"1" Page:"Membership Applications"
  Step: D365CRM: Wait-And-Verify-Page-Header Text:"${var.record}" Page:"Membership Applications"
#  Step: D365CRM: Store-Header-Control-List-Column-Value Column:"2" To-Variable:"var.test.3" Page:"Membership Applications"
  Step: D365CRM: Store-Header-Control-List-Column-Value Column:"2" To-Variable:"var.test.3" Page:"Membership Applications"
  Step: I comment "===var.test.3====> ${var.test.3}"
  Step: D365CRM: Verify-field-locked Field:"Recruitment Channel" Page:"Membership Applications"
  Step: D365CRM: Verify-Input-Value Text:"Ellis - 0711232047" Field:"Name (to be printed on card)" Page:"Membership Applications::Quick-Create"
  Step: D365CRM: Click-Tab Text:"Cases/Requests" Page:"Membership Applications"

#  Step: D365CRM: Verify-Input-Date Text:"1/1/1968" Field:"Date of Birth" Page:"Membership Applications"
#  Step: D365CRM: Verify-Input-Lookup Text:"EMPLOYED - MANAGER" Field:"Occupation Group::1" Page:"Membership Applications"
#  Step: D365CRM: Verify-Select Text:"NTUC" Field:"Recruitment Channel" Page:"Membership Applications"

  #  Step: D365CRM: Verify-Table-Column-Sort Header-Text:"Full Name (as per NRIC)" Header-Column:"1" Then-Check-Sort-Dropdown-Button Text:"Sort A to Z" Page:"Membership Applications"
#  Step: D365CRM: Click-Main-System-View Text:"Active Membership Applications" Then-Sub-System-View Text:"Termination Report" Page:"Membership Applications"
#  Step: D365CRM: Wait-And-Verify-Page-Header Text:"Termination Report" Page:"Membership Applications"

#  Step: D365CRM: Table-Input-Filter Text:"${var.record}" Page:"Membership Applications"
#  Step: D365CRM: Verify-Table-Cell-Value Text:"${var.record.2}" Row:"1" Column:"11" Page:"Recruiters"
#  Step: D365CRM: Double-Click-Table-Cell Row:"1" Column:"11" Page:"Membership Applications"
#  Step: D365CRM: Wait-And-Verify-Page-Header Text:"${var.record}" Page:"Membership Applications"
#  Step: D365CRM: Verify-Input-Disabled Field:"Full Name (as per NRIC)" Page:"Membership Applications"
#  Step: D365CRM: Verify-Input-Value Text:"${var.record}" Field:"Full Name (as per NRIC)" Page:"Membership Applications"
#  Step: D365CRM: Verify-Input-Date-Disabled Field:"Start Date(DD/MM/YYYY)" Page:"Recruiters"
#  Step: D365CRM: Verify-Select-Disabled Field:"Recruiter Type" Page:"Recruiters"
  Step: I wait for "5" seconds

    Examples: {'dataFile':'resources/data/athena_membership_data.csv', 'filter':'_ID==\"AT-T002\" and _STATUS==\"yes\"'}


  @AT-T004
    @TestCaseId:AT-T004
  Scenario Outline: D365 Table Test
    Step: Login-Page: I login to Athena as "User Type" with following details "${env.url}", "<username>" and "<password>"
    Step: D365CRM: Wait-And-Verify-Page-Header Text:"Dashboard Notification" Page:"Home"
    Step: D365CRM: Click-Left-Menu Text:"Membership Management" Then-Sub-Menu Text:"Membership Applications"
    Step: D365CRM: Wait-And-Verify-Page-Header Text:"Active Membership Applications" Page:"Membership Applications"
    Step: D365CRM: Table-Edit-Filter-Delete-All-And-Input-New filters:"['Allow ECard','Equals','No,Yes'],['Year','','1990']" Page:"Membership Applications"
    Step: D365CRM: Table-Edit-Filter-Reset-To-Default Page:"Membership Applications"
    Step: D365CRM: Verify-Table-Cell-Value-Is Text:"11/21/2023 11:29 AM" Row:"1" Column:"11" Page:"Membership Applications"
    Step: I wait for "5" seconds
    Examples: {'dataFile':'resources/data/athena_membership_data.csv', 'filter':'_ID==\"AT-T002\" and _STATUS==\"yes\"'}


  @AT-T005
    @TestCaseId:AT-T005
  Scenario Outline: D365 Global Regression Test - New
  Step: Login-Page: I login to Athena as "User Type" with following details "${env.url}", "<username>" and "<password>"
  Step: D365CRM: Wait-And-Verify-Page-Header Text:"Dashboard Notification" Page:"Home"
  Step: D365CRM: Click-Left-Menu Text:"Membership Management" Then-Sub-Menu Text:"Membership Applications"
  Step: D365CRM: Wait-And-Verify-Page-Header Text:"Active Membership Applications" Page:"Membership Applications"
#  Step: D365CRM: Click-Main-Menu-Button Text:"Action More Commands. Action" Then-Sub-Menu-Button Text:"Transfer" Page:"Membership Applications"
  Step: D365CRM: Click-Top-Menu-Button Text:"Create a new Membership Application record." Page:"Membership Applications"
  Step: D365CRM: Input Text:"Test Name" Field:"[Member Details] Full Name (as per NRIC)" Page:"Membership Applications"
  Step: D365CRM: Input-Lookup Text:"AUDIT HISTORY" Field:"[Occupation Details] Company" Page:"Membership Applications"
  Step: D365CRM: Input-Date Text:"01/03/2000" Field:"[Member Details] Date of Birth" Page:"Membership Applications"
#  Step: D365CRM: Input-Lookup Text:"DIGNITY" By-Clearing-Value:"AUDIT HISTORY" Field:"Company" Page:"Membership Applications"
  Step: D365CRM: Verify-Header-Control-List Text:"Hardcopy" Page:"Membership Applications"
  Step: D365CRM: Click-Tab Text:"Membership Details" Page:"Membership Applications"

  Step: I wait for "5" seconds
    Examples: {'dataFile':'resources/data/athena_membership_data.csv', 'filter':'_ID==\"AT-T002\" and _STATUS==\"yes\"'}




  @AT-T006
    @TestCaseId:AT-T006
  Scenario Outline: Memberships - Cases and Requests
    Step: Login-Page: I login to Athena as "User Type" with following details "${env.url}", "<username>" and "<password>"
    Result: D365CRM: Wait-And-Verify-Page-Header Text:"Dashboard Notification" Page:"Home"
    Step: D365CRM: Click-Left-Menu Text:"Membership Management" Then-Sub-Menu Text:"Memberships"
    Result: D365CRM: Wait-And-Verify-Page-Header Text:"Union Memberships" Page:"Memberships"
    Step: D365CRM: Click-Main-System-View Text:"Union Memberships" Then-Sub-System-View Text:"All Memberships" Page:"Memberships"
    Result: D365CRM: Wait-And-Verify-Page-Header Text:"All Memberships" Page:"Memberships"
    Step: D365CRM: Table-Edit-Filter-Delete-All-And-Input-New filters:"['Membership Status','Equals','ACTIVE,NEW']" Page:"Memberships"
    Result: D365CRM: Wait-And-Verify-Page-Header Text:"All Memberships" Page:"Memberships"
    Step: D365CRM: Assign-Table-Cell-Value-To-Variable Row:"1" Column:"1" To-Variable:"var.member.name" Page:"Memberships"
    And: D365CRM: Double-Click-Table-Cell Row:"1" Column:"1" Page:"Memberships"
    Result: D365CRM: Wait-And-Verify-Page-Header Text:"${var.member.name}" Page:"Memberships"
    Step: D365CRM: Store-Header-Title-In-Form-Page To-Variable:"var.header.title" Page:"Memberships"
    Result: I Comment "${var.header.title}"
    Step: D365CRM: Store-Header-Control-List-Column-Value Column:"1" To-Variable:"var.headercontrol.ExchangeId" Page:"Memberships"
    Result: I Comment "${var.headercontrol.ExchangeId}"
    Step: D365CRM: Click-Tab Text:"Cases/Requests" Page:"Memberships"
    And: D365CRM: Click-Top-Menu-Button Text:"Add New Cases/Requests" Page:"Memberships"
    Result: D365CRM: Wait-And-Verify-Page-Header Text:"New Cases/Requests" Page:"Memberships"
#  Step: I wait for "10" seconds

    Examples: {'dataFile':'resources/data/athena_membership_data.csv', 'filter':'_ID==\"AT-T006\" and _STATUS==\"yes\"'}




    Step: D365CRM: Input Text:"Test Name" Field:"Company Code" Page:"Membership Applications::Quick Create"


    Step: D365CRM: Click-Button Text:"Proceed" Page:"Membership Applications::Dialog Window"