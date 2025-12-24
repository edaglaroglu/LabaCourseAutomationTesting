@qatool
  Feature: click button

   User clicks click me button and see the message

    Scenario:Click me button and verify message

      Given I am on the Elements Page
      When I go to the Buttons section
      And I click the Click Me button
      Then I should see click message "You have done a dynamic click"


