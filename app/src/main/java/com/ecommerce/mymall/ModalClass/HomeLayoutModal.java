package com.ecommerce.mymall.ModalClass;

import java.util.List;

public class HomeLayoutModal {

    private int type;

    ///slider list
    private List<slider_model> slideriteamslist;

    public HomeLayoutModal(int type, List<slider_model> slideriteamslist) {
        this.type = type;
        this.slideriteamslist = slideriteamslist;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<slider_model> getSlideriteamslist() {
        return slideriteamslist;
    }

    public void setSlideriteamslist(List<slider_model> slideriteamslist) {
        this.slideriteamslist = slideriteamslist;
    }
    ///slider list
}
