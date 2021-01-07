package com.github.mcnagatuki.realminecraft.commands;

import java.util.Optional;

public class CommandArgsParser {
    public static boolean hasTilde(String ipt) {
        return ipt.equalsIgnoreCase("~");
    }

    public static int positionToBlockPosition(double pos) {
        int i = (int) pos;
        return pos < i ? i - 1 : i;
    }

    // 整数の判定
    public static boolean isInteger(String ipt) {
        return ipt.matches("^-?([1-9]\\d*|0)$");
    }

    // 浮動小数の判定
    public static boolean isDouble(String ipt) {
        return ipt.matches("^-?([1-9]\\d*|0)?\\.\\d*")
                && !ipt.equalsIgnoreCase(".")
                && !ipt.equalsIgnoreCase("-.");
    }

    // 自然数（ただし0を含まない）の判定
    public static boolean isNaturalNumber(String ipt) {
        return ipt.matches("^[1-9][0-9]*$");
    }

    // 数かどうか判定
    public static boolean isNumber(String ipt) {
        return isInteger(ipt) || isDouble(ipt);
    }

    // 座標の引数を解決してブロック座標の絶対値を取得するメソッド
    public static Optional<Integer> parsePosArgToBlockPos(String arg, double base) {
        if (arg.startsWith("~")) {
            if (arg.length() == 1) {
                return Optional.of(positionToBlockPosition(base));
            }

            if (isNumber(arg.substring(1))) {
                return Optional.of(positionToBlockPosition(base + Double.parseDouble(arg.substring(1))));
            }
        }

        if (isNumber(arg)) {
            return Optional.of(positionToBlockPosition(Double.parseDouble(arg)));
        }

        return Optional.empty();
    }
}