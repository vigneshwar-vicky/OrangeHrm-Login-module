package Main;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Orangehrm.Base;

public class Actual extends Base {
	
	@Test(dataProvider = "getvaliddata")
	public void testValidData(HashMap<String, String> input)  throws  IOException, InterruptedException
	{
		String act = loginpage.dologin(input.get("username"),input.get("password"));
		Assert.assertTrue(act.equalsIgnoreCase("Login"));
	}
	
	@Test(dataProvider="getinvaliddata")
	public void testInvalidData(HashMap<String,String> input) throws IOException
	{
	  String match = loginpage.invalidlogin(input.get("username"),input.get("password"));
	  Assert.assertTrue(match.equalsIgnoreCase("Invalid credentials"));
	}
	
	@Test(dataProvider="geterrordata")
	public void testErrorData(HashMap<String,String> input) throws  IOException, InterruptedException
	{
	  String match = loginpage.errorlogin(input.get("username"),input.get("password"));
	  Assert.assertTrue(match.equalsIgnoreCase("Required"));
	}
	
	@Test
	public void testForgotPass() throws InterruptedException
	{
		 String actuall = loginpage.forgotPass();
		 Assert.assertTrue(actuall.equalsIgnoreCase("Reset Password"));
	}
	
	@Test
	public void testFacebook() throws InterruptedException
	{
		String stat = loginpage.checkfb();
		Assert.assertTrue(stat.contains("Forgotten account?"));
		
	}
	
	@Test
	public void testTwitter() throws InterruptedException 
	{
		String stat = loginpage.checktweet();
		Assert.assertTrue(stat.contains("2,503 Tweets"));
	}
	
	@Test
	public void testOfficialSite() throws InterruptedException 
	{
		String stat = loginpage.checkweb();
		Assert.assertTrue(stat.contains("Why OrangeHRM"));
	}
	
	@Test
	public void testUtube() throws InterruptedException
	{
		String stat = loginpage.checkutube();
		Assert.assertTrue(stat.contains("Shorts"));
	}
	
	@Test
	public void testLinkedin() throws InterruptedException
	{
		String stat = loginpage.checklinkedin();
		Assert.assertTrue(stat.contains("OrangeHRM"));
		
	}
	
	@Test
	public void testLogo() throws InterruptedException
	{
		int actuaal = loginpage.logo();
		Assert.assertEquals(actuaal,3);
	}
	
@DataProvider  
public Object[][] getinvaliddata() throws IOException
{
	/*HashMap<String,String> map= new HashMap<String,String>();
	map.put("username","vicky");
	map.put("password", "viccckkyy");
	
	HashMap<String,String> map1= new HashMap<String,String>();
	map1.put("username","Admin");
	map1.put("password", "viccckkyy");
	
	HashMap<String,String> map2= new HashMap<String,String>();
	map2.put("username","vicky");
	map2.put("password", "admin123");
	
	HashMap<String,String> map3= new HashMap<String,String>();
	map3.put("username","Admin");
	map3.put("password", "viccckkyy");
	 return new Object[] [] {{map}, {map1}, {map2}, {map3}};*/
  List<HashMap<String,String>> data=getJsondata("C:\\Users\\Vigneshwar\\eclipse-workspace\\Orangehrm\\src\\test\\java\\Data\\Values.json");
   return new Object[] [] { {data.get(5)} , {data.get(6)} , {data.get(7)}, {data.get(8)} };


}

@DataProvider
public Object[][] getvaliddata() throws IOException
{
   List<HashMap<String,String>> data=getJsondata("C:\\Users\\Vigneshwar\\eclipse-workspace\\Orangehrm\\src\\test\\java\\Data\\Values.json");
   return new Object[] [] {{data.get(9)}, {data.get(10)} };


}


@DataProvider
public Object[][] geterrordata() throws IOException
{
   List<HashMap<String,String>> data=getJsondata("C:\\Users\\Vigneshwar\\eclipse-workspace\\Orangehrm\\src\\test\\java\\Data\\Values.json");
   return new Object[] [] {{data.get(0)}, {data.get(1)}, {data.get(2)}, {data.get(3)} , {data.get(4)}  };


}

}
