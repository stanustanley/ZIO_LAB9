package pl.example.spring.Stanu.db;


import pl.example.spring.Stanu.Student;

import javax.persistence.*;
import java.util.Set;

@Entity
public class StudentRow
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String number;
    private String stud_group;

    public Set<ScoreRow> getScores() {
        return scores;
    }
    public void setScores(Set<ScoreRow> scores) {
        this.scores = scores;
    }

    public StudentRow(String name, String number, String stud_group)
    { this.name = name;
        this.number = number;
        this.stud_group = stud_group;
    }
    protected StudentRow()
    {

    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getNumber()
    {
        return number;
    }
    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getStud_group()
    {
        return stud_group;
    }
    public void setGroup()
    {
        this.stud_group = stud_group;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
    public Long getId()
    {
        return id;
    }

    public Student toStudent(){
        return new Student(
                this.getId(),
                this.getName(),
                this.getNumber(),
                this.getStud_group());
    }





    public void setId(long id) {
        this.id = id;
    }

    public void setStud_group(String stud_group) {
        this.stud_group = stud_group;
    }

    @OneToMany(mappedBy = "student")
    private Set<ScoreRow> scores;

}
