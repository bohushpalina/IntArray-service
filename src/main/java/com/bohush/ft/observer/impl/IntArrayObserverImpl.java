package com.bohush.ft.observer.impl;

import com.bohush.ft.entity.IntArray;
import com.bohush.ft.observer.IntArrayEvent;
import com.bohush.ft.observer.IntArrayObserver;
import com.bohush.ft.service.IntArrayService;
import com.bohush.ft.service.impl.IntArrayServiceImpl;
import com.bohush.ft.warehouse.IntArrayParameters;
import com.bohush.ft.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntArrayObserverImpl implements IntArrayObserver {

  private static final Logger log = LogManager.getLogger(IntArrayObserverImpl.class);
  private IntArrayService service = new IntArrayServiceImpl();

  @Override
  public void arrayUpdated(IntArrayEvent event) {
    IntArray array = event.getSourceArray();
    log.info("Observer received update for IntArray id={}", array.getIntArrayId());

    int min = service.findMinElement(array);
    int max = service.findMaxElement(array);
    double average = service.findAverageValue(array);
    int sum = 0;
    for (int value : array.getData()) {
      sum += value;
    }

    IntArrayParameters params = new IntArrayParameters(min, max, sum, average);

    Warehouse.getInstance().putParameters(array.getIntArrayId(), params);
    log.info(
            "Updated parameters for array id={} -> min={}, max={}, sum={}, average={}",
            array.getIntArrayId(), min, max, sum, average
    );
  }
}
