package utilities;

public enum API_enum {
	
	AddProgram("/saveprogram"),
	AddBatch("/batches"),
	GetallProgs("/allPrograms"),
	GetByProgID("/programs/{{PostRequestSteps.progID_env}}"),
	AddUsers("/users/users/roleStatus"),
	AddAssignment("/assignments"),
	SubmitAssgn("/assignmentsubmission");
	DeleteProgramID("/deletebyprogid/"),
	DeleteProgramName("/deletebyprogname/"),
	DeleteBatchID("/batches/"),
	DeleteUserID("/users/users/"),
	DeleteassignID("/assignments/");

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
