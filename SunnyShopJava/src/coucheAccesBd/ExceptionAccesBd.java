package coucheAccesBd;

@SuppressWarnings("serial")
public class ExceptionAccesBd extends Exception
{
	private String Details;
	// ---------------------------------------------------------
	public String getDetails() { return Details; }
	// ---------------------------------------------------------
	public ExceptionAccesBd(String cause, String details)
	{
	super(cause);
	Details = details;
	}
}
