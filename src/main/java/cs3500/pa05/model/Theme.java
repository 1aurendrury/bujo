package cs3500.pa05.model;

import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Represents a theme
 */
public class Theme {
  String theme;
  Color fontColor;
  String fontType;
  List<Image> icons;

  public Theme(String theme, Color fontColor, String fontType, List<Image> icons) {
    this.theme = theme;
    this.fontColor = fontColor;
    this.fontType = fontType;
    this.icons = icons;
  }
}
