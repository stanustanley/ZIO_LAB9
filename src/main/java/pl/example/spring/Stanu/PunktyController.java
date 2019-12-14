package pl.example.spring.Stanu;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/punkty")
public class PunktyController
{
    private final StudentService studentService;

    public PunktyController(StudentService studentService)
    {
        this.studentService = studentService;
    }


    private CopyOnWriteArrayList<String> users= new CopyOnWriteArrayList<>();
    {
        this.users.addAll(Arrays.asList("Artur Osmanowski","Janusz Mikke","Andrzej Nowak","Karol Krawczyk","Tadeusz Norek"));
    }

    @RequestMapping( value = "/students", method = RequestMethod.GET)
    public List<Student> getUsers()
    {

        return studentService.getStudents().asJava();
    }


    @PostMapping( value ="/students/add",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student addStudent(@RequestBody NewStudent student)
    {
        return studentService.addStudent(student);
    }

    @RequestMapping( value = "/students/{id}/number/{number}", produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student setNumber(@PathVariable("id") long id, @PathVariable("number") String number)
    {
        return this.studentService.changeNumber(id, number).orElseThrow(
                () -> new IllegalArgumentException("Student o id: " + id + " does not exist") );    }

    @RequestMapping (value = "/students/{id}/scores", produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addScore(@RequestBody Score score, @PathVariable("id") long id ) {
        return this.studentService.addScore(id, score).
                orElseThrow(()->new NoStudentException(id));

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class NoStudentException extends RuntimeException
    {
        public NoStudentException(long id) {
            super("Student o id :"+id+" does not exists");}
    }



}


