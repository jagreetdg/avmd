import java.util.*;
 public class DateInfo
    {   
        private String[] d;
        private String day,date,time;
        public DateInfo()
        {
        this.d = new Date().toString().split(" ");
        this.day = d[0];
        this.date = d[2]+" "+d[1]+" "+d[5];
        this.time = d[3];
        }
        public String getDay(){return this.day;}
        public String getDate(){return this.date;}
        public String getTime(){return this.time;}
    }
