package com.test.yobihealth.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import com.test.yobihealth.entities.Food;

import com.test.yobihealth.security.JWTAthenticationFilter;
import com.test.yobihealth.security.JWTAuthorizationFilter;

@RestController
public class ImageRestController {
	
	
	@PostMapping("/file")
	public void save(@RequestBody byte[] imageBytes) 
	{
		//databse
        Mongo mongo = new Mongo( "192.168.37.134" );
        String dbName = "yobihealthdb";
        DB db = mongo.getDB( dbName );
        
      //Create GridFS object
        GridFS gridFs = new GridFS( db );
        
      //Create GridFSInputFile file
        GridFSInputFile gridFSInputFile = gridFs.createFile( imageBytes );
        //Set meta data : user reference id
        DBObject metadata = new BasicDBObject();
        metadata.put("user", JWTAuthorizationFilter.useeeernaeeme);
        metadata.put("label", "Food");
        gridFSInputFile.setMetaData(metadata);
       //Set FileName
        gridFSInputFile.setFilename("filename");
        //Save image into database
        gridFSInputFile.save();
	}
	
	@GetMapping("/foods/{username}")
	public List<GridFSDBFile> getFoodsByUsername()  
	{
		//databse
        Mongo mongo = new Mongo( "192.168.37.134" );
        String dbName = "yobihealthdb";
        DB db = mongo.getDB( dbName );
        
      //Create GridFS object
        GridFS gridFs = new GridFS( db );
     
        
        //Find saved image
       // GridFSDBFile out = gridFs.findOne( new BasicDBObject( "_id" , in.getId() ) );

       // GridFSDBFile out = gridFs.findOne("dddddds");
       
       // BasicDBObject query = new BasicDBObject("metadata.user", "admin");
         //GridFSDBFile out =  gridFs.findOne(query);
       
        
      BasicDBObject query = new BasicDBObject("metadata.user", JWTAuthorizationFilter.useeeernaeeme).append("metadata.label", "Food");
      
         List<GridFSDBFile> files = gridFs.find(query);
         
         return files;
         
         
         
        
        //Save loaded image from database into new image file
      //  FileOutputStream outputImage = new FileOutputStream("C:\\Users\\Mnif\\Desktop\\vvv\\angulahaha.jpg");
       
        //out.writeTo( outputImage );
     //  outputImage.close();
      
    //  return files.toString();
	}
}
