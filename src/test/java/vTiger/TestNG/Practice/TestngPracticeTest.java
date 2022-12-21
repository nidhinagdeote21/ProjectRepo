package vTiger.TestNG.Practice;

import org.apache.http.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestngPracticeTest {
@Test(priority = 2)
public void CreateOrganisationTest()
{
	//Assert.fail();
	System.out.println("This method creates an organisation");
}
@Ignore
@Test(priority = -1, invocationCount = 3)
public void ModifyOrganizationTest()
{
	System.out.println("This method is used to modify the organization");
}

@Test(priority = -2, enabled = true)
public void DeleteOrganizationTest()
{
	System.out.println("This method is used to delete the organization");
}


}
