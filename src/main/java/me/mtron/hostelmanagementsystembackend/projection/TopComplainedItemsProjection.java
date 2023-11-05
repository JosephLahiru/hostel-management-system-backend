package me.mtron.hostelmanagementsystembackend.projection;

public interface TopComplainedItemsProjection {
    String getItem_code();

    void setItem_code(String item_code);

    String getProp_name();

    void setProp_name(String prop_name);

    int getComplaint_count();

    void setComplaint_count(int complaint_count);
}
