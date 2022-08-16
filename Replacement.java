package me.coley.jremapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileModificationProgram
{
	static void modifyFile(String filePath, String oldString, String newString)
	{
		File fileToBeModified = new File(filePath);

		String oldContent = "";

		BufferedReader reader = null;

		FileWriter writer = null;

		try
		{
			reader = new BufferedReader(new FileReader(fileToBeModified));

			//Reading all the lines of input text file into oldContent

			String line = reader.readLine();

			while (line != null)
			{
				oldContent = oldContent + line + System.lineSeparator();

				line = reader.readLine();
			}

			//Replacing oldString with newString in the oldContent

			String newContent = oldContent.replaceAll(oldString, newString);

			//Rewriting the input text file with newContent

			writer = new FileWriter(fileToBeModified);

			writer.write(newContent);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				//Closing the resources

				reader.close();

				writer.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args)
	{
		modifyFile("C:\\Users\\pranav\\Downloads\\jrlog.txt", "motorFrontLeft", "leftFront");
		modifyFile("C:\\Users\\pranav\\Downloads\\jrlog.txt", "motorFrontRight", "rightFront");
		modifyFile("C:\\Users\\pranav\\Downloads\\jrlog.txt", "motorBackLeft", "leftRear");
		modifyFile("C:\\Users\\pranav\\Downloads\\jrlog.txt", "motorBackRight", "rightRear");
		modifyFile("C:\\Users\\pranav\\Downloads\\jrlog.txt", "rightFront.setDir", "//");
		modifyFile("C:\\Users\\pranav\\Downloads\\jrlog.txt", "rightRear.setDir", "//");
		System.out.println("done");
	}
}
