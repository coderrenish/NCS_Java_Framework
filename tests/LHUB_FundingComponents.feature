@FUNDING-COMPONENTS
Feature: Funding Components Test cases

  @LHUB-T001 @TestCaseId:LHUB-T001 @PRIORITY:1 @SMOKE @REGRESSION
  Scenario Outline: Create new Funding Component
  Step: Login-Page: I login to LHUB with following details "${env.url}"
  Result: "Funding-Page": I verify I'm in "Funding" home page
  Step: Funding-Page: I navigate to Funding component
  Result: "FundingComp-Page": I verify I'm in "Funding Component" page
  Step: "FundingComp-Page": Menu: I click on "Create" button
  Result: "FundingCompCreate-Page": I verify I'm in "Funding Component Create" page
  Step: FundingCompCreate-Page: I fill following details "<code>","<desc>","<billing_name>","<gl_number>","<payment_mode>","<mandatory_supporting_documents>","<gst_applicable>","<supporting_documents>","<prerequisite_desc>","<prerequisite_sql_mode>","<prerequisite_formula>","<criteria_desc>","<criteria_sql_mode>","<criteria_formula>","<rate_sql_mode>","<rate_formula>"
#    Result:
  Step: I wait for "10" seconds

    Examples: {'dataFile':'resources/data/lhub_fund_comp_data.csv', 'filter':'_ID==\"LHUB-T001\" and _STATUS==\"yes\"'}

