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

  /**
   * Constructor for a theme
   *
   * @param theme theme name
   * @param fontColor font color
   * @param fontType font type
   * @param icons icons
   */
  public Theme(String theme, Color fontColor, String fontType, List<Image> icons) {
    this.theme = theme;
    this.fontColor = fontColor;
    this.fontType = fontType;
    this.icons = icons;
  }
}
