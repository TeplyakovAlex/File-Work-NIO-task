package service;

import utils.Constants;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReadService {
    public String readFile (String name) throws IOException {
        Path path = Paths.get(Constants.BASE_PATH_READ +
                name + ".txt");
// Відкриваємо канал через Path.
        FileChannel channel = FileChannel.open(path);
        // Визначається буфер.
        // Метод allocate() створить екземпляр буферу
        // і виділить простір із певною місткістю.
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        // Метод read() зчитує дані
        // з FileChannel в буфер.
        channel.read(byteBuffer);

        byte[] byteArray = byteBuffer.array();
        // Закриваємо канал.
        channel.close();

        return new String(byteArray).trim();
    }
}
