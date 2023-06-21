package cs3500.pa05.controller;

import cs3500.pa05.json.Converter;
import cs3500.pa05.model.adapterclasses.Week;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class SaveController {
  @FXML
  private TextField maxt;
  @FXML
  private TextField maxe;
  private Converter converter;

  private Week week;
  private FileChooser chooser;

  public SaveController(Converter c, Week w) {
    this.converter = c;
    this.week = w;
  }

  public void run() {
    week.setMaxe(Integer.parseInt(maxe.getText()));
    week.setMaxt(Integer.parseInt(maxt.getText()));
    savetofiles();
  }

  public void savetofiles() {
  }


}
