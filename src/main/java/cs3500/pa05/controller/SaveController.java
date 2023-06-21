package cs3500.pa05.controller;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import cs3500.pa05.json.Converter;
import cs3500.pa05.json.WeekJson;
import cs3500.pa05.model.adapterclasses.Week;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class SaveController {
  @FXML
  private TextField maxt;
  @FXML
  private TextField maxe;
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
    String out = writer.writeValueAsString(w);
    FileWriter writ = new FileWriter(file);
    writ.write(out);
    writ.close();
  }


}
