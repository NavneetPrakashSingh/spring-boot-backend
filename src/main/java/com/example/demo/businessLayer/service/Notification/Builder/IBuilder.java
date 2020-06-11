package com.example.demo.businessLayer.service.Notification.Builder;


import com.example.demo.businessLayer.service.Notification.Product.ButtonDiv;

public interface IBuilder {
    public String appendDivOpeningTag();

    public String appendStrongTag();

    public String appendButtonTag(ButtonDiv button);

    public String appendSpanTag();

    public String appendDivClosingTag();

    public String appendStrongClosingTag();

    public String appendButtonClosingTag(ButtonDiv button);

    public String appendSpanClosingTag();
}
