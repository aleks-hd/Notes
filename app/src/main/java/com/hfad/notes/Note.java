package com.hfad.notes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Note  {
    private String nameNote;
    private String DescriptionNotes;
    private int dateCreateNotes;






    public String getNameNote() {
        return nameNote;
    }

    public void setNameNote(String nameNote) {
        this.nameNote = nameNote;
    }

    public String getDescriptionNotes() {
        return DescriptionNotes;
    }

    public void setDescriptionNotes(String descriptionNotes) {
        DescriptionNotes = descriptionNotes;
    }

    public int getDateCreateNotes() {
        return dateCreateNotes;
    }

    public void setDateCreateNotes(int dateCreateNotes) {

        this.dateCreateNotes = dateCreateNotes;
    }


}
