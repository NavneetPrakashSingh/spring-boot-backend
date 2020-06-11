package com.example.demo.businessLayer.service.Notification.Features;


import com.example.demo.businessLayer.service.Notification.Product.StrongDiv;

public class Strong {
    public String generateStrongOpeningTag(StrongDiv strongProperties) {
        StringBuilder str = new StringBuilder();
        return "<strong class=\"" + strongProperties.classes + "\">";
    }

    public String generateStrongClosingTag() {
        return "</span>";
    }

}
