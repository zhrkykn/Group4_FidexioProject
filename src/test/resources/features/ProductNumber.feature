
Feature: Product number should be updated and correct in both menus

  Background:
    Given the user is on the login page
    When Enter the user credentials

    @pnf
    Scenario:User should not see the same number of products in Inventory Products, Sales Products and Website Catalog Products when searchbox is filled
      Given the user is on the inventory page
      When the user clicks on "inventory products"
      Then the user gets the number of "inventory products"
      Given the user is on the sales page
      When the user clicks on "sales products"
      Then the user gets the number of "sales products"
      Given the user is on the Website page
      When the user clicks on "website produtcs"
      Then the user gets the number of "website products"
      And the user compares number of the products in Inventory, Sales and Website and result is wrong

    @pnf2
    Scenario:User should see the same number of products in Inventory Products, Sales Products and Website Catalog Products
      Given the user is on the inventory page
      When the user clicks on "inventory products"
      And the user clears search bar
      Then the user gets the number of "inventory products"
      Given the user is on the sales page
      When the user clicks on "sales products"
      And the user clears search bar
      Then the user gets the number of "sales products"
      Given the user is on the Website page
      When the user clicks on "website products"
      And the user clears search bar
      Then the user gets the number of "website products"
      And the user compares number of the products in Inventory, Sales and Website and result is true