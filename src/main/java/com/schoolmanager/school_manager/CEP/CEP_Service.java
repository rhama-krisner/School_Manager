package com.schoolmanager.school_manager.CEP;

import com.google.gson.Gson;
import com.schoolmanager.school_manager.exceptions.ResourceNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CEP_Service {
    static String webService = "https://viacep.com.br/ws/";
    static int successCode = 200;

    public static Endereco buscaEndereco(String cep) {
        String urlChamada = webService + cep + "/json";

        try {
            URL url = new URL(urlChamada);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if (connection.getResponseCode() != successCode) {
                throw new ResourceNotFoundException("HTTP CODE: ERROR " + connection.getResponseCode());
            }

            BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String jsonEmString = ConversorStringJson.converteJsonEmString(response);
            Gson gson = new Gson();
            Endereco endereco = gson.fromJson(jsonEmString, Endereco.class);

            return endereco;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
