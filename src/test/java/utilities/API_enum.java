package utilities;

public enum API_enum {
	
	AddProgram("/saveprogram");
	
	private String resource;
	API_enum(String resource)
	{
		this.resource=resource;
	}
	
	public String getresource()
	{
		return resource;
	}

}
