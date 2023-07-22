Feature: Ar-de technologie
  Background:
    Given The user should be on the ar-ge page
    Then Validate the correct page

  Scenario: Applying for a job
    When The user choose the "Career" menu
    Then Validate the correct menu
    And The user should choose "SOFTWARE TESTING SPECIALIST" job
    And The user should apply for job
    And The user should fill the apply for this position list with "Seyma", "Dalkiran", "camdalkiran@gmail.com", "5051302666"
    And The user should add the github url "https://github.com/seymacamdalkiran/ardeApply"
    And The user should add the linkedin profile url "https://www.linkedin.com/in/seyma-c/"
    And The user should write description "I am a Software Test Specialist with a strong experience in Selenium and Java. I also have a basic understanding of SQL."
    And The user should submit application
    Then The user should see "Verification" message