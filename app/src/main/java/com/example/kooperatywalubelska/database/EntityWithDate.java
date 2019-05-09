package com.example.kooperatywalubelska.database;

import java.util.Date;

public interface EntityWithDate {
    Date getLastRefresh();

    void setLastRefresh(Date lastRefresh);
}
