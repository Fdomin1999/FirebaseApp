package com.example.firebaseapp;


public class Equipo {

    public String uid;
    public String team;
    public String teamPhotoUrl;
    public String content;

    public Equipo(){}

    public Equipo(String uid, String team, String teamPhotoUrl, String content){
        this.uid = uid;
        this.team = team;
        this.teamPhotoUrl = teamPhotoUrl;
        this.content = content;

    }
}
