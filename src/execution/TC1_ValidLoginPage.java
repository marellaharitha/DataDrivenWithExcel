package execution;

import org.testng.annotations.Test;

import flowMethods.ValidateLogin;

public class TC1_ValidLoginPage {
/*public static void main(String args[])
{*/
	
		// TODO Auto-generated method stub
	@Test
	public void m1() throws Exception
	{
		ValidateLogin v=new ValidateLogin();
		v.PositiveValidateLogin();
		
	}
	@Test
	public void m2() throws Exception
	{
		ValidateLogin v=new ValidateLogin();
		
		v.NegativeValidateLogin();
	}
		
	

/*public void TC1_invalidLogin(){
	// TODO Auto-generated method stub
	ValidateLogin v=new ValidateLogin();

	
}*/
	

}
