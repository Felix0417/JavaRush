package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class BotClient extends Client {

    @Override
    protected String getUserName() {
        return "date_bot_" + ((int) (Math.random() * 100));
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);

            String userNameDelimiter = ": ";
            String[] splitMessage = message.split(userNameDelimiter);
            if (splitMessage.length != 2) return;


            Calendar calendar = new GregorianCalendar();
            SimpleDateFormat simpleDateFormat = null;
            String format = splitMessage[1];
            String patternOfSimpleDataFormat = null;

            switch (format){
                case "дата":
                    patternOfSimpleDataFormat = "d.MM.YYYY";
                    break;
                case "день":
                    patternOfSimpleDataFormat = "d";
                    break;
                case "месяц":
                    patternOfSimpleDataFormat = "MMMM";
                    break;
                case "год":
                    patternOfSimpleDataFormat = "YYYY";
                    break;
                case "время":
                    patternOfSimpleDataFormat = "H:mm:ss";
                    break;
                case "час":
                    patternOfSimpleDataFormat = "H";
                    break;
                case "минуты":
                    patternOfSimpleDataFormat = "m";
                    break;
                case "секунды":
                    patternOfSimpleDataFormat = "s";
                    break;
            }


            if (patternOfSimpleDataFormat != null) {
                simpleDateFormat = new SimpleDateFormat(patternOfSimpleDataFormat);
                sendTextMessage("Информация для " + splitMessage[0] + ": " + simpleDateFormat.format(calendar.getTime()));
            }
        }
    }

    public static void main(String[] args) {
        new BotClient().run();


    }
}
