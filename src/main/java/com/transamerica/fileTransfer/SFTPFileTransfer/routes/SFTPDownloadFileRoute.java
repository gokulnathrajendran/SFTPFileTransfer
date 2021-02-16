package com.transamerica.fileTransfer.SFTPFileTransfer.routes;

import com.transamerica.fileTransfer.SFTPFileTransfer.service.SFTPService;
import org.apache.camel.builder.RouteBuilder;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Component;
import java.net.URI;

@Component
public class SFTPDownloadFileRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        URI fromFtpUrl = new URIBuilder()
                .setScheme("sftp")
                .setHost("127.0.0.1")
                .setPort(9922)
                .setPath("/foo-home")
                .addParameter("username","foo")
                .addParameter("password","pass")
                .addParameter("passiveMode","false")
                .addParameter("antInclude","*movie*")
                .addParameter("delay","50")
                .addParameter("moveFailed","/foo-home/error")
                .addParameter("move","/foo-home/done")
                .addParameter("preMove","/foo-home/in-progress")
                .addParameter("readLock","changed")
                .addParameter("readLockMinAge","1m")
                .addParameter("readLockTimeout","70000")
                .addParameter("readLockCheckInterval","5000")
                .addParameter("stepwise","false")
                .addParameter("useUserKnownHostsFile","false")
                .build();

        from(fromFtpUrl.toString())
                .setHeader("userId").simple("system123")
                .setHeader("fileName").simple("${file:name}")
                .bean(SFTPService.class,"downloadAndProcessFile(${body},${headers})")
                .log("Downloaded file ${file:name} complete")
                .to("file:/System/Volumes/Data/Users/gokulnathrajendran/Documents/GitHub/SFTPFileTransfer/downloaded?noop=true");

    }
}
