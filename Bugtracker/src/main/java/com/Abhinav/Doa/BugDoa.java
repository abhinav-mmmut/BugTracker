package com.Abhinav.Doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



import com.Abhinav.AddBugDetails.Bug; 

public class BugDoa {
	Connection con;
	PreparedStatement ps;
	public void addbug(String bn,String bd,String emp) {
		
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/giraffe","root","qwerty");
		
		
		ps = con.prepareStatement("insert into bugs(bugname,bugdetails,employee)values(?,?,?)");
        ps.setString(1,bn);
        ps.setString(2,bd);
        ps.setString(3,emp);
        ps.executeUpdate();
		System.out.println("Successfully added");
		}
		catch(Exception e){
			System.out.println(e);
			
		}
		
	}
	public ArrayList<Bug> show() {  
		ArrayList<Bug> al=new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/giraffe","root","qwerty");
            ps = con.prepareStatement("select * from bugs");
            ResultSet rs= ps.executeQuery();
           // ArrayList<Bug> al=new ArrayList<>();
            while(rs.next()) {
            	Bug b=new Bug();
            	b.setBugname(rs.getString("bugname"));
            	b.setBugdetails(rs.getString("bugdetails"));
            	b.setEmployee(rs.getString("employee"));
            	al.add(b);
            }
           
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        return al;
        
    }
    
 

}
