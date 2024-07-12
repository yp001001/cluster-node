package com.cluster.node.utils;

import java.nio.Buffer;

/**
 * @author: yp
 * @date: 2024/7/5 14:13
 * @description:
 */
public class BufferUtils {

    /**
     * @param buffer byteBuffer
     */
    public static void flip(Buffer buffer) {
        buffer.flip();
    }

    /**
     * @param buffer byteBuffer
     */
    public static void clear(Buffer buffer) {
        buffer.clear();
    }

    /**
     * @param buffer byteBuffer
     */
    public static void limit(Buffer buffer, int newLimit) {
        buffer.limit(newLimit);
    }

    /**
     * @param buffer byteBuffer
     */
    public static void mark(Buffer buffer) {
        buffer.mark();
    }

    /**
     * @param buffer byteBuffer
     */
    public static void position(Buffer buffer, int newPosition) {
        buffer.position(newPosition);
    }

    /**
     * @param buffer byteBuffer
     */
    public static void rewind(Buffer buffer) {
        buffer.rewind();
    }

    /**
     * @param buffer byteBuffer
     */
    public static void reset(Buffer buffer) {
        buffer.reset();
    }

}

