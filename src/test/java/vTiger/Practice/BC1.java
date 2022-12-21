package vTiger.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BC1 {
	@BeforeSuite
	public void BeforeSuiteMethod()
	{
		System.out.println("This is before suite method");
	}

	@BeforeTest
	public void BeforeTestMethod()
	{
		System.out.println("This is before test method");
	}

	@BeforeClass
	public void BeforeClassMethod()
	{
		System.out.println("This is before class method");
	}

	@BeforeMethod
	public void BeforeMethodm()
	{
		System.out.println("This is before method");
	}


	@AfterMethod
	public void AfterMethodm()
	{
		System.out.println("This is after method");
	}

	@AfterClass
	public void AfterClassMethod()
	{
		System.out.println("This is after class method");
	}

	@AfterTest
	public void AfterTestMethod()
	{
		System.out.println("This is after test method");
	}

	@AfterSuite
	public void AfterSuiteMethod()
	{
		System.out.println("This is after suite method");
	}
	}


