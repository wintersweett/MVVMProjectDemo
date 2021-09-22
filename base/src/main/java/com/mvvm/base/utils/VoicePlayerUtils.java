package com.mvvm.base.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 用于语音播放的工具类
 */
public class VoicePlayerUtils implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener {

    public MediaPlayer mediaPlayer;
    private Context mContext;

    private boolean isCompletion = false;
    private boolean isPrepared = false;
    private int currVolume = 0;

    private OnVoicePlayFinsh mVoicePlayFinsh;

    public VoicePlayerUtils(Context context){
        this.mContext = context;
    }

    public boolean isPlaying() {
        if (mediaPlayer == null){
            return false;
        }
        return mediaPlayer.isPlaying();
    }

    /**
     * 获取url的音频时长
     */
    public int getUrlVoiceLongTime(String audioUrl){
        int s = 0;
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(audioUrl);
            mediaPlayer.prepare();
            int duration = mediaPlayer.getDuration();
            if (0 != duration) {
                s = duration / 1000;
                //记得释放资源
                mediaPlayer.release();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 播放语音
     * @param videoUrl
     */
    public void playUrl(String videoUrl) {
        try {
            isCompletion = false;
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnCompletionListener(this);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.reset();
            mediaPlayer.setDataSource(videoUrl);
            if(mediaPlayer !=null) {
                mediaPlayer.prepare();
                mediaPlayer.start();
            }
        } catch (IllegalArgumentException | IllegalStateException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 播放语音
     * @param videoUrl
     */
    public void playFileUrl(String videoUrl) {
        try {
            File file = new File(videoUrl);
            FileInputStream fis = new FileInputStream(file);
            isCompletion = false;
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnCompletionListener(this);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.reset();
            mediaPlayer.setDataSource(fis.getFD());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IllegalArgumentException | IllegalStateException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 播放
     */
    public void play() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    /**
     * 重播
     */
    public void replay() {
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(0);
        }
    }

    /**
     * 暂停
     */
    public void pause() {
        if (mediaPlayer != null){
            mediaPlayer.pause();
        }
    }

    public void stop() {
        if (mediaPlayer != null) {
            try{
                mediaPlayer.stop();
            }catch (Exception e){
                e.printStackTrace();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    /**
     * 是否准备完毕
     */
    public boolean isPrepared() {
        return isPrepared;
    }

    /**
     * 是否播放完毕
     */
    public boolean isCompletion() {
        return isCompletion;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        isCompletion = true;
        mVoicePlayFinsh.onVoicePlayFinsh();
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        isPrepared = true;
    }

    public void setVoicePlayFinsh(OnVoicePlayFinsh voicePlayFinsh){
        this.mVoicePlayFinsh = voicePlayFinsh;
    }

    public interface OnVoicePlayFinsh{
        void onVoicePlayFinsh();
    }

}
