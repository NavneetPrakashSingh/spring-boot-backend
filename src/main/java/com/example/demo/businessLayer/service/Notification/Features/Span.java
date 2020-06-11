package com.example.demo.businessLayer.service.Notification.Features;


import com.example.demo.businessLayer.service.Notification.Product.SpanDiv;

public class Span {
    public String generateSpanOpeningDiv(SpanDiv spanProperty) {
        StringBuilder str = new StringBuilder();
//        return str.append("")
        return "<span aria-hidden=\"" + spanProperty.ariaHidden + "\">";
    }

    public String generateSpanClosingDiv() {
        return "</span>";
    }

}
