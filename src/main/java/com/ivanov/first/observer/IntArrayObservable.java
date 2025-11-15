package com.ivanov.first.observer;

public interface IntArrayObservable {
  void attach(IntArrayObserver observer);
  void detach(IntArrayObserver observer);
  void notifyObservers();
}
