# GameControllerApi

All URIs are relative to *https://virtserver.swaggerhub.com/Ggmartin/RockPaperScissors/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getHandTypes**](GameControllerApi.md#getHandTypes) | **GET** /catalogTypes | Catalog of types of hands
[**playGame**](GameControllerApi.md#playGame) | **POST** /start | Game of two players.


<a name="getHandTypes"></a>
# **getHandTypes**
> List&lt;HandType&gt; getHandTypes()

Catalog of types of hands

Catalog of types of hands

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GameControllerApi;


GameControllerApi apiInstance = new GameControllerApi();
try {
    List<HandType> result = apiInstance.getHandTypes();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GameControllerApi#getHandTypes");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;HandType&gt;**](HandType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="playGame"></a>
# **playGame**
> Game playGame(player1HandId, player2HandId, id)

Game of two players.

Game of two players.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GameControllerApi;


GameControllerApi apiInstance = new GameControllerApi();
Integer player1HandId = 56; // Integer | id Hand
Integer player2HandId = 56; // Integer | id Hand
Integer id = 56; // Integer | Id of the game
try {
    Game result = apiInstance.playGame(player1HandId, player2HandId, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GameControllerApi#playGame");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **player1HandId** | **Integer**| id Hand |
 **player2HandId** | **Integer**| id Hand |
 **id** | **Integer**| Id of the game | [optional]

### Return type

[**Game**](Game.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

