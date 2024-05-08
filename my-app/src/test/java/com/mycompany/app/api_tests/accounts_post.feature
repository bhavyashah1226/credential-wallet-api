# ********RoostGPT********

# Test generated by RoostGPT for test karateTest using AI Type Open AI and AI Model gpt-4
# 
# Feature file generated for /accounts_post for http method type POST 
# RoostTestHash=53e96f9805
# 
# 

# ********RoostGPT********
Feature: Create new Account

  Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:8080')
    * url urlBase
    * def AUTH_TOKEN = karate.properties['AUTH_TOKEN']
    * def headers = { 'commit-hash': '#(^$|^[a-z0-9]{7}$)', 'Authorization': '#(' + AUTH_TOKEN + ')' }

  Scenario Outline: Test Create new Account API
    Given path '/accounts'
    And headers headers
    And request { email: '<email>' }
    When method post
    Then match responseStatus == <statusCode>
    And match responseHeaders contains { 'api-version': '#string', 'commit-hash': '#string' }
    * def responseSchema =
      """
      {
        "type": "object",
        "properties": {
          "email": {
            "type": "string",
            "pattern": "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
          }
        },
        "required": ["email"]
      }
      """
    And match response == responseSchema

    Examples:
      | email           | statusCode |
      | test@email.com  |        201 |
      | test2@email.com |        201 |
      | invalidEmail    |        400 |
