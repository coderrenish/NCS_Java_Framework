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
