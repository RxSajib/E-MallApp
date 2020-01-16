package com.ecommerce.mymall.ModalClass;

import java.util.List;

public class HomePageModal {

    private int type;
    public static final int BANNERSLIDER = 1;

    /// bannerslider modal
    private List<slider_model> slideriteamslist;

    public HomePageModal(int type, List<slider_model> slideriteamslist) {
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
    /// bannerslider modal
}
