@MEMBERSHIP
Feature: Membership Test cases

  @AT-T001
    @TestCaseId:AT-T001
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
  Scenario Outline: Create new Membership 2
  Step: Login-Page: I login to Athena as "User Type" with following details "${env.url}", "<username>" and "<password>"
  Step: MsDynamicsGlobal: Click-Main-Menu Text:"Membership Management" Then-Sub-Menu Text:"Memberships"
  Step: MsDynamicsGlobal: Wait-And-Verify-Page-Header Text:"Union Memberships" Page:"Memberships"
  Step: MsDynamicsGlobal: Input-Filter-Keyword Text:"AFFAR MEDIA" Instance:"1"
  Step: MsDynamicsGlobal: Click-Link Text:"AFFAR MEDIA"
  Step: I wait for "10" seconds
  Step: MsDynamicsGlobal: Click-Menu-Button Text:"Create a new Membership record"
  Step: MsDynamicsGlobal: Input Text:"Renish" Field:"Given Name" Page:"Memberships"
  Step: MsDynamicsGlobal: Scroll Value:"1000" From-Visible Field:"Given Name" Page:"Memberships"
  Step: MsDynamicsGlobal: Input Text:"+61734384934983948" Field:"Office Telephone" Page:"Memberships"
  Step: MsDynamicsGlobal: Input Date:"12/20/2023" Field:"Date of Member Start Date" Page:"Memberships"
  Step: MsDynamicsGlobal: Input Text:"Kozhithottathil" Field:"Surname" Page:"Memberships"
  Step: MsDynamicsGlobal: Input Date:"10/20/2023" Field:"Date of Member Start Date" Page:"Memberships"
  Step: MsDynamicsGlobal: Input Text:"Renish Kozhithottathil" Field:"Full Name" Page:"Memberships"
  Step: MsDynamicsGlobal: Input-Lookup Text:"Freelancer" Field:"Company, Lookup" Page:"Membership"
#  Step: MsDynamicsGlobal: Input-Lookup Text:"Freelancer" Field:"Company" Page:"Memberships" Wait-In-Secs:"5"
  Step: MsDynamicsGlobal: Input Text:"K" Field:"Surname" Page:"Membership"
#  Step: MSDynamics: Input-Lookup Text:"Test" By-Clearing-Existing-Value Field:"Company" Page:"Membership"
  Step: MsDynamicsGlobal: Input-Lookup Text:"Test" By-Clearing-Value:"Freelancer" Field:"Company" Page:"Memberships"
  Step: MsDynamicsGlobal: Select Text:"Union Membership" Field:"Membership Category" Page:"Memberships"
  Step: MsDynamicsGlobal: Select Text:"Retired" Field:"Employment Type" Page:"Memberships"
  Step: MsDynamicsGlobal: Select Index:"2" Field:"Relationship to Main Honorary Member" Page:"Memberships"
  Step: MsDynamicsGlobal: Click-Tab Text:"Membership Details"
  Step: I wait for "45" seconds
#  Step: D365: Input:{0} field:{1} page:{2}

    Examples: {'dataFile':'resources/data/athena_membership_data.csv', 'filter':'_ID==\"AT-T002\" and _STATUS==\"yes\"'}