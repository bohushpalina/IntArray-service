package com.ivanov.first.warehouse;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
  private static Warehouse instance;
  private Map<Long, IntArrayParameters> parametersMap = new HashMap<>();

  private Warehouse() {}

  public static Warehouse getInstance() {
    if (instance == null) {
      instance = new Warehouse();
    }
    return instance;
  }

  public void putParameters(Long id, IntArrayParameters params) {
    parametersMap.put(id, params);
  }

  public IntArrayParameters getParameters(Long id) {
    return parametersMap.get(id);
  }
}
