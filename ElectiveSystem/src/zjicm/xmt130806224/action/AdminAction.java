package zjicm.xmt130806224.action;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import zjicm.xmt130806224.bean.Admin;
import zjicm.xmt130806224.bean.Course;
import zjicm.xmt130806224.bean.User;
import zjicm.xmt130806224.dao.Crud;

public class AdminAction extends ActionSupport {
	private Admin admin = new Admin();
	private User user = new User();
	private Course course = new Course();
	private Crud crud = new Crud();
	
	private int userid;
	private int courseid;
	private String message;
	private String queryCate;
	private String queryString;
	
	private List<User> users;
	private List<Course> courses;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
    private HttpSession session;
    private ServletContext application;
    private File file;
	private String fileFileName;
	//get set:
    
	public Admin getAdmin() {
		return admin;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getQueryCate() {
		return queryCate;
	}
	public void setQueryCate(String queryCate) {
		this.queryCate = queryCate;
	}
	public String getQueryString() {
		return queryString;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Crud getCrud() {
		return crud;
	}
	public void setCrud(Crud crud) {
		this.crud = crud;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	//action method:
	public String allowSelect() {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
        this.session.setAttribute("allow", "yes");
        return SUCCESS;
	}
	
	public String disallowSelect() {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
        this.session.setAttribute("allow", "no");
        return SUCCESS;
	}
	
	public String uploadAvatarByAdmin() {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
        String destPath = ServletActionContext.getServletContext().getRealPath("/upload/avatars");
		File savefile = new File(destPath, fileFileName);
		if (!savefile.getParentFile().exists())
			savefile.getParentFile().mkdirs();
		System.out.println(destPath);//test
		try {
			File destFile = new File(destPath, fileFileName);
			FileUtils.copyFile(file, destFile);
			destPath="upload\\avatars\\"+fileFileName;
			crud.updateAvatarById(destPath, userid);
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
		
	}
	
	public String updateAdminPwd() {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
		crud.updateAdminPwdByName(admin.getPassword(), this.session.getAttribute("name").toString());
		return SUCCESS;
	}
	
	public String updateAdminInputPwd() {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
        admin = crud.getAnAdminByName(this.session.getAttribute("name").toString());
		return SUCCESS;
	}
	
	public String updateAdminCheckPwd() {
		Admin old = new Admin();
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
        old = crud.getAnAdminByName(this.session.getAttribute("name").toString());
        if(old.getPassword().equals(admin.getPassword()))
        	return SUCCESS;
        else{
        	message="密码不正确！";
        	return "wrong";
        }
	}
	
	public String login() {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
        admin = crud.matchAdmin(admin);
        if(null != admin) {
        	this.session.setAttribute("name", admin.getName());
        	this.session.setAttribute("cate", "admin");
        	return "login";
        }
        else {
        	message="用户名或密码不正确！";
        	return "logout";
        }
		
	}
	
	//course management:
	public String addCourse() {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
        
		crud.addACourse(course);
		if(this.session.getAttribute("cate").toString().equals("admin"))
			return SUCCESS;
		else{
			return "stay";
		}
	}
	
	public String deleteCourse() {
		crud.deleteCourseById(courseid);
		return SUCCESS;
	}
	
	public String updateInputCourse() {
		course = crud.getACourseById(courseid);
		return SUCCESS;
	}

	
	public String updateCourse() {
		crud.updateCourse(course);
		return SUCCESS;
	}
	
	public String showCourse() {
		course = crud.getACourseById(courseid);
		return SUCCESS;
	}
	
	public String listCourses() throws SQLException {
		courses = crud.getAllCourses();
		return SUCCESS;
	}
	
	public String queryCourses() throws SQLException {
		courses = crud.queryCourses(queryCate, queryString);
		return SUCCESS;
	}
	
	//user management:
	public String deleteUser() {
		crud.deleteUserById(userid);
		return SUCCESS;
	}
	
	public String updateInputUser() {
		user = crud.getAUserById(userid);
		return SUCCESS;
	}
	
	
	public String updateUser() {
		crud.updateUser(user);
		return SUCCESS;
	}
	
	public String queryUsers() throws SQLException {
		users = crud.queryUsers(queryCate, queryString);
		return SUCCESS;
	}
	
	public String listUsers() throws SQLException {
		users = crud.getAllUsers();
		return SUCCESS;
	}

	public String execute() {
        return SUCCESS;
    }
}
