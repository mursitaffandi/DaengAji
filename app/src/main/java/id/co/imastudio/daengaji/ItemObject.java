package id.co.imastudio.daengaji;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by imastudio on 8/19/16.
 */
public class ItemObject {
    /*public String strJudul, strWaktu;

    public ItemObject(String strJudul, String strWaktu) {
        this.strJudul = strJudul;
        this.strWaktu = strWaktu;
    }*/
    @SerializedName("planet")
    public List<Children> listplanet;

    public class Children {
        @SerializedName("planet_icon")
        public String strplanet_icon;

        @SerializedName("planet_name")
        public String strplanet_name;

        @SerializedName("date_created")
        public String strdate_created;

        @SerializedName("header_img")
        public String strheader_img;

        @SerializedName("wiki_site")
        public String strwiki_site;

        @SerializedName("surface_area")
        public String strsurface_area;

        @SerializedName("equator")
        public String strequator;

        @SerializedName("mass")
        public String strmass;

        @SerializedName("volume")
        public String strvolume;

        @SerializedName("description")
        public String strdescription;
    }
}
