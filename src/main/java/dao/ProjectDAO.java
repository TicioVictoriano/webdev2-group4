package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.MysqlCon;
import model.Project;

public class ProjectDAO {
private MysqlCon msCon;
	
	public ProjectDAO() {
		msCon = new MysqlCon("webdevcw", "root", "");
	}
	
	public boolean registerProject(Project project) {
		try {
    		String sql = "INSERT INTO modules(name, intended_date, modules_id, status_id, completion_date) VALUES(?, ?, ?, ?, ?)";
		    PreparedStatement pstmt = msCon.getPreparedStatement(sql);
		    
            pstmt.setString(1, project.getName());
            pstmt.setString(2, project.getIntendedDate());
            pstmt.setInt(3, project.getModules_id());
            pstmt.setInt(4, project.getStatus_id());
            pstmt.setString(5, project.getCompletionDate());
            
            pstmt.executeUpdate();	    
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
//			msCon.close();
		}
		
		return true;
	}
	
	public ArrayList<Project> getProjects(){
		ArrayList<Project> modules = new ArrayList<Project>();
		Project project = null;
		
		try {
    		String sql = "SELECT * FROM modules";
    		
		    Statement statement = msCon.getStatement();
		    ResultSet results = statement.executeQuery(sql);
		    
		    while (results.next()) {
		    	project = new Project();
		    	
				project.setName(results.getString("name"));
				project.setCompleted(Integer.parseInt(results.getString("description")));
				project.setId(results.getInt("id"));
				project.setStatus_id(results.getInt("status_id"));
				project.setModules_id(results.getInt("modules_id"));
				project.setCompletionDate(results.getString("completion_date"));
				
				modules.add(project);
		    }
		    
		    
		    
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return modules;
	}
	
	public Project getProject(int id) {
		Project project;
		
		try {
    		String sql = "SELECT * FROM projects WHERE id='"+id+"'";
		    Statement statement = msCon.getStatement();
		    
		    ResultSet results = statement.executeQuery(sql);
		    project = new Project();
		    
		    while (results.next()) {
		      project.setName(results.getString("name"));
		      project.setCompleted(Integer.parseInt(results.getString("description")));
		      project.setId(results.getInt("id"));
		      project.setStatus_id(results.getInt("status_id"));
		      project.setModules_id(results.getInt("modules_id"));
		      project.setCompletionDate(results.getString("completion_date"));
		    }
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return project;
	}					
}
