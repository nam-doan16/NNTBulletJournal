package cs3500.pa05.controller;

import cs3500.pa05.json.Converter;
import cs3500.pa05.model.adapterclasses.Week;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * the controller for saving
 */
public class SaveController {
  private Converter converter;

  /**
   * constructor
   *
   * @param c the converter
   */
  public SaveController(Converter c) {
    this.converter = c;
  }

  /**
   * saves the content to a file/files
   *
   * @param w the week who's content is being saved
   */
  public void savetofiles(Week w) {

  }


}
