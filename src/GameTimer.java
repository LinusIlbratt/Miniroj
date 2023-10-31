public class GameTimer {

    private long startTime;
    private long endTime;

    // Constructor
    public GameTimer(){

    }

    public void startTime(){
        startTime = System.currentTimeMillis();
    }
    public void stopTime(){
        endTime = System.currentTimeMillis();
    }
    public double totalTimeInSeconds() {
        return (endTime - startTime) / 1000.0;
    }
    public String convertSecondsToHMS(double totalSeconds){
        int totalS = (int) totalSeconds;
        int hours = totalS / 3600;
        int remainder = totalS % 3600;
        int minutes = remainder / 60;
        int seconds = remainder % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    public String elapsedTime() {
        double elapseTimeInSeconds = totalTimeInSeconds();
        return convertSecondsToHMS(elapseTimeInSeconds);
    }
}
