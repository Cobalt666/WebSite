package zjicm.xmt130806224.action;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import zjicm.xmt130806224.bean.Course;
import zjicm.xmt130806224.bean.Elect;
import zjicm.xmt130806224.bean.User;
import zjicm.xmt130806224.dao.Crud;

public class UserAction extends ActionSupport {
	User user = new User();
	Course course = new Course();
	Elect elect = new Elect();
	Crud crud = new Crud();
	private int number;
	private int id;
	private int courseid;
	private int electid;
	private String message;
	private List<User> users;
	private List<Course> courses;
	private List<Elect> elects;
	private HttpServletRequest request;
	private HttpServletResponse response;
    private HttpSession session;
    private ServletContext application;
    
    private String queryCate;
	private String queryString;
    
    //upload-->
    private File file;
	private String fileFileName;
	
	//get set:
    
	public int getNumber() {
		return number;
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

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public Elect getElect() {
		return elect;
	}

	public void setElect(Elect elect) {
		this.elect = elect;
	}

	public List<Elect> getElects() {
		return elects;
	}

	public void setElects(List<Elect> elects) {
		this.elects = elects;
	}

	public int getElectid() {
		return electid;
	}

	public void setElectid(int electid) {
		this.electid = electid;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Crud getCrud() {
		return crud;
	}
	public void setCrud(Crud crud) {
		this.crud = crud;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	//action method:
	public String uploadAvatar() {
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
			crud.updateAvatarByNumber(destPath, Integer.parseInt(this.session.getAttribute("number").toString()));
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
		
	}
	
	public String login() {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
        user = crud.getAUser(user);
        if(null != user) {
        	this.session.setAttribute("number", user.getNumber());
        	this.session.setAttribute("name", user.getName());
        	this.session.setAttribute("cate", user.getCate());
        	return "login";
        }
        else {
        	message="编号或密码不正确！";
        	return "logout";
        }
		
	}
	
	public String reg() {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
        crud.addAUser(user);
        id=user.getId();
        this.session.setAttribute("number", user.getNumber());
    	this.session.setAttribute("name", user.getName());
    	this.session.setAttribute("cate", user.getCate());
		return SUCCESS;
	}
	
	public String showMyInfo() {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
		user = crud.getAUserByNumber(Integer.parseInt(this.session.getAttribute("number").toString()));
		return SUCCESS;
	}
	
	public String updateMyInfo() {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
		crud.updateUserByNumber(user, Integer.parseInt(this.session.getAttribute("number").toString()));
		return SUCCESS;
	}
	
	public String updateInputMyInfo() {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
        user = crud.getAUserByNumber(Integer.parseInt(this.session.getAttribute("number").toString()));
		return SUCCESS;
	}
	
	public String updatePwd() {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
		crud.updatePwdByNumber(user.getPassword(), Integer.parseInt(this.session.getAttribute("number").toString()));
		return SUCCESS;
	}
	
	public String updateInputPwd() {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
        user = crud.getAUserByNumber(Integer.parseInt(this.session.getAttribute("number").toString()));
		return SUCCESS;
	}
	
	public String updateCheckPwd() {
		User oldUser = new User();
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
        oldUser = crud.getAUserByNumber(Integer.parseInt(this.session.getAttribute("number").toString()));
        if(oldUser.getPassword().equals(user.getPassword()))
        	return SUCCESS;
        else{
        	message="密码不正确！";
        	return "wrong";
        }
	}
	
	public String chooseACourse() throws SQLException {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
		courses = crud.getAllCourses();
		
		return SUCCESS;
	}
	
	public String queryCoursesByUser() throws SQLException {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
		courses = crud.queryCourses(queryCate, queryString);
		
		return SUCCESS;
	}
	
	public String choose() throws NumberFormatException, SQLException {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
        String s = crud.limitedReason(courseid, Integer.parseInt(this.session.getAttribute("number").toString()));
        if(s.equals("Allowed")){
        	crud.addAnElect(Integer.parseInt(this.session.getAttribute("number").toString()), courseid);
    		crud.decreaseCourseRest(courseid);
    		this.session.setAttribute("msg", null);
        }else{
        	this.session.setAttribute("msg", s);
        	System.out.println(s);
        }
        return SUCCESS;
		
	}
	
	public String deleteElect() {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
		crud.deleteElect(courseid, Integer.parseInt(this.session.getAttribute("number").toString()));
		crud.increaseCourseRest(courseid);
		return SUCCESS;
	}
	
	public String showMyCourse() throws NumberFormatException, SQLException {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
        List<Course> coursesTemp = new ArrayList<Course>();
        Course c = null;
		elects = crud.getAllElectByNumber(Integer.parseInt(this.session.getAttribute("number").toString()));
		for(int i=0; i < elects.size(); i++) {
			c = new Course();
			c = crud.getACourseById(elects.get(i).getCourseid());
			coursesTemp.add(c);
		}
		courses = coursesTemp;
		return SUCCESS;
	}
	
	//exit
	public String execute() {
		this.request = ServletActionContext.getRequest();
        this.session = this.request.getSession();
        this.session.invalidate();
        return SUCCESS;
    }
}
