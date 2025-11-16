package com.ivanov.first.repository;
import com.ivanov.first.entity.IntArray;
import com.ivanov.first.observer.IntArrayObserver;
import com.ivanov.first.observer.impl.IntArrayObserverImpl;
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
    array.attach(observer);
    if (result) {
      log.info("Successfully added array: {}", array);
    } else {
      log.info("Failed to add array: {}", array);
    }
    return result;
  }

  public boolean remove(IntArray o) {
    boolean result = arrays.remove(o);
    o.detach(observer);
    if (result) {
      log.info("Successfully removed object: {}", o);
    } else {
      log.info("Object not found for removal: {}", o);
    }
    return result;
  }

  public void sort(Comparator<? super IntArray> c) {
      arrays.sort(c);
      log.info("Sort operation completed successfully.");
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
