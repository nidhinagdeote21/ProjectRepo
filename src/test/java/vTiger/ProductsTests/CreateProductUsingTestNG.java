package vTiger.ProductsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.CreateNewProductPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.ProductInfoPage;
import vTiger.ObjectRepository.ProductsPage;

@Listeners(vTiger.GenericUtilities.ListenerImplementationClass.class)
public class CreateProductUsingTestNG extends BaseClass{

	@Test
	public void createProductUsingTestNG() throws EncryptedDocumentException, IOException
	{
		String productName = eUtil.ReadDataFromExcelSheet("Products", 2, 2)+jUtil.getRandomNumber();
		String vendorName = eUtil.ReadDataFromExcelSheet("Vendors", 2, 2);
		
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickOnProductsLink();
		Reporter.log("Home Page is displayed",true);
		//ProductPage
		ProductsPage pp=new ProductsPage(driver);
		pp.clickOnProductLookupImg();
		Reporter.log("Product Page is displayed",true);
		//Creating Product
		CreateNewProductPage cnpp=new CreateNewProductPage(driver);
		cnpp.createNewProduct(productName, vendorName, driver);
		Reporter.log("New Product is created",true);
		//Assert.fail();
		//Product Info Page
		ProductInfoPage pip=new ProductInfoPage(driver);
		String ProductHeader = pip.getProductHeaderText();
		/*if(ProductHeader.contains(productName))
		{
			System.out.println("Product is created");
		}*/
		Assert.assertEquals(ProductHeader.contains(productName), true);
		
	}
	
}
