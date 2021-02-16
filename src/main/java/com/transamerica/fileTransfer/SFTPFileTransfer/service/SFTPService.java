package com.transamerica.fileTransfer.SFTPFileTransfer.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SFTPService {

    public void downloadAndProcessFile(String fileContent, Map<String,Object> header){
        System.out.println("File: "+ header.get("fileName")+" | Content: " + fileContent + "|");
    }
}
