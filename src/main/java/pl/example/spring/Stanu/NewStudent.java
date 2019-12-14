package pl.example.spring.Stanu;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewStudent
{
    @JsonProperty("name")  final String name;
    @JsonProperty("stud_group") final String stud_group;
    @JsonProperty("number") final String number;

    public NewStudent(long id, String name, String stud_group, String number)
    {
        this.name = name;
        this.stud_group = stud_group;
        this.number = number;
    }

}
