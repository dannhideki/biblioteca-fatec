package br.gov.sp.centropaulasouza.biblioteca.utils.security;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author hideki
 */
public class GenerateValidation {

    public static String keyValidation() {

        UUID uuid = UUID.randomUUID();
        return uuid.toString().toUpperCase().replace('-', 'X')
                + String.valueOf((new Date()).getTime());
    }
}
