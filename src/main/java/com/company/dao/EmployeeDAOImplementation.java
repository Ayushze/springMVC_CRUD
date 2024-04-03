package com.company.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.company.pojo.Employee;
import org.springframework.jdbc.core.RowMapper;  

public class EmployeeDAOImplementation implements EmployeeDAOInterface {
	
	private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertEmployeeDAO(Employee employee) {
        String sql = "insert into employeetable (name,skills,dateOfBirth) values(?,?,?)";
        System.out.println("Working in DAO");
        String[] skills = employee.getSkills();
        String stringSkills = String.join(", ",skills);
        return jdbcTemplate.update(sql, employee.getName(), stringSkills, employee.getDateOfBirth());
    }

	@Override
	public List<Employee> ReadAllEmployeeDAO(){
	    return jdbcTemplate.query("select * from employeetable",new RowMapper<Employee>(){
	        public Employee mapRow(ResultSet rs, int row) throws SQLException {
	        	Employee employee = new Employee();
	        	employee.setId(rs.getInt("Id"));
				employee.setName(rs.getString("name"));
				String skillsString = rs.getString("skills");
				String[] skillsArray = skillsString.split(", ");
				employee.setSkills(skillsArray);
				employee.setDateOfBirth(rs.getString("dateOfBirth"));
				return employee;
	        }
	    });
	}
	
	@Override
	public Employee ReadEmployeeByIdDAO(int id) {
		 String sql="select * from employeetable where id=?";    
		    return jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	
	public int UpdateEmployeeDAO(Employee employee){  
	    String[] skills = employee.getSkills();
	    String stringSkills = String.join(", ", skills); // Concatenate skills with comma separator
	    String sql = "update employeetable set name=?, skills=? where id=?"; // Use placeholders for parameters
	    return jdbcTemplate.update(sql, employee.getName(), stringSkills, employee.getId()); // Pass parameters to update method
	}

	@Override
	public int DeleteEmployeeDAO(int id) {
		 String sql="delete from employeetable where id="+id+"";    
		 return jdbcTemplate.update(sql);    
	}
}







//public ArrayList<Employee> readAllEmpDAO() {
//	ArrayList<Employee> list = new ArrayList<Employee>();
//	PreparedStatement stmt = null;
//	ResultSet rs = null;
//	try {
//		
//		
//		String q = "select * from EmployeeTable";
//		stmt = con.prepareStatement(q);
//		rs = stmt.executeQuery();
//		while (rs.next()) {
//			Employee employee = new Employee();
//			employee.setEmployeeID(rs.getInt("employeeID"));
//			employee.setName(rs.getString("name"));
//			employee.setAge(rs.getInt("age"));
//			employee.setSalary(rs.getInt("salary"));
//			employee.setBirthDate(rs.getString("birthDate"));
//
//			list.add(employee);
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	System.out.println("Add all data working fine in dao");
//	return list;
//}