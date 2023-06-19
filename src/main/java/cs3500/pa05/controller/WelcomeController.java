package cs3500.pa05.controller;

public interface WelcomeController {
  /**
   * Initializes a game of Whack-A-Mole.
   *
   * @throws IllegalStateException if the game board is not defined
   */
  void run() throws IllegalStateException;
}
