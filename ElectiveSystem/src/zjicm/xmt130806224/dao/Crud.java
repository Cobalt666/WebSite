package zjicm.xmt130806224.dao;

import java.sql.*;
import java.util.*;


import zjicm.xmt130806224.bean.Admin;
import zjicm.xmt130806224.bean.Course;
import zjicm.xmt130806224.bean.Elect;
import zjicm.xmt130806224.bean.User;

public class Crud {
	
	//登录注册：
	//注册时不需要填写全部信息，后续登录后完善
	public void addAUser(User user){
		Connection conn = DB.createConn();
		String sql = "insert into tb_user(number, name, password, gender, email, cate, grade, classname) values (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setInt(1, user.getNumber());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getCate());
			ps.setInt(7, user.getGrade());
			ps.setString(8, user.getClassname());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}
	
	//使用学号作为唯一标识符
	public User getAUserByNumber(int number){
		User user = null;
		Connection conn = DB.createConn();
		String sql = "select * from tb_user where number = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setInt(1, number);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setNumber(rs.getInt("number"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setGender(rs.getString("gender"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setInstitute(rs.getString("institute"));
				user.setDepart(rs.getString("depart"));
				user.setCate(rs.getString("cate"));
				user.setBirthdate(rs.getString("birthdate"));
				user.setGrade(rs.getInt("grade"));
				user.setClassname(rs.getString("classname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
		return user;
	}
	
	public User getAUserById(int id){
		User user = null;
		Connection conn = DB.createConn();
		String sql = "select * from tb_user where id = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setNumber(rs.getInt("number"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setGender(rs.getString("gender"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setInstitute(rs.getString("institute"));
				user.setDepart(rs.getString("depart"));
				user.setCate(rs.getString("cate"));
				user.setBirthdate(rs.getString("birthdate"));
				user.setGrade(rs.getInt("grade"));
				user.setClassname(rs.getString("classname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
		return user;
	}
	
	public User getAUser(User u){
		User user = null;
		Connection conn = DB.createConn();
		String sql = "select * from tb_user where number = ? and password = ? and cate = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setInt(1, u.getNumber());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getCate());
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setNumber(rs.getInt("number"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setGender(rs.getString("gender"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setInstitute(rs.getString("institute"));
				user.setDepart(rs.getString("depart"));
				user.setCate(rs.getString("cate"));
				user.setBirthdate(rs.getString("birthdate"));
				user.setGrade(rs.getInt("grade"));
				user.setClassname(rs.getString("classname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
		return user;
	}
	
	public Admin getAnAdminByName(String name){
		Admin a = null;
		Connection conn = DB.createConn();
		String sql = "select * from tb_admin where name = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				a = new Admin();
				a.setName(rs.getString("name"));
				a.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
		return a;
	}
	
	public Admin matchAdmin(Admin a){
		Admin admin = null;
		Connection conn = DB.createConn();
		String sql = "select * from tb_admin where name = ? and password = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setString(1, a.getName());
			ps.setString(2, a.getPassword());
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				admin = new Admin();
				admin.setName(rs.getString("name"));
				admin.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
		return admin;
	}
	
	//个人信息管理：
	
	public void updateUserByNumber(User user, int number) {
		Connection conn = DB.createConn();
		String sql = "update tb_user set "
				+ "number = ?, name = ?, intro = ?, gender = ?, email = ?, "
				+ "phone = ?, institute = ?, depart = ?, cate =?,birthdate=?,grade=?,classname=? where number = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setInt(1, user.getNumber());
			ps.setString(2, user.getName());
			ps.setString(3, user.getIntro());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPhone());
			ps.setString(7, user.getInstitute());
			ps.setString(8, user.getDepart().replace(',', ' ').trim());
			ps.setString(9, user.getCate());
			ps.setString(10, user.getBirthdate());
			ps.setInt(11, user.getGrade());
			ps.setString(12, user.getClassname());
			ps.setInt(13, number);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}
	
	public void updateUser(User user) {
		Connection conn = DB.createConn();
		String sql = "update tb_user set "
				+ "number = ?, name = ?, intro = ?, gender = ?, email = ?, "
				+ "phone = ?, institute = ?, depart = ?, cate =?,birthdate=?,grade=?,classname=? where id = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setInt(1, user.getNumber());
			ps.setString(2, user.getName());
			ps.setString(3, user.getIntro());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPhone());
			ps.setString(7, user.getInstitute());
			ps.setString(8, user.getDepart().replace(',', ' ').trim());
			ps.setString(9, user.getCate());
			ps.setString(10, user.getBirthdate());
			ps.setInt(11, user.getGrade());
			ps.setString(12, user.getClassname());
			ps.setInt(13, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}
	
	public void updateAdminPwdByName(String pwd, String name) {
		Connection conn = DB.createConn();
		String sql = "update tb_admin set "
				+ "password = ? where name = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setString(1, pwd);
			ps.setString(2, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}
	
	
	public void updatePwdByNumber(String pwd, int number) {
		Connection conn = DB.createConn();
		String sql = "update tb_user set "
				+ "password = ? where number = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setString(1, pwd);
			ps.setInt(2, number);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}
	
	public void updateAvatarByNumber(String avatar, int number) {
		Connection conn = DB.createConn();
		String sql = "update tb_user set "
				+ "avatar = ? where number = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setString(1, avatar);
			ps.setInt(2, number);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}
	
	public void updateAvatarById(String avatar, int id) {
		Connection conn = DB.createConn();
		String sql = "update tb_user set "
				+ "avatar = ? where id = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setString(1, avatar);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}
	
	//用户信息管理：
	public List<User> getAllUsers() throws SQLException {
		Connection conn = DB.createConn();
		String sql = "select * from tb_user";
		PreparedStatement ps = DB.prepare(conn, sql);
		List<User> users = new ArrayList<User>();
		try {
			ResultSet rs = ps.executeQuery();
			User u = null;
			while(rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setNumber(rs.getInt("number"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setPhone(rs.getString("phone"));
				u.setGender(rs.getString("gender"));
				u.setEmail(rs.getString("email"));
				u.setInstitute(rs.getString("institute"));
				u.setDepart(rs.getString("depart"));
				u.setCate(rs.getString("cate"));
				u.setBirthdate(rs.getString("birthdate"));
				u.setGrade(rs.getInt("grade"));
				u.setClassname(rs.getString("classname"));
				u.setAvatar(rs.getString("avatar"));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw(e);
		}
		DB.close(ps);
		DB.close(conn);
		return users;
	}
	
	public List<User> queryUsers(String cate, String q) throws SQLException {
		Connection conn = DB.createConn();
		String sql = "select * from tb_user where " + cate + "like'%" + q + "%' ";
		PreparedStatement ps = DB.prepare(conn, sql);
		List<User> users = new ArrayList<User>();
		try {
			ResultSet rs = ps.executeQuery();
			User u = null;
			while(rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setNumber(rs.getInt("number"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setIntro(rs.getString("intro"));
				u.setGender(rs.getString("gender"));
				u.setEmail(rs.getString("phone"));
				u.setInstitute(rs.getString("institute"));
				u.setDepart(rs.getString("depart"));
				u.setCate(rs.getString("cate"));
				u.setBirthdate(rs.getString("birthdate"));
				u.setGrade(rs.getInt("grade"));
				u.setClassname(rs.getString("classname"));
				u.setAvatar(rs.getString("avatar"));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw(e);
		}
		DB.close(ps);
		DB.close(conn);
		return users;
	}
	
	public void deleteUserById(int id) {
		Connection conn = DB.createConn();
		String sql = "delete from tb_user where id = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}
	
	//课程信息管理：
	public void addACourse(Course course) {
		Connection conn = DB.createConn();
		String sql = "insert into tb_course(name, teacher, limitcount, period, starttime, credit, category) values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setString(1, course.getName());
			ps.setString(2, course.getTeacher());
			ps.setInt(3, course.getLimitcount());
			ps.setString(4, course.getPeriod());
			ps.setString(5, course.getStarttime());
			ps.setInt(6, course.getCredit());
			ps.setString(7, course.getCategory());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}
	
	public void deleteCourseById(int id) {
		Connection conn = DB.createConn();
		String sql = "delete from tb_course where id = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}
	
	public void updateCourse(Course course) {
		Connection conn = DB.createConn();
		String sql = "update tb_course set name = ?, teacher = ?, limitcount = ?,"
				+ "starttime = ?, period = ?, credit = ?, category = ? where id = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setString(1, course.getName());
			ps.setString(2, course.getTeacher());
			ps.setInt(3, course.getLimitcount());
			ps.setString(4, course.getStarttime());
			ps.setString(5, course.getPeriod());
			ps.setInt(6, course.getCredit());
			ps.setString(7, course.getCategory());
			ps.setInt(8, course.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}
	
	public Course getACourseById(int id) {
		Connection conn = DB.createConn();
		String sql = "select * from tb_course where id = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		Course c = null;
		try {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				c = new Course();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setLimitcount(rs.getInt("limitcount"));
				c.setTeacher(rs.getString("teacher"));
				c.setPeriod(rs.getString("period"));
				c.setStarttime(rs.getString("starttime"));
				c.setCredit(rs.getInt("credit"));
				c.setCategory(rs.getString("category"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
		return c;
	}
	
	public List<Course> queryCourses(String cate, String q) throws SQLException {
		Connection conn = DB.createConn();
		String sql = "select * from tb_course where " + cate + "like'%" + q + "%' ";
		PreparedStatement ps = DB.prepare(conn, sql);
		List<Course> courses = new ArrayList<Course>();
		try {
			ResultSet rs = ps.executeQuery();
			Course c = null;
			while(rs.next()) {
				c = new Course();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setLimitcount(rs.getInt("limitcount"));
				c.setTeacher(rs.getString("teacher"));
				c.setPeriod(rs.getString("period"));
				c.setStarttime(rs.getString("starttime"));
				c.setCredit(rs.getInt("credit"));
				c.setCategory(rs.getString("category"));
				courses.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw(e);
		}
		DB.close(ps);
		DB.close(conn);
		return courses;
	}
	
	public List<Course> getAllCourses() throws SQLException {
		Connection conn = DB.createConn();
		String sql = "select * from tb_course";
		PreparedStatement ps = DB.prepare(conn, sql);
		List<Course> courses = new ArrayList<Course>();
		try {
			ResultSet rs = ps.executeQuery();
			Course c = null;
			while(rs.next()) {
				c = new Course();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setLimitcount(rs.getInt("limitcount"));
				c.setTeacher(rs.getString("teacher"));
				c.setPeriod(rs.getString("period"));
				c.setStarttime(rs.getString("starttime"));
				c.setCredit(rs.getInt("credit"));
				c.setCategory(rs.getString("category"));
				courses.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw(e);
		}
		DB.close(ps);
		DB.close(conn);
		return courses;
	}
	
	//选课
	public void addAnElect (int studentnum, int courseid) {
		Connection conn = DB.createConn();
		String sql = "insert into tb_elect(studentnum,courseid) values ( ?, ?)";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setInt(1, studentnum);
			ps.setInt(2, courseid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}
	
	public List<Elect> getAllElectByNumber(int studentnum) throws SQLException {
		Connection conn = DB.createConn();
		String sql = "select * from tb_elect where studentnum = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		List<Elect> elects = new ArrayList<Elect>();
		try {
			ps.setInt(1, studentnum);
			ResultSet rs = ps.executeQuery();
			Elect e = null;
			while (rs.next()) {
				e = new Elect();
				e.setStudentnum(rs.getInt("studentnum"));
				e.setCourseid(rs.getInt("courseid"));
				elects.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw (e);
		}
		DB.close(ps);
		DB.close(conn);
		return elects;
	}

	public void deleteElect(int courseid, int studentnum) {
		Connection conn = DB.createConn();
		String sql = "delete from tb_elect where courseid = ? and studentnum = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setInt(1, courseid);
			ps.setInt(2, studentnum);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
	}

}
