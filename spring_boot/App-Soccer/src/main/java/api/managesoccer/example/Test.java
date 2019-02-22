package api.managesoccer.example;

import api.managesoccer.service.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Test {


    public static void main(String[] a) throws ParseException {
//        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        Date dateobj = new Date();
//        System.out.println(df.format(dateobj));
BCryptPasswordEncoder b = new BCryptPasswordEncoder();
System.out.println(b.encode("admin"));
    }
}
