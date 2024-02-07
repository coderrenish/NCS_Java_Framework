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
  Step: D365Global: Wait-And-Verify-Page-Header Text:"Dashboard Notification" Page:"Home"
  Step: D365Global: Table-Select By-Instance:"3" Page:"Home"
  Step: D365Global: Wait-And-Verify-Page-Header Text:"NOI Expiring in 3 Months" Page:"Notice of intents"
  Step: D365Global: Click-Menu-Button Text:"Go back"
  Step: D365Global: Wait-And-Verify-Page-Header Text:"Dashboard Notification" Page:"Home"
  Step: D365Global: Click-Link Text:"Home" Page:"Notice of intents"
  Step: D365Global: Wait-And-Verify-Page-Header Text:"Dashboard Notification" Page:"Home"
#  Step: D365Global: Click-Menu-Button Text:"Go back"
#
#  Step: D365Global: Table-Select By-Instance:"5"
#  Step: D365Global: Verify-Input-Value Text:"+61734384934983948" Field:"Office Telephone" Page:"Memberships" - Done
#  Step: D365Global: Verify-Date-Value Text:"+61734384934983948" Field:"Office Telephone" Page:"Memberships" - Done
#  Step: D365Global: Verify-Lookup-Value Text:"+61734384934983948" Field:"Office Telephone" Page:"Memberships" - Done
#  Step: D365Global: Verify-Error-Text Text:"+61734384934983948" Field:"Office Telephone" Page:"Memberships"
#  Step: D365Global: Click-Tab-Dropdown Text:"Membership Details"
##  Step: D365Global: Verify-Error-Text Text:"+61734384934983948" Field:"Office Telephone" Page:"Memberships"

#  Step: I wait for "2" seconds
  Step: D365Global: Click-Main-Menu-Link Text:"Membership Management" Then-Sub-Menu-Link Text:"Membership Applications"
  Step: D365Global: Wait-And-Verify-Page-Header Text:"Active Membership Applications" Page:"Membership Applications"
  Step: D365Global: Get-Table-Cell-Value Row:"3" Column:"1" To-Variable:"var.test.1" Page:"Membership Applications"
  Step: D365Global: Get-Table-Cell-Value Row:"3" Column:"2" To-Variable:"var.test.2" Page:"Membership Applications"
  Step: I comment "===>>>> ${var.test.1}"
  Step: I comment "===>>>> ${var.test.2}"
  Step: D365Global: Click-Menu-Button Text:"Create a new Membership Application record."
  Step: D365Global: Wait-And-Verify-Page-Header Text:"New Membership Application" Page:"Membership Applications"
  Step: D365Global: Click-Tab Text:"Payment Details" Page:"Membership Applications"
  Step: D365Global: Click-Tab Text:"Administration" Page:"Membership Applications"
#  Step: D365Global: Verify-Table-Header Text:"Termination Reason (D)" Column:"12" Page:"Memberships"
#  Step: D365Global: Verify-Table-Header-All Text:"Full Name,Membership Status" Page:"Memberships"
#  Step: D365Global: Click-Main-System-View Text:"Union Memberships" Then-Sub-System-View Text:"Active Members" Page:"Memberships"
#  Step: D365Global: Verify-Table-Header-By-Edit-Column Text:"Full Name" Column:"1" Page:"Memberships"
#  Step: D365Global: Verify-Table-Header-All-By-Edit-Column Text:"Full Name,Membership Status,Membership Type" Page:"Memberships"
#  Step: D365Global: Table-Input-Filter Text:"AFFAR MEDIA" Page:"Memberships"
#  Step: D365Global: Table-Input-Filter Text:"AFFAR MEDIA" By-Instance:"1" Page:"Memberships"
#  Step: D365Global: Click-Link Text:"AFFAR MEDIA"
#  Step: D365Global: Wait-And-Verify-Page-Header Text:"AFFAR MEDIA" Page:"Memberships"
#  Step: D365Global: Verify-Header-Control-List Text:"S9562553C" Page:"Memberships"
#  Step: D365Global: Click-Tab Text:"Membership Details"
#  Step: D365Global: Verify-Input-Value Text:"AFFAR MEDIA" Field:"Full Name" Page:"Memberships"
#  Step: D365Global: Verify-Input-Date Text:"3/1/1995" Field:"Date of Birth (DD/MM/YYYY)" Page:"Memberships"
#  Step: D365Global: Verify-Input-Lookup Text:"GB" Field:"Membership Type" Page:"Memberships"
#  Step: D365Global: Verify-Select Text:"Female" Field:"Gender" Page:"Memberships"
#  Step: I wait for "10" seconds
#  Step: D365Global: Click-Menu-Button Text:"Go back"
#  Step: D365Global: Click-Menu-Button Text:"Create a new Membership record"
  Step: D365Global: Input Text:"Renish" Field:"Given Name" Page:"Memberships"
#  Step: D365Global: Scroll Value:"1000" From-Visible Field:"Given Name" Page:"Memberships"
#  Step: D365Global: Input Text:"+61734384934983948" Field:"Office Telephone" Page:"Memberships"
#  Step: D365Global: Input-Date Text:"12/20/2023" Field:"Member Start Date" Page:"Memberships"
#  Step: D365Global: Input Text:"Kozhithottathil" Field:"Surname" Page:"Memberships"
#  Step: D365Global: Input-Date Text:"10/20/2023" Field:"Member Start Date" Page:"Memberships"
#  Step: D365Global: Input Text:"Renish Kozhithottathil" Field:"Full Name" Page:"Memberships"
#  Step: D365Global: Input-Lookup Text:"Freelancer" Field:"Company, Lookup" Page:"Membership"
##  Step: D365Global: Input-Lookup Text:"Freelancer" Field:"Company" Page:"Memberships" Wait-In-Secs:"5"
#  Step: D365Global: Input Text:"K" Field:"Surname" Page:"Membership"
#  Step: D365Global: Input-Lookup Text:"Test" By-Clearing-Value:"Freelancer" Field:"Company" Page:"Memberships"
#  Step: D365Global: Select Text:"Union Membership" Field:"Membership Category" Page:"Memberships"
#  Step: D365Global: Select Text:"Retired" Field:"Employment Type" Page:"Memberships"
#  Step: D365Global: Select Index:"2" Field:"Relationship to Main Honorary Member" Page:"Memberships"
#  Step: D365Global: Select Text:"Female" Field:"Gender" Page:"Memberships"
#  Step: D365Global: Select Index:"2" Field:"Highest Education Level" Page:"Memberships"
#  Step: D365Global: Select Index:"1" Field:"Marital Status" Page:"Memberships"
#  Step: D365Global: Select Index:"3" Field:"Race" Page:"Memberships"
#  Step: D365Global: Click-Tab Text:"Social Membership Details"
#  Step: D365Global: Click-Tab Text:"Membership Charge Items"
#  Step: D365Global: Click-Main-Menu-Button Text:"Create a new record" Then-Sub-Menu-Button Text:"Company"
  Step: I wait for "5" seconds
#  Step: D365: Input:{0} field:{1} page:{2}

    Examples: {'dataFile':'resources/data/athena_membership_data.csv', 'filter':'_ID==\"AT-T002\" and _STATUS==\"yes\"'}


  @AT-T003
    @TestCaseId:AT-T003
  Scenario Outline: Table Clicks, Checking Disable fields
  Step: I store value "Ellis - B8688 - 2912230928" into variable "var.record"
  Step: I store value "11/21/2023 11:29 AM" into variable "var.record.2"
  Step: Login-Page: I login to Athena as "User Type" with following details "${env.url}", "<username>" and "<password>"
  Step: D365Global: Wait-And-Verify-Page-Header Text:"Dashboard Notification" Page:"Home"
  Step: D365Global: Switch-App From:"NTUC ATHENA" To:"Batch Jobs Administration"
  Step: D365Global: Wait-And-Verify-Page-Header Text:"Active Master Batch Jobs" Page:"Batch Jobs Administration - Home"
  Step: D365Global: Switch-App From:"Batch Jobs Administration" To:"NTUC ATHENA"
  Step: D365Global: Wait-And-Verify-Page-Header Text:"Dashboard Notification" Page:"NTUC ATHENA - Home"
  Step: I wait for "5" seconds
#  Step: D365Global: Table-Input-Filter Text:"123::2" Page:"Membership Applications"
#  Step: D365Global: Table-Input-Filter Text:"567" Page:"Membership Applications"
#  Step: I wait for "10" seconds
#  Step: D365Global: Table-Select By-Instance:"3" Page:"Home"
#  Step: I wait for "10" seconds
  Step: D365Global: Click-Left-Menu Text:"Membership Management" Then-Sub-Menu Text:"Membership Applications"
  Step: D365Global: Wait-And-Verify-Page-Header Text:"Active Membership Applications" Page:"Membership Applications"
  Step: D365Global: Assign-Table-Cell-Value-To-Variable Row:"1" Column:"11" To-Variable:"var_test_1" Page:"Membership Applications"
  Step: I comment "===var.test.1====> ${var_test_1}"
  Step: D365Global: Table-Input-Filter Text:"${var.record}" Page:"Membership Applications"
  Step: D365Global: Assign-Table-Row-Count To-Variable:"var.test.2" Page:"Membership Applications"
  Step: I comment "===var.test.2====> ${var.test.2}"
  Step: D365Global: Verify-Table-Cell-Value Text:"NCS" Row:"1" Column:"7" Page:"Membership Applications"
  Step: D365Global: Verify-Table-Header-All Text:"Full Name (as per NRIC),Application Status,Record Created On,Member No." Page:"Membership Applications"
  Step: D365Global: Verify-Table-Header Text:"Created On" Column:"11" Page:"Membership Applications"
  Step: D365Global: Table-Click-Header Text:"Created On" Column:"11" Then-Click-Dropdown-Button Text:"Sort newer to older" Page:"Membership Applications"
  Step: D365Global: Double-Click-Table-Cell Row:"1" Column:"1" Page:"Membership Applications"
  Step: D365Global: Wait-And-Verify-Page-Header Text:"${var.record}" Page:"Membership Applications"
#  Step: D365Global: Store-Header-Control-List-Column-Value Column:"2" To-Variable:"var.test.3" Page:"Membership Applications"
  Step: D365Global: Store-Header-Control-List-Column-Value Column:"2" To-Variable:"var.test.3" Page:"Membership Applications"
  Step: I comment "===var.test.3====> ${var.test.3}"
  Step: D365Global: Verify-field-locked Field:"Recruitment Channel" Page:"Membership Applications"
  Step: D365Global: Verify-Input-Value Text:"Ellis - 0711232047" Field:"Name (to be printed on card)" Page:"Membership Applications::Quick_Create"
  Step: D365Global: Click-Tab Text:"Cases/Requests" Page:"Membership Applications"

#  Step: D365Global: Verify-Input-Date Text:"1/1/1968" Field:"Date of Birth" Page:"Membership Applications"
#  Step: D365Global: Verify-Input-Lookup Text:"EMPLOYED - MANAGER" Field:"Occupation Group::1" Page:"Membership Applications"
#  Step: D365Global: Verify-Select Text:"NTUC" Field:"Recruitment Channel" Page:"Membership Applications"

  #  Step: D365Global: Verify-Table-Column-Sort Header-Text:"Full Name (as per NRIC)" Header-Column:"1" Then-Check-Sort-Dropdown-Button Text:"Sort A to Z" Page:"Membership Applications"
#  Step: D365Global: Click-Main-System-View Text:"Active Membership Applications" Then-Sub-System-View Text:"Termination Report" Page:"Membership Applications"
#  Step: D365Global: Wait-And-Verify-Page-Header Text:"Termination Report" Page:"Membership Applications"

#  Step: D365Global: Table-Input-Filter Text:"${var.record}" Page:"Membership Applications"
#  Step: D365Global: Verify-Table-Cell-Value Text:"${var.record.2}" Row:"1" Column:"11" Page:"Recruiters"
#  Step: D365Global: Double-Click-Table-Cell Row:"1" Column:"11" Page:"Membership Applications"
#  Step: D365Global: Wait-And-Verify-Page-Header Text:"${var.record}" Page:"Membership Applications"
#  Step: D365Global: Verify-Input-Disabled Field:"Full Name (as per NRIC)" Page:"Membership Applications"
#  Step: D365Global: Verify-Input-Value Text:"${var.record}" Field:"Full Name (as per NRIC)" Page:"Membership Applications"
#  Step: D365Global: Verify-Input-Date-Disabled Field:"Start Date(DD/MM/YYYY)" Page:"Recruiters"
#  Step: D365Global: Verify-Select-Disabled Field:"Recruiter Type" Page:"Recruiters"
  Step: I wait for "5" seconds

    Examples: {'dataFile':'resources/data/athena_membership_data.csv', 'filter':'_ID==\"AT-T002\" and _STATUS==\"yes\"'}


  @AT-T004
    @TestCaseId:AT-T004
  Scenario Outline: D365 Table Test
    Step: Login-Page: I login to Athena as "User Type" with following details "${env.url}", "<username>" and "<password>"
    Step: D365Global: Wait-And-Verify-Page-Header Text:"Dashboard Notification" Page:"Home"
    Step: D365Global: Click-Main-Menu-Link Text:"Membership Management" Then-Sub-Menu-Link Text:"Membership Applications"
    Step: D365Global: Wait-And-Verify-Page-Header Text:"Active Membership Applications" Page:"Membership Applications"
    Step: D365Global: Table-Edit-Filter-Delete-All-And-Input-New filters:"['Allow ECard','Equals','No,Yes'],['Year','','1990']" Page:"Membership Applications"
    Step: D365Global: Table-Edit-Filter-Reset-To-Default Page:"Membership Applications"
    Step: I wait for "5" seconds
    Examples: {'dataFile':'resources/data/athena_membership_data.csv', 'filter':'_ID==\"AT-T002\" and _STATUS==\"yes\"'}


  @AT-T005
    @TestCaseId:AT-T005
  Scenario Outline: D365 Global Regression Test - New
  Step: Login-Page: I login to Athena as "User Type" with following details "${env.url}", "<username>" and "<password>"
  Step: D365Global: Wait-And-Verify-Page-Header Text:"Dashboard Notification" Page:"Home"
  Step: D365Global: Click-Left-Menu Text:"Membership Management" Then-Sub-Menu Text:"Membership Applications"
  Step: D365Global: Wait-And-Verify-Page-Header Text:"Active Membership Applications" Page:"Membership Applications"
#  Step: D365Global: Click-Main-Menu-Button Text:"Action More Commands. Action" Then-Sub-Menu-Button Text:"Transfer" Page:"Membership Applications"
  Step: D365Global: Click-Top-Menu-Button Text:"Create a new Membership Application record." Page:"Membership Applications"
  Step: D365Global: Input Text:"Test Name" Field:"Full Name (as per NRIC)" Page:"Membership Applications"
  Step: D365Global: Input-Lookup Text:"AUDIT HISTORY" Field:"Company" Page:"Membership Applications"
  Step: D365Global: Input-Date Text:"01/03/2000" Field:"Date of Birth" Page:"Membership Applications"
#  Step: D365Global: Input-Lookup Text:"DIGNITY" By-Clearing-Value:"AUDIT HISTORY" Field:"Company" Page:"Membership Applications"
  Step: D365Global: Verify-Header-Control-List Text:"Hardcopy" Page:"Membership Applications"
  Step: D365Global: Click-Tab Text:"Membership Details" Page:"Membership Applications"
  Step: D365Global: Click-Tab Text:"Cases/Requests" Page:"Membership Applications"

  Step: I wait for "5" seconds
    Examples: {'dataFile':'resources/data/athena_membership_data.csv', 'filter':'_ID==\"AT-T002\" and _STATUS==\"yes\"'}