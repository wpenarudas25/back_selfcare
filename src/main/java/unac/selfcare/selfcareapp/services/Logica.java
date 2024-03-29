package unac.selfcare.selfcareapp.services;

import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;


@Data
@NoArgsConstructor
public class Logica {

    private final String BAJA_CAA = "BAJA";
    private final String MEDIA_CAA = "MEDIA";
    private final String ALTA_CAA = "ALTA";
    private final String LEVE_RCV = "LEVE";
    private final String MODERADO_RCV = "MODERADO";
    private final String SEVERO_RCV = "SEVERO";

    private final String AMARILLO = "AMARILLO";
    private final String NARANJA = "NARANJA";
    private final String ROJO = "ROJO";
    private final String VERDE = "VERDE";

    ArrayList<Integer> respuestasCaa;
    ArrayList<Integer> respuestasRcv;

    String calcularCaa(ArrayList<Integer> respuestasCaa) {

        int sum = 0;
        for (int i : respuestasCaa)
            sum += i;

        if (sum >= 17 && sum <= 28)
            return BAJA_CAA;
        if (sum >= 29 && sum <= 56)
            return MEDIA_CAA;
        if (sum >= 57 && sum <= 85)
            return ALTA_CAA;
        return "El resultado no es válido";
    }

    String calcularRcv(ArrayList<Integer> respuestasRcv) {

        int sum = 0;
        for (int i : respuestasRcv)
            sum += i;

        if (sum < 10)
            return LEVE_RCV;
        if (sum <= 20)
            return MODERADO_RCV;
        return SEVERO_RCV;
    }

    String getDx(String resultadoCaa, String resultadoRcv) {

        if (resultadoCaa.equals(BAJA_CAA) && resultadoRcv.equals(LEVE_RCV)) {
            return BAJA_CAA +" / "+ LEVE_RCV +" / "+ AMARILLO;
        } else if (resultadoCaa.equals(BAJA_CAA) && resultadoRcv.equals(MODERADO_RCV)) {
            return BAJA_CAA +" / "+ MODERADO_RCV +" / "+ NARANJA;
        } else if (resultadoCaa.equals(BAJA_CAA) && resultadoRcv.equals(SEVERO_RCV)) {
            return BAJA_CAA +" / "+ SEVERO_RCV +" / "+ ROJO;
        } else if (resultadoCaa.equals(MEDIA_CAA) && resultadoRcv.equals(LEVE_RCV)) {
            return MEDIA_CAA +" / "+ LEVE_RCV +" / "+ VERDE;
        } else if (resultadoCaa.equals(MEDIA_CAA) && resultadoRcv.equals(MODERADO_RCV)) {
            return MEDIA_CAA +" / "+ MODERADO_RCV +" / "+ NARANJA;
        } else if (resultadoCaa.equals(MEDIA_CAA) && resultadoRcv.equals(SEVERO_RCV)) {
            return MEDIA_CAA +" / "+ SEVERO_RCV +" / "+ ROJO;
        } else if (resultadoCaa.equals(ALTA_CAA) && resultadoRcv.equals(LEVE_RCV)) {
            return ALTA_CAA +" / "+ LEVE_RCV +" / "+ VERDE;
        } else if (resultadoCaa.equals(ALTA_CAA) && resultadoRcv.equals(MODERADO_RCV)) {
            return ALTA_CAA +" / "+ MODERADO_RCV +" / "+ AMARILLO;
        } else if (resultadoCaa.equals(ALTA_CAA) && resultadoRcv.equals(SEVERO_RCV)) {
            return ALTA_CAA +" / "+ SEVERO_RCV +" / "+ NARANJA;
        }
        return "Resultados inválidos.";
    }
}
