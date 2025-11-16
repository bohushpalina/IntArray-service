package com.ivanov.first.observer.impl;

import com.ivanov.first.entity.IntArray;
import com.ivanov.first.observer.IntArrayEvent;
import com.ivanov.first.observer.IntArrayObserver;
import com.ivanov.first.service.IntArrayService;
import com.ivanov.first.service.impl.IntArrayServiceImpl;
import com.ivanov.first.warehouse.IntArrayParameters;
import com.ivanov.first.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntArrayObserverImpl implements IntArrayObserver {

  private static final Logger log = LogManager.getLogger(IntArrayObserverImpl.class);
  private IntArrayService service = new IntArrayServiceImpl();

  @Override
  public void arrayUpdated(IntArrayEvent event) {
    IntArray array = event.getIntArray();
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
