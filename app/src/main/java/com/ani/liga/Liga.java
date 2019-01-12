package com.ani.liga;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class Liga implements Parcelable {
    String idTeam = "idTeam";
    String idSoccerXML = "idSoccerXML";
    String strTeam = "strTeam";
    String strAlternate = "strAlternate";
    String intFormedYear = "intFormedYear";
    String strLeague = "strLeague";
    String idLeague = "idLeague";
    String strStadiumThumb = "strStadiumThumb";
    String strStadiumLocation = "strStadiumLocation";
    String strWebsite = "strWebsite";
    String strDescriptionEN = "strDescriptionEN";
    String strTeamBadge = "strTeamBadge";
    String strTeamLogo = "strTeamLogo";

    protected Liga(Parcel in) {
        this.idTeam = in.readString();
        this.idSoccerXML = in.readString();
        this.strTeam = in.readString();
        this.strAlternate = in.readString();
        this.intFormedYear = in.readString();
        this.strLeague = in.readString();
        this.idLeague = in.readString();
        this.strStadiumThumb = in.readString();
        this.strStadiumLocation = in.readString();
        this.strWebsite = in.readString();
        this.strDescriptionEN = in.readString();
        this.strTeamBadge = in.readString();
        this.strTeamLogo = in.readString();
    }

    public static final Creator<Liga> CREATOR = new Creator<Liga>() {
        @Override
        public Liga createFromParcel(Parcel sources) {
            return new Liga(sources);
        }

        @Override
        public Liga[] newArray(int size) {
            return new Liga[size];
        }
    };

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getIdSoccerXML() {
        return idSoccerXML;
    }

    public void setIdSoccerXML(String idSoccerXML) {
        this.idSoccerXML = idSoccerXML;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrAlternate() {
        return strAlternate;
    }

    public void setStrAlternate(String strAlternate) {
        this.strAlternate = strAlternate;
    }

    public String getIntFormedYear() {
        return intFormedYear;
    }

    public void setIntFormedYear(String intFormedYear) {
        this.intFormedYear = intFormedYear;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    public String getStrStadiumThumb() {
        return strStadiumThumb;
    }

    public void setStrStadiumThumb(String strStadiumThumb) {
        this.strStadiumThumb = strStadiumThumb;
    }

    public String getStrStadiumLocation() {
        return strStadiumLocation;
    }

    public void setStrStadiumLocation(String strStadiumLocation) {
        this.strStadiumLocation = strStadiumLocation;
    }

    public String getStrWebsite() {
        return strWebsite;
    }

    public void setStrWebsite(String strWebsite) {
        this.strWebsite = strWebsite;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getStrTeamLogo() {
        return strTeamLogo;
    }

    public void setStrTeamLogo(String strTeamLogo) {
        this.strTeamLogo = strTeamLogo;
    }
    public  Liga (JSONObject obj ) {
        try {
            String idTeam = obj.getString("idTeam");
            String idSoccerXML = obj.getString( "idSoccerXML");
            String strTeam = obj.getString( "strTeam");
            String strAlternate = obj.getString( "strAlternate");
            String intFormedYear = obj.getString( "intFormedYear");
            String strLeague = obj.getString( "strLeague");
            String idLeague = obj.getString( "idLeague");
            String strStadiumThumb = obj.getString( "strStadiumThumb");
            String strStadiumLocation = obj.getString( "strStadiumLocation");
            String strWebsite = obj.getString( "strWebsite");
            String strDescriptionEN = obj.getString( "strDescriptionEN");
            String strTeamBadge = obj.getString( "strTeamBadge");
            String strTeamLogo = obj.getString( "strTeamLogo");

            this.idTeam = idTeam;
            this.idSoccerXML = idSoccerXML;
            this.strTeam = strTeam;
            this.strAlternate = strAlternate;
            this.intFormedYear = intFormedYear;
            this.strLeague = strLeague;
            this.idLeague = idLeague;
            this.strStadiumThumb = strStadiumThumb;
            this.strStadiumLocation = strStadiumLocation;
            this.strWebsite = strWebsite;
            this.strDescriptionEN = strDescriptionEN;
            this.strTeamBadge = strTeamBadge;
            this.strTeamLogo = strTeamLogo;
        } catch (Exception e) {
            e.printStackTrace();
        }

}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idTeam);
        dest.writeString(idSoccerXML);
        dest.writeString(strTeam);
        dest.writeString(strAlternate);
        dest.writeString(intFormedYear);
        dest.writeString(strLeague);
        dest.writeString(idLeague);
        dest.writeString(strStadiumThumb);
        dest.writeString(strStadiumLocation);
        dest.writeString(strWebsite);
        dest.writeString(strDescriptionEN);
        dest.writeString(strTeamBadge);
        dest.writeString(strTeamLogo);

    }
    Liga ( ) {}
}
