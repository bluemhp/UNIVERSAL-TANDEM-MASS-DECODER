import java.io.File;
import javax.swing.filechooser.*;

public class FileSave extends FileFilter
{
	private final String extension;
	private final String description;
	
	public FileSave (String extension, String description)
	{
		this.extension = extension;
		this.description = description;
	}

	@Override
	public boolean accept(File file)
	{
		if (file.isDirectory())
		{
			return true;
		}
		return file.getName().endsWith(extension);
	}

	@Override
	public String getDescription()
	{
		return description + String.format("(*%s)",extension);
	}

}
