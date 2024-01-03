@TESTRUN @TT_00 @TestCaseId:TT_00 @UAT @SIT
Scenario Outline: [TEST RUN] - Test scenario using Actions (without writing any Step definitions)
Step: "Login": "I login to SauseDemo" -action/s:"{open}{browser}{${env.url}},{input}{<username>}{in}{Username},{input}{<password>}{in}{Password},{click}{Login}{button}"
Result: "Home": "I verify I'm in homepage" -action/s:"{verify}{text}{Products}{present}{in}{page}"

Examples: {'dataFile':'resources/data/test-run.csv', 'filter':'_ID==\"TST-00\" and _STATUS==\"yes\"'}
