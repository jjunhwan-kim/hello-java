package com.example.hellojava;

import java.util.Optional;

public class OnlineClass {

    private Integer id;
    private String title;
    private boolean closed;
    public Progress progress;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Optional<Progress> getProgress() {
        /*
        if (this.progress == null) {
            throw new IllegalStateException();
        }
        // Optional이 생기기 전에는 null이 리턴될 경우 예외를 던지거나, null을 리턴하여 클라이언트 코드에서 null을 체크함
        // Optional이 생긴 이후에는 Optional을 리턴함
        */
        return Optional.ofNullable(progress);
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}
