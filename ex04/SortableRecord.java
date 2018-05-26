import java.util.*;

public class SortableRecord extends Record
    implements Comparable<SortableRecord>{

    SortableRecord(String id, int math, int japanese, int english){
    	super(id, math, japanese, english);
    }
    public int compareTo(SortableRecord v){
      if(score_total < v.score_total){
        return 1;
      } else return -1;
    }
}
