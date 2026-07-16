package Student.Condition;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	
	@Autowired
	StudentRepository rep;
	
	@PutMapping("/cont/{id}")
	
	public String updateStudent(@PathVariable Integer id,@RequestBody Student student) {
		
		 Optional<Student> optional = rep.findById(id);

	        if (optional.isPresent()) {

	            Student s = optional.get();

	            s.setName(student.getName());

	            rep.save(s);

	            return "Student Updated Successfully";
		
	}
	
	
	        return "Student Not Found";
	

}
