# ********RoostGPT********

# Test generated by RoostGPT for test karateTest using AI Type Open AI and AI Model gpt-4
# 
# Feature file generated for /accounts_post for http method type POST 
# RoostTestHash=53e96f9805
# 
# 

# ********RoostGPT********
Feature: Accounts API

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:8080')
    * url urlBase
    * def authToken = karate.properties['AUTH_TOKEN']
    * configure headers = { 'commit-hash': authToken } 

  Scenario Outline: Create new Account
    Given path '/accounts'
    And request { email: '<email>' }
    When method post
    Then match responseStatus == <status>
    And match responseHeaders['api-version'] == '1.0.0'
    And match responseHeaders['commit-hash'] == '#string'
    * def responseSchema = { email: '#string' }
    And match response == responseSchema

    Examples:
      | email              | status |
      | 'test@example.com' |    201 |
      | 'invalid_email'    |    400 |

  Scenario Outline: Error handling for Create new Account
    Given path '/accounts'
    And request { email: '<email>' }
    When method post
    Then match responseStatus == <status>
    And match responseHeaders['api-version'] == '1.0.0'
    And match response.error == '<error>'
    And match response.description == '<description>'

    Examples:
      | email           | status | error                 | description            |
      | 'invalid_email' |    400 | 'validation/email'    | 'Invalid email format' |
      | ''              |    400 | 'validation/required' | 'Email is required'    |
