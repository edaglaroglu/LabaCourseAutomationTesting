@qatool
Feature: Add and Edit Record

  Scenario: Add new record and edit it

    Given I am on the WebTables page
    When I add a new record
    And I edit the record
    Then I should see updated email "duygu@c.com"


