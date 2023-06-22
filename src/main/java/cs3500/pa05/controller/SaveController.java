package cs3500.pa05.controller;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import cs3500.pa05.model.adapterclasses.Week;
import cs3500.pa05.model.json.WeekJson;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class SaveController {
  @FXML
  private TextField quotesandnotes;
  private Converter converter;

  private Week week;
  private FileChooser chooser;
  private Stage mainstage;

  public SaveController(Stage s, Converter c, Week w) {
    this.mainstage = s;
    this.converter = c;
    this.week = w;
  }

  public void savetofiles(File file) throws IOException {
    WeekJson w = converter.weektoJson(week);
    ObjectMapper mapper = new ObjectMapper();
    ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
    writer.writeValue(file, w);
  }


}
