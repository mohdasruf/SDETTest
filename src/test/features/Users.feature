Feature: To verify Create, Update , Retrieval and Search features for Users API

  Background:
    Given the baseURI is set

  Scenario Outline: To verify Rest service - Successful retrieval of information
    Given I make a get request to the "<endpoint>" using "<Id>"
    Then response status code should be 200
    And response should include the following "<Name>" "<Email>" "<Street>" "<City>" "<suite>" "<zipcode>" "<Lat>" "<Long>" "<Phone>" "<Website>"
    Examples:
      | Id | Name          | Email             | Street      | City        | suite    | zipcode    | Lat      | Long    | Phone                 | Website       | endpoint |
      | 1  | Leanne Graham | Sincere@april.biz | Kulas Light | Gwenborough | Apt. 556 | 92998-3874 | -37.3159 | 81.1496 | 1-770-736-8031 x56442 | hildegard.org | Users    |

  Scenario Outline: To verify Rest service - Unsuccessful retrieval of information (Not found error)
    Given I make a get request to the "<endpoint>" using "<Id>"
    Then response status code should be 404
    Examples:
      | Id  | endpoint |
      | 100 | Users    |

  Scenario Outline: To verify Rest service - Successful creation of information
    Given I make a post request to the "<endpoint>" using "<Name>" "<Username>" "<Email>" "<Street>" "<City>" "<suite>" "<zipcode>" "<Lat>" "<Long>" "<Phone>" "<Website>" "<CompanyName>" "<CatchPhrase>" "<Bs>"
    Then response status code should be 201
    Examples:
      | endpoint | Name          | Username | Email             | Street      | City        | suite    | zipcode    | Lat      | Long    | Phone                 | Website       | CompanyName     | CatchPhrase                            | Bs                          |
      | users    | Leanne Graham | Bret     | Sincere@april.biz | Kulas Light | Gwenborough | Apt. 556 | 92998-3874 | -37.3159 | 81.1496 | 1-770-736-8031 x56442 | hildegard.org | Romaguera-Crona | Multi-layered client-server neural-net | harness real-time e-markets |

  Scenario Outline: To verify Rest service - Successful update of information
    Given I make a put request to the "<endpoint>" using "<Name>" "<Username>" "<Email>" "<Street>" "<City>" "<suite>" "<zipcode>" "<Lat>" "<Long>" "<Phone>" "<Website>" "<CompanyName>" "<CatchPhrase>" "<Bs>" "<Id>"
    Then response status code should be 200
    Examples:
      | Id | endpoint | Name          | Username | Email             | Street      | City        | suite    | zipcode    | Lat      | Long    | Phone                 | Website       | CompanyName     | CatchPhrase                            | Bs                          |
      | 1  | users    | Leanne Graham | Bret     | Sincere@april.biz | Kulas Light | Gwenborough | Apt. 556 | 92998-3874 | -37.3159 | 81.1496 | 1-770-736-8031 x56442 | hildegard.org | Romaguera-Crona | Multi-layered client-server neural-net | harness real-time e-markets |

  Scenario Outline: To verify Rest service - Unsuccessful update of information
    Given I make a put request to the "<endpoint>" using "<Name>" "<Username>" "<Email>" "<Street>" "<City>" "<suite>" "<zipcode>" "<Lat>" "<Long>" "<Phone>" "<Website>" "<CompanyName>" "<CatchPhrase>" "<Bs>" "<Id>"
    Then response status code should be 500
    Examples:
      | Id | endpoint | Name          | Username | Email             | Street      | City        | suite    | zipcode    | Lat      | Long    | Phone                 | Website       | CompanyName     | CatchPhrase                            | Bs                          |
      | 15 | users    | Leanne Graham | Bret     | Sincere@april.biz | Kulas Light | Gwenborough | Apt. 556 | 92998-3874 | -37.3159 | 81.1496 | 1-770-736-8031 x56442 | hildegard.org | Romaguera-Crona | Multi-layered client-server neural-net | harness real-time e-markets |


  Scenario Outline: To verify Rest service - Successful search using Email Id
    Given I make a search request to the "<endpoint>" using "<Email>"
    Then response status code should be 200
    And response in the list should include the following "<Name>" "<Email>" "<Street>" "<City>" "<suite>" "<zipcode>" "<Lat>" "<Long>" "<Phone>" "<Website>"
    Examples:
      | Name          | Email             | Street      | City        | suite    | zipcode    | Lat      | Long    | Phone                 | Website       | endpoint |
      | Leanne Graham | Sincere@april.biz | Kulas Light | Gwenborough | Apt. 556 | 92998-3874 | -37.3159 | 81.1496 | 1-770-736-8031 x56442 | hildegard.org | Users    |
