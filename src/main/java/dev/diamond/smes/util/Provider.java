package dev.diamond.smes.util;

@FunctionalInterface
public interface Provider<T> {
    T provide();
}
