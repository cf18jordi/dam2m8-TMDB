package com.example.fragments.Model.List;

public class ListResponse {
    boolean success;
    int statusC;
    int listID;
    String statusM;

    public ListResponse(boolean success, int statusC, int listID, String statusM) {
            this.success = success;
            this.statusC = statusC;
            this.listID = listID;
            this.statusM = statusM;
    }
}

