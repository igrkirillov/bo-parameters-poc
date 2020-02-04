package ru.tobacco;

public interface BOParameterSource<T> {
  T getValue();
  String getKey();
  void onEventChange();
}
