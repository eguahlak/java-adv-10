package dk.cphbusiness.stream;

import java.util.function.Consumer;

public interface Stream<S> {
  
  void forEach(Consumer<S> consumer);
  
  }
