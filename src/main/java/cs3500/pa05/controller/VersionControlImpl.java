package cs3500.pa05.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

public class VersionControlImpl implements VersionControl {
  private final ControllerImpl controller;
  private final ObjectMapper mapper = new ObjectMapper();

  VersionControlImpl(ControllerImpl controller) {
    this.controller = controller;
  }

  @Override
  public void save() {

  }

  @Override
  public void open() {

  }
}
