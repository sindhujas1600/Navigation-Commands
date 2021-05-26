package navigationCommands;

public class mainMethod extends locatingElements {

	public static void main(String[] args) throws Exception {
		
		try
		{
			mainMethod object = new mainMethod();
			object.getDriver();
			object.navigateBack();
			object.navigateForward();
			object.navigateRefresh();
			object.closeBrowser();
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}

}
