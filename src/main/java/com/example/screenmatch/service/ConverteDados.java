package com.example.screenmatch.service;

import com.example.screenmatch.model.DadosSerie;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements  IConverteDados{
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
