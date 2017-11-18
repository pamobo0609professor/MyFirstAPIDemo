
package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Rain {

    @SerializedName("3h")
    @Expose
    private int _3h;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Rain() {
    }

    /**
     * 
     * @param _3h
     */
    public Rain(int _3h) {
        super();
        this._3h = _3h;
    }

    public int get3h() {
        return _3h;
    }

    public void set3h(int _3h) {
        this._3h = _3h;
    }

}
