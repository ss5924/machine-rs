package me.songha.rs.machiners.util;

public interface Converter<D, E> {
    D convertToDto(E entity);
    E convertToEntity(D dto);
}