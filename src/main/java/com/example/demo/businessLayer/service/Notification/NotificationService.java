package com.example.demo.businessLayer.service.Notification;

import com.example.demo.businessLayer.service.Notification.Director.Director;
import com.example.demo.businessLayer.service.Notification.Product.ButtonDiv;
import com.example.demo.businessLayer.service.Notification.Product.DivDiv;
import com.example.demo.businessLayer.service.Notification.Product.SpanDiv;
import com.example.demo.businessLayer.service.Notification.Product.StrongDiv;
import com.example.demo.businessLayer.to.NotificationTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NotificationService implements INotification {

    @Autowired
    Director director;

    @Override
    public StringBuilder GenerateTags(List<NotificationTO> notifications) {
        DivDiv firstDiv = new DivDiv();
        firstDiv.role = "alert";
        firstDiv.ariaLive = "assertive";
        firstDiv.ariaAtomic = "true";
        firstDiv.classes = "toast show m-5";
        firstDiv.dataAutoHide = "false";
        firstDiv.style = "float:right;";

        DivDiv secondDiv = new DivDiv();
        secondDiv.classes = "toast-header";
        secondDiv.id = "timeline-toast-Header";
        secondDiv.style = "color: white;background: green;";

        StrongDiv firstStrongDiv = new StrongDiv();
        firstStrongDiv.classes = "mr-auto";

        ButtonDiv buttonDiv = new ButtonDiv();
        buttonDiv.ariaLable = "Close";
        buttonDiv.className = "ml-2 mb-1 close";
        buttonDiv.dataDismiss = "toast";
        buttonDiv.type = "button";

        SpanDiv spanDiv = new SpanDiv();
        spanDiv.ariaHidden = "true";

        DivDiv thirdDiv = new DivDiv();
        thirdDiv.classes = "toast-body";
        thirdDiv.id = "timeline-toast-Body";
        thirdDiv.style = "color: white;background: green;";

        return director.generateHtml(firstDiv, secondDiv, firstStrongDiv, buttonDiv, spanDiv, thirdDiv);
    }

    @Override
    public StringBuilder convertToScript(StringBuilder htmlString) {
        return director.convertToScript(htmlString);
    }
}
