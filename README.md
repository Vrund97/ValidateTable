# ValidateTable
Selenium Testing to validate whether 2 tables are the same 

Setup: Chrome driver is placed in a seperate folder (ChromeDriver) and path is configured as such to use in code. Chrome Version 96 was used for the solution and so chromedriver file might need to be replaced depending on Chrome Version. Selenium 3 was used for this solution.

Assumptions Made:
  1. To check whether 2 tables are the same, table data was validated
  2. Assertions packages etc were not to be used as instructions did not indicate as such

The following validations were done:
  1. Column Count Validation
  2. Row Count Validation
  3. Header Value Validation
  4. Table Data Validation
