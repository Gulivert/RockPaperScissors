  @game
  Feature: play a game
  
  Scenario: start a new game
    Given is a new game
     When play a game
     Then the number of rounds is 1
  
  Scenario: continue a game
    Given is an old game
     When play a game
     Then the number of rounds is not 1
  
  Scenario: both player force a draw
     When the player1 and player2 play a game with the same hand
     Then no one win, is a draw
  