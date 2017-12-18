package it.scp.patterns.adapter;

public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc"))
            advancedMediaPlayer = new VlcPlayer();
        if (audioType.equalsIgnoreCase("mp4"))
            advancedMediaPlayer = new Mp4Player();
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc"))
            advancedMediaPlayer.playVlc(fileName);
        if (audioType.equalsIgnoreCase("mp4"))
            advancedMediaPlayer.playMp4(fileName);
    }
}
