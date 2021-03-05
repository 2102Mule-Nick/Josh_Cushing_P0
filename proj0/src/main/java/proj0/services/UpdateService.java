package proj0.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;

import proj0.pojo.UserAcct;


public class UpdateService {
	Kryo kryo = new Kryo();
	final String FOLDER_NAME = "accts\\";
	final String FILE_EXTENSION = ".dat";
	
	public void updateUser(UserAcct userAcct) {
		//Initialize fop to null so Java doesn't shout at me.
		FileOutputStream fop = null;
		Output output = null;
		
		//Formatting note 1: an example file should be called something like 123.John.Password.dat inside the accts folder.
		
		//Formatting note 2: I can find no functional difference between FOLDER_NAME = "accts\\" and FOLDER_NAME = "accts/".
		//So for now don't worry about it.
		File file = new File(FOLDER_NAME + userAcct.getUserId() + userAcct.getUserName() + userAcct.getPassWord() + FILE_EXTENSION);
		if(file.exists()) {
			//Try this out...
			try {
				//Try to write a .dat file for the new user.
				fop = new FileOutputStream(FOLDER_NAME + userAcct.getUserId() + userAcct.getUserName() + userAcct.getPassWord() + FILE_EXTENSION);
				output = new Output(fop);
				kryo.writeObject(output, userAcct);
			} catch (FileNotFoundException e) {
				//Catch an error
				e.printStackTrace();
			} finally {
				try {
					//Also try to close the stream so we can open the file again later.
					output.close();
					fop.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Your account has been updated " + userAcct.getUserName() + "!");
		}else {
			System.out.println("ERROR: File does not exist.");
		}
	}
	
	//Don't touch this. This registers UserAcct object with Kryo so it can write them.
	public UpdateService() {
		super();
		kryo.register(UserAcct.class);
	}
}
