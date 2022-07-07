@MagicBricks
Feature: MagicBricks

@Unsuccessful_Search_Buy
Scenario: Search with blank data
Given user is on home page
When  user do not select location
When user do not select property type
When user do not select budget
And click on search
Then Alert please enter a valid Location or Project
And close

@Unsuccessful_Search_Buy
Scenario: Search with only resedential property type
Given user is on home page
When user do not select location
When user select resedential property type 
When user do not select budget
And click on search  
Then Alert please enter a valid Location or Project
And close

@Unsuccessful_Search_Buy
Scenario: Search with only valid budget
Given user is on home page
When user do not select location
When user do not select property type
When user select only budget 
And click on search  
Then Alert please enter a valid Location or Project
And close

@Successful_Search_Buy
Scenario: Search with only valid location
Given user is on home page
When  user select only valid location
When  user do not select property type
When  user do not select budget
And click on search  
Then navigate user to buy page
And close 

@Successful_Search_Buy
Scenario: Search with only valid location and resedential property type
Given user is on home page
When user select valid location
When user select property type
When user do not select budget
And click on search  
Then navigate user to buy page
And close
#============================================================
@Successful_Search_Buy
Scenario: Search with all Valid data
Given user is on home page
When user select valid location
When user select property type
When user select budget
And click on search  
Then navigate user to buy page
And close

@Unsuccessful_Search_Buy
Scenario: Search with Invalid Location
Given user is on home page
When user do not select location
When user enter invalid location
When user select property type
When user select valid budget
And click on search  
Then Alert please enter a valid Location or Project
And close

@Unsuccessful_Search_Buy
Scenario: Search with Invalid Budget
Given user is on home page
When user select valid location
When user select property type
When user select invalid budget
And click on search  
Then navigate user to buy page
Then Alert We couldn't find matching Properties!
And close

@Unsuccessful_Search_Buy
Scenario: Search with all Invalid data
Given user is on home page
When user do not select location
When user enter invalid location
When user select property type
When user select invalid budget
And click on search  
Then Alert please enter a valid Location or Project
And close

#++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

@Successful_Buying_Assistance_home_loan
Scenario: Successful Buying Assistance for home loan
Given user is on home page
When user select valid location
When user select property type
When user select valid budget
And click on search  
Then navigate user to buy page
When user select Home Loans
And click on Home Loan
Then navigate user to home loan page
When user enter valid loan amount
When user enter valid Mobile number
When user select checkbox to agree privacy policy
And click on Get Started
#Then navigate user to verify number page
#When user enter verification code
#And click on Submit 
#When user select his employment
#And click on next
#When user enter his gross monthly income
#And click on next
#When user enter city name
#And click on next
#Then navigate to loan bank partners page
#When user select bank
#And click on more details
#And click on Apply
#Then navigate to Application done succesfully page
And close

@Unsuccessful_Buying_Assistance_home_loan
Scenario: Failure in Home Loan with invalid loan amount
Given user is on home page
When user select valid location
When user select property type
When user select valid budget
And click on search  
Then navigate user to buy page
When user select Home Loans
And click on Home Loan
Then navigate user to home loan page
When user enter invalid loan amount
When user enter valid Mobile number
When user select checkbox to agree privacy policy
And click on Get Started
Then Alert Loan amount can not be less
And close

@Unsuccessful_Buying_Assistance_home_loan
Scenario: Failure in Home Loan with invalid mobile number
Given user is on home page
When user select valid location
When user select property type
When user select valid budget
And click on search  
Then navigate user to buy page
When user select Home Loans
And click on Home Loan
Then navigate user to home loan page
When user enter valid loan amount
When user enter invalid Mobile number
When user select checkbox to agree privacy policy
And click on Get Started
Then Mobile number is not valid
And close

@Unsuccessful_Buying_Assistance_Home_loan
Scenario: Failure in Home Loan with agree privacy policy checkbox not seteted
Given user is on home page
When user select valid location
When user select property type
When user select valid budget
And click on search  
Then navigate user to buy page
When user select Home Loans
And click on Home Loan
Then navigate user to home loan page
When user enter valid loan amount
When user enter valid Mobile number
When user do not select checkbox to agree privacy policy
And click on Get Started
Then Alert agree privacy policy
And close

#=======================

@Successful_Buying_Assistance_Set_Property_Alert
Scenario: Successful Buying Assistance for property alert
Given user is on home page
When user select valid location
When user select property type
When user select valid budget
And click on search 
When user select My Activity 
And click on Manage Properties
When user is in login page
And click on Next
When user put otp
And click on Continue
Then navigate from add to main page
And click buy for assitance
Then navigate to Property Alert page
When user select Buy
When user select buy property type
When user select buy budget
When user select bedroom
When user select Construction Status
#When user select Floor prefernce
When user select area
When user select city
When user select locality or project
When user select Recieve Alert For
When user select Alert Frequency
When user select I agree to privacy policy
And click on Share Your Requirement
#Then Alert verify your mobile number
#When user enter verification code
Then navigate to Alert saved successfully page
And close


@Unsuccessful_Buying_Assistance_Set_Property_Alert
Scenario: Failure in Property Alert with property type not selected
Given user is on home page
Given user is on home page
When user select valid location
When user select property type
When user select valid budget
And click on search 
When user select My Activity 
And click on Manage Properties
When user is in login page
And click on Next
When user put otp
And click on Continue
Then navigate from add to main page
And click buy for assitance
Then navigate to Property Alert page
When user select Buy
When user do not select buy property type
When user select buy budget
When user select bedroom
When user select Construction Status
#When user select Floor prefernce
When user select area
When user select city
When user select locality or project
When user select Recieve Alert For
When user select Alert Frequency
When user select I agree to privacy policy
And click on Share Your Requirement
#Then Alert verify your mobile number
#When user enter verification code
Then navigate to Alert saved successfully page
And close


@Unsuccessful_Buying_Assistance_Set_Property_Alert
Scenario: Failure in Property Alert with budget not selected
Given user is on home page
When user select valid location
When user select property type
When user select valid budget
And click on search 
When user select My Activity 
And click on Manage Properties
When user is in login page
And click on Next
When user put otp
And click on Continue
Then navigate from add to main page
And click buy for assitance
Then navigate to Property Alert page
When user select Buy
When user select buy property type
When user do not select buy budget
When user select bedroom
When user select Construction Status
#When user select Floor prefernce
When user select area
When user select city
When user select locality or project
When user select Recieve Alert For
When user select Alert Frequency
When user select I agree to privacy policy
And click on Share Your Requirement
#Then Alert verify your mobile number
#When user enter verification code
Then navigate to Alert saved successfully page
And close


@Unsuccessful_Buying_Assistance_Set_Property_Alert
Scenario: Failure in Property Alert with bedroom not selected
Given user is on home page
When user select valid location
When user select property type
When user select valid budget
And click on search 
When user select My Activity 
And click on Manage Properties
When user is in login page
And click on Next
When user put otp
And click on Continue
Then navigate from add to main page
And click buy for assitance
Then navigate to Property Alert page
When user select Buy
When user select buy property type
When user select buy budget
When user do not select bedroom
When user select Construction Status
#When user select Floor prefernce
When user select area
When user select city
When user select locality or project
When user select Recieve Alert For
When user select Alert Frequency
When user select I agree to privacy policy
And click on Share Your Requirement
#Then Alert verify your mobile number
#When user enter verification code
Then navigate to Alert saved successfully page
And close

@Unsuccessful_Buying_Assistance_Set_Property_Alert
Scenario: Failure in Property Alert with construction status not selected
Given user is on home page
When user select valid location
When user select property type
When user select valid budget
And click on search 
When user select My Activity 
And click on Manage Properties
When user is in login page
And click on Next
When user put otp
And click on Continue
Then navigate from add to main page
And click buy for assitance
Then navigate to Property Alert page
When user select Buy
When user select buy property type
When user select buy budget
When user select bedroom
When user do not select Construction Status
#When user select Floor prefernce
When user select area
When user select city
When user select locality or project
When user select Recieve Alert For
When user select Alert Frequency
When user select I agree to privacy policy
And click on Share Your Requirement
#Then Alert verify your mobile number
#When user enter verification code
Then navigate to Alert saved successfully page
And close























