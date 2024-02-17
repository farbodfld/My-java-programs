import java.io.File;
        import java.io.FileReader;
        import java.io.IOException;
        import java.io.RandomAccessFile;

public class RanomAccessFiletesting {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("C:\\Users\\lenovo\\IdeaProjects\\test10\\file2.txt","rw");
        file.seek(5);
        long pointer = file.getFilePointer();
        file.write("fld".getBytes());
        file.close();
        System.out.println(pointer);
    }
}
