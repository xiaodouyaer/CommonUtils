package com.liuchaoya.commonutils.tools;

public class DoubleUtils {
    /**
     * Prevent continuous click, jump two pages
     * 防止手指抖动多次点击
     */
    private static long lastClickTime;
    private final static long TIME = 800;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < TIME) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}
