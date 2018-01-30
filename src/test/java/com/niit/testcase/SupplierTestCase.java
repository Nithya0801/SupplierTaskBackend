package com.niit.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.SupplierDao;
import com.niit.Model.Supplier;

public class SupplierTestCase {

	private static AnnotationConfigApplicationContext ctxt;
	
	static SupplierDao supplierDao;
	
	Supplier supplier;
	
	@BeforeClass
	public static void init()
	{
		ctxt=new AnnotationConfigApplicationContext();
		ctxt.scan("com.niit");
		ctxt.refresh();
		supplierDao=(SupplierDao)ctxt.getBean("supplierDao");
	}
	
	
	
	
	
	
	
	@Test
	public void testAddSupplier()
	{
		supplier = new Supplier();
		supplier.setSid(123);
		supplier.setSname("pqr");
		
		assertEquals("Inserted!!!",true,supplierDao.insertSupplier(supplier));
	}
	
	@Test
	public void testUpdateSupplier()
	{
	//	supplier = new Supplier();
		//supplier.setSid(100);
	//	Supplier supplier=supplierDao.getSupplierById(123);
		
		supplier=new Supplier();
		supplier.setSid(111);
		supplier.setSname("qwe");
		
	assertEquals("Something went wrong while updating the existing record!",true,supplierDao.updateSupplier(supplier));
	}
	
	@Test
	public void testDeleteSupplier()
	{
		//Supplier supplier=supplierDao.getSupplierById(123);
		assertEquals("Something went wrong while deleting the existing record!",
				true,supplierDao.deleteSupplier(101));
	}
}
