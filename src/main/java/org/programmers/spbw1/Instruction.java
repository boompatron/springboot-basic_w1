package org.programmers.spbw1;

import org.springframework.expression.spel.ast.Operator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Instruction {
    INSERT("insert"),
    LIST("list"),
    EXIT("exit");

    private final String name;
    Instruction(String name) {
        this.name = name;
    }

    private static final Map<String, Instruction> map =
            Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(
                    Instruction::getName, Function.identity()
            )));

    public String getName(){
        return name;
    }
}
