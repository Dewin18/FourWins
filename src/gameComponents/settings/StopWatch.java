package gameComponents.settings;

public class StopWatch
{
    private long nextSecondsRecording = 0;
    private long elapsedTime = 0;
    private long firstSecondsRecording;
    
    private long seconds = 0;
    private long minutes = 0;
    private long hours = 0;

    public String getElapsedTime()
    {
        check_60_Seconds();
        check_60_Minutes();
        
        String seconds = getTimeString(this.seconds);
        String minutes = getTimeString(this.minutes);
        String hours = getTimeString(this.hours);
        
        return hours + ":" + minutes + ":" + seconds;
    }

    private void check_60_Seconds()
    {
        if(this.seconds >= 60)
        {
            this.seconds = 0;
            this.minutes++;
        }
    }
    
    private void check_60_Minutes()
    {
        if(this.minutes >= 60)
        {
            this.minutes = 0;
            this.hours++;
        }
    }

    private String getTimeString(long time)
    {
        String timeText = (time < 10) ? "0" + time : String.valueOf(time);
        
        return timeText;
    }

    public void updateElapsedTime()
    {
        firstSecondsRecording = elapsedTime;
        elapsedTime = System.nanoTime() / 1000000000 % 10;
        nextSecondsRecording = elapsedTime;

        if (secondsHaveChanged())
        {
            seconds++;
        }
    }

    private boolean secondsHaveChanged()
    {
        return firstSecondsRecording != nextSecondsRecording;
    }
}
