package com.cluster.node.timer;

import java.io.PrintWriter;

/**
 * @author: yp
 * @date: 2024/7/8 15:51
 * @description:
 */
public interface Describer {

    void describe(final Printer out);

    interface Printer {

        /**
         * Prints an object.
         *
         * @param x The <code>Object</code> to be printed
         * @return this printer
         */
        Printer print(final Object x);

        /**
         * Prints an Object and then terminates the line.
         *
         * @param x The <code>Object</code> to be printed.
         * @return this printer
         */
        Printer println(final Object x);
    }

    class DefaultPrinter implements Printer {

        private final PrintWriter out;

        public DefaultPrinter(PrintWriter out) {
            this.out = out;
        }

        @Override
        public Printer print(final Object x) {
            this.out.print(x);
            return this;
        }

        @Override
        public Printer println(final Object x) {
            this.out.println(x);
            return this;
        }
    }
}

