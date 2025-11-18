package com.bohush.ft.repository;
import com.bohush.ft.entity.IntArray;
import com.bohush.ft.observer.IntArrayObserver;
import com.bohush.ft.observer.impl.IntArrayObserverImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;

public class IntArrayRepository {

  private static final Logger log = LogManager.getLogger(IntArrayRepository.class);
  private static IntArrayRepository instance;
  private final IntArrayObserver observer = new IntArrayObserverImpl();
  private List<IntArray> arrays = new ArrayList<>();

  private IntArrayRepository() {}
  public static IntArrayRepository getInstance() {
    if (instance == null) {
      instance = new IntArrayRepository();
      log.info("Repository created");
    }
    return instance;
  }

  public boolean add(IntArray array) {
    boolean result = arrays.add(array);
    if (result) {
      array.attach(observer);
    }
    log.info("Add operation for array {} completed successfully: {}", array, result);
    return result;
  }

  public boolean remove(IntArray o) {
    boolean result = arrays.remove(o);
    if (result) {
      o.detach(observer);
    }
    log.info("Remove operation for object {} completed successfully: {}", o, result);
    return result;
  }


  public void sort(Comparator<? super IntArray> c) {
      arrays.sort(c);
      log.info("Sort operation completed successfully.");
  }

  public void clear() {
    arrays.clear();
    log.info("Repository cleared");
  }

  public List<IntArray> query(Specification specification) {
    List<IntArray> list = new ArrayList<>();

    for (IntArray current : arrays) {
      if (specification.specify(current)) {
        list.add(current);
      }
    }
    log.info("Query finished");
    return list;
  }
}
