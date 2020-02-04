package ru.tobacco;

import java.util.function.Consumer;

public interface BOParameterSource<T> {
  T getValue();
  String getKey();
  void onEventChange(T newValue);
  void addListener(Consumer<T> listener);
}
