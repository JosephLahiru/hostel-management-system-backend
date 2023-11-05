package me.mtron.hostelmanagementsystembackend.models;

public class TopComplainedItems {
    String item_code;
    String prop_name;
    int complaint_count;

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public String getProp_name() {
        return prop_name;
    }

    public void setProp_name(String prop_name) {
        this.prop_name = prop_name;
    }

    public int getComplaint_count() {
        return complaint_count;
    }

    public void setComplaint_count(int complaint_count) {
        this.complaint_count = complaint_count;
    }
}
