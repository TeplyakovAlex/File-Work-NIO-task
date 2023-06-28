package service;

import utils.Constants;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriteService {
    public String writeFile(String text,String name){

        try {
        Path path = Paths.get(Constants.BASE_PATH_READ + name + ".txt");

            // Масив байтів
            byte[] contentBytes = text.getBytes();
            // Метод wrap() дозволяє екземпляру
            // повторно використовувати існуючий масив байтів.
            // Концептуально клас ByteBuffer — це масив байтів,
            // загорнутий всередину об’єкта.
            ByteBuffer byteBuffer = ByteBuffer.wrap(contentBytes);
            // Відкриваємо канал
            FileChannel channel = FileChannel.open(path, StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE);
            channel.write(byteBuffer);
            // Закриваємо канал.
            channel.close();
        } catch (IOException e) {
            return "Exception: " + e.getMessage();
        }
        return "The content has been written.";
    }
}
