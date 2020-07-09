package com.restresult.demo.form;

import javax.validation.constraints.Positive;
import java.io.Serializable;

public class HomeidForm implements Serializable {

    @Positive(message = "参数必须为正数")
    private int homeId;

    public int getHomeId() {
        return this.homeId;
    }
    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }
}
