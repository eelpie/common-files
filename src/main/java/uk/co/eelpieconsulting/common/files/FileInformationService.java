package uk.co.eelpieconsulting.common.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import uk.co.eelpieconsulting.common.files.model.FileInformation;

public class FileInformationService {

	public List<FileInformation> makeFileInformationForFiles(List<File> files) throws FileNotFoundException, IOException {
		final List<FileInformation> filesInformation = new ArrayList<FileInformation>();
		for (File file : files) {
			filesInformation.add(getFileInformation(file));			
		}
		return filesInformation;
	}
	
	public FileInformation getFileInformation(final File file) throws FileNotFoundException, IOException {
		return new FileInformation(file.getName(),
				new Date(file.lastModified()), 
				DigestUtils.md5Hex(new FileInputStream(file)));
	}
	
}
