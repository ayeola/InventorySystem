/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.controller;

import java.util.logging.*;
import java.util.Locale;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Abiodun.Ayeola
 */
public class CustomLogFormatter extends Formatter {

    private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");

    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder(1000);
        builder.append(df.format(new Date(record.getMillis()))).append(" - ");
        builder.append("[").append(record.getSourceClassName()).append(".");
        builder.append(record.getSourceMethodName()).append("] - ");
        builder.append("[").append(record.getLevel()).append("] - ");
        builder.append(formatMessage(record));        
        builder.append("\n");
        return builder.toString();
    }

    @Override
    public String getHead(Handler h) {
        return super.getHead(h);
    }

    @Override
    public String getTail(Handler h) {
        return super.getTail(h);
    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(CustomLogFormatter.class.getName());
        logger.setUseParentHandlers(false);

        CustomLogFormatter formatter = new CustomLogFormatter();
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(formatter);

        logger.addHandler(handler);
        logger.info("Example of creating custom formatter.");
        logger.warning("A warning message.");
        logger.severe("A severe message.");
    }
}
