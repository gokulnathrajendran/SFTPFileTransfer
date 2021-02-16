package com.transamerica.fileTransfer.SFTPFileTransfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SftpFileTransferApplication {

	public static void main(String[] args) {
		SpringApplication.run(SftpFileTransferApplication.class, args);
		runAsService();
	}

	private static synchronized void runAsService(){
		while(true){
			try{
				//TODO: change it to days.
				TimeUnit.MINUTES.sleep(1);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}

}
