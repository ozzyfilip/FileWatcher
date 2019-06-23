import java.io.File;

public class FileWatcher extends Thread {


    File file;
    boolean flag;
    long delay;

    @Override
    public void run() {
        while(!flag){
            if(file.canRead()) flag = true;
            System.out.println(":(");
        }

        try {
            this.sleep(delay);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }

    public FileWatcher(String path, long delay) {
        file = new File(path);
        flag = false;
        this.delay = delay;
    }


    public static void main(String[] args) {
        FileWatcher fileWatcher = new FileWatcher("tester/test123",50L);
        Tester test = new Tester(fileWatcher);
        fileWatcher.start();
        test.start();
    }

}
