package org.bob.cxfrs.beans;

import org.apache.camel.builder.RouteBuilder;

public class EmployeeServiceRouteBuilder extends RouteBuilder {

    public void configure() throws Exception {
        from("cxfrs://bean://restService")
                .process(new EmployeeServiceProcessor())
                .to("sqlComponent:INSERT INTO trainer(trainer_Name) VALUES ('SAM')?dataSource=#myDataSource")
                .setHeader("subject", simple("New incident: ${header.CamelFileName}"))
                .to("smtps:smtp.gmail.com:465?username=GMAILEMAIL&password=GMAILPASSWORD&to=sam.kirk@academytrainee.com&subject=Test&debugMode=true&mail.smtp.auth=true&mail.smtp.starttls.enable=true")
                .to("file:/home/george/?fileName=camelOutput.txt");


    }
}
