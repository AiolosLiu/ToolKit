import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileOperation {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		help();
		while (true){
			String op = scan.nextLine();
			
			switch(op){
				case "c":
					System.out.println("Please input the filename");
					String fileNameC = scan.nextLine();
					creatFile(fileNameC, scan);
					break;
				case "r":
					System.out.println("Please input the filename");
					String fileNameR = scan.nextLine();
					readFile(fileNameR);
					break;
				case "w":
					System.out.println("Please input the filename");
					String fileNameW = scan.nextLine();
					writeFile(fileNameW, scan, StandardOpenOption.APPEND);
					break;
				case "d":
					System.out.println("Please input the filename");
					String fileNameD = scan.nextLine();
					deleteFile(fileNameD);
					break;
				case "l":
					final String dir = System.getProperty("user.dir");
					listDictionary(dir);
					break;
				case "q":
					System.out.println("System Exit");
					return;
				default:
					System.out.println(op);
					break;
			}
		}

	}

	private static void help() {
		// TODO Auto-generated method stub
		System.out.println("Please choose an operation");
		System.out.println("c - create a new file");
		System.out.println("r - read the file");
		System.out.println("w - write the file");
		System.out.println("d - delete the file");
		System.out.println("l - list the current directory");
		System.out.println("q - exit the application");
	}

	private static void listDictionary(String dir) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : directoryStream) {
                System.out.println("-" + path.toString());
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}

	private static void deleteFile(String fileName) {
		Path file = Paths.get(fileName);
		try {
			Files.deleteIfExists(file);
			System.out.println("Already delete!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void writeFile(String fileName, Scanner scan, OpenOption options) {
		List<String> lines = new LinkedList<>();
		System.out.println("Please input the content, output exit() to exit");
		
		Path file = Paths.get(fileName);
		String content = scan.nextLine();
		while(!content.equals("exit()")){
			lines.add(content);
			content = scan.nextLine();
		}
		try {
			Files.write(file, lines, Charset.forName("UTF-8"), options);
			System.out.println("Create successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readFile(String fileName) {
		Path file = Paths.get(fileName);
		try {
			if(!Files.exists(file,LinkOption.NOFOLLOW_LINKS)){
				System.out.println("Files don't exist");
				return;
			}
			List<String> content = Files.readAllLines(file);
			for(String line : content){
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void creatFile(String fileName, Scanner scan) {
		writeFile(fileName,scan,StandardOpenOption.CREATE_NEW);
	} 
}
