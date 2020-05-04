$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/test.feature");
formatter.feature({
  "name": "AutoTrader Basic Testing",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "name": "Verify the presence of element types in AutoTrader home page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.step({
  "name": "I launch AutoTrade in Chrome Browser",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.navigateToAutoTrader()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify home page is displayed",
  "keyword": "When "
});
formatter.match({
  "location": "steps.verifyHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify the following details",
  "rows": [
    {
      "cells": [
        "Browse by Make"
      ]
    },
    {
      "cells": [
        "Browse by Style"
      ]
    },
    {
      "cells": [
        "Advanced Search"
      ]
    },
    {
      "cells": [
        "Search"
      ]
    },
    {
      "cells": [
        "Any Make"
      ]
    },
    {
      "cells": [
        "Any Model"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "steps.verifyDetails(DataTable)"
});
formatter.result({
  "error_message": "org.openqa.selenium.WebDriverException: chrome not reachable\n  (Session info: chrome\u003d81.0.4044.122)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027ANILSLAPPY\u0027, ip: \u0027192.168.0.13\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002713.0.1\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 81.0.4044.122, chrome: {chromedriverVersion: 81.0.4044.69 (6813546031a4b..., userDataDir: C:\\Users\\anilk\\AppData\\Loca...}, goog:chromeOptions: {debuggerAddress: localhost:60137}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: none, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 580ac72deeb6a7248b4a911d08d07b2d\n*** Element info: {Using\u003dxpath, value\u003d.//button[contains(.,\u0027Browse by Make\u0027)]}\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:500)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:481)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat stepDefinitions.steps.verifyDetails(steps.java:54)\r\n\tat ✽.I verify the following details(file:src/test/java/features/test.feature:8)\r\n",
  "status": "failed"
});
formatter.scenario({
  "name": "Advanced Search on Make BMW",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.step({
  "name": "I select Advanced Search from home page",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.navigateToAdvancedSearchPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter the following details",
  "rows": [
    {
      "cells": [
        "ZipCode",
        "30004"
      ]
    },
    {
      "cells": [
        "Condition",
        "Certified"
      ]
    },
    {
      "cells": [
        "Style",
        "Convertible"
      ]
    },
    {
      "cells": [
        "From Year",
        "2017"
      ]
    },
    {
      "cells": [
        "To Year",
        "2020"
      ]
    },
    {
      "cells": [
        "Make",
        "BMW"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "steps.formInputAndSearch(DataTable)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\".//form//input[@name\u003d\u0027zip\u0027]\"}\n  (Session info: chrome\u003d81.0.4044.122)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027ANILSLAPPY\u0027, ip: \u0027192.168.0.13\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002713.0.1\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 81.0.4044.122, chrome: {chromedriverVersion: 81.0.4044.69 (6813546031a4b..., userDataDir: C:\\Users\\anilk\\AppData\\Loca...}, goog:chromeOptions: {debuggerAddress: localhost:60137}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: none, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 580ac72deeb6a7248b4a911d08d07b2d\n*** Element info: {Using\u003dxpath, value\u003d.//form//input[@name\u003d\u0027zip\u0027]}\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:500)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:481)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat stepDefinitions.steps.formInputAndSearch(steps.java:106)\r\n\tat ✽.I enter the following details(file:src/test/java/features/test.feature:19)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "I click Search button",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.i_click_Search_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "BMW Search results verification and count",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.step({
  "name": "I am in the Search Results page",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.i_am_in_the_Search_Results_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify only BMW cars are in the results",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.i_verify_only_BMW_cars_are_in_the_results()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Log the total number of listings in the page",
  "keyword": "And "
});
formatter.match({
  "location": "steps.log_the_total_number_of_listings_in_the_page()"
});
formatter.result({
  "error_message": "org.openqa.selenium.WebDriverException: chrome not reachable\n  (Session info: chrome\u003d81.0.4044.122)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027ANILSLAPPY\u0027, ip: \u0027192.168.0.13\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002713.0.1\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 81.0.4044.122, chrome: {chromedriverVersion: 81.0.4044.69 (6813546031a4b..., userDataDir: C:\\Users\\anilk\\AppData\\Loca...}, goog:chromeOptions: {debuggerAddress: localhost:60137}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: none, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 580ac72deeb6a7248b4a911d08d07b2d\n*** Element info: {Using\u003dxpath, value\u003d.//div[@data-cmp\u003d\u0027inventoryAlphaListing\u0027]/div}\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:500)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:481)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat stepDefinitions.steps.log_the_total_number_of_listings_in_the_page(steps.java:208)\r\n\tat ✽.Log the total number of listings in the page(file:src/test/java/features/test.feature:32)\r\n",
  "status": "failed"
});
});