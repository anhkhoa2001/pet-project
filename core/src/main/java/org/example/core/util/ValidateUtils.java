package org.example.core.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.List;

@Slf4j
public class ValidateUtils {

    public static boolean isNull(Collection input) {
        return input == null || input.isEmpty();
    }

    public static boolean isNotNull(Collection input) {
        return !isNull(input);
    }

}
