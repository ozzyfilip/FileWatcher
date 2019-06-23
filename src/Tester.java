public class Tester extends Thread {
    FileWatcher fileWatcher;
    boolean startThisRave;
    Music music = new Music();


    public Tester(FileWatcher fileWatcher) {
        this.fileWatcher = fileWatcher;
        startThisRave = false;
    }

    @Override
    public void run() {
        while (!fileWatcher.flag) {

            try {
                this.sleep(50L);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

        startThisRave = true;
        music.playMusic();
        System.out.println("YEA BOII");
        try {
            sleep(18000L);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
