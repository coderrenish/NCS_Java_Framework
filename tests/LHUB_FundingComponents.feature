@FUNDING-COMPONENTS
Feature: Funding Components Test cases

  @LHUB-T001
  Scenario: Create new Funding Component
  Step: Login-Page: I login to LHUB with following details "${env.url}"
  Result: Funding-Page: I verify I'm in funding home page



#  Result: Home-Page: I verify I am in Athena homepage
#  Step: Menu: I navigate to "Membership Management" > "Memberships"
#  Result: Membership-Page: I verify I am in Athena Membership page


#Examples: {'dataFile':'resources/data/lhub_fund_comp_data.csv', 'filter':'_ID==\"LHUB-T001\" and _STATUS==\"yes\"'}
