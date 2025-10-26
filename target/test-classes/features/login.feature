@mobile
Feature: Login en SwagLabs (Android)

  Background:
    Given que la app está abierta

  Scenario: Login exitoso y visualización de productos
    When ingreso credenciales válidas
    Then debería ver el título "PRODUCTS"
    And debería existir al menos un producto en la lista
