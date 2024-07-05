Feature: Сценарии для Интернет магазина

  @browse
  Scenario: Просмотр списка товаров в категории "Электроника"
    Given пользователь на главной странице магазина
    When он переходит в категорию "Электроника"
    Then он видит список товаров этой категории

  @search
  Scenario: Поиск товара "iPhone 13"
    Given пользователь на главной странице магазина
    When он вводит "iPhone 13" в строку поиска
    Then он видит товар "iPhone 13" в результатах поиска

  @cart @purchase
  Scenario: Добавление товара "iPhone 13" в корзину
    Given пользователь нашел товар "iPhone 13"
    When он добавляет товар в корзину
    Then в его корзине находится товар "iPhone 13"


