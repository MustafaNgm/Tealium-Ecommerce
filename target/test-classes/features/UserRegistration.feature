Feature: UserRegistration
As a user i want to registration from nopcommerce

Scenario Outline: User Registeration

Given user open the register page

When user fills the fields "<firstname>" , "<middlename>" , "<lastname>" , "<email>" , "<password>"
And press on save button

Then the registration process was completed successfully

Examples:
| firstname | middlename | lastname | email | password |
| mustafa | mohamed | ngm | ngm@test17.com |123456789 |
| mustafa | mohamed | ngm | ngm@test18.com |123456789 |
| mustafa | mohamed | ngm | ngm@test19.com |123456789 |
| mustafa | mohamed | ngm | ngm@test20.com |123456789 |