@interface SimpleTest {
    String created();
    String createdBy();
    String lastModified();
    String lastModifiedBy();
    int revision();
}

@SimpleTest(
	    created = "June 8 2018",
	    createdBy = "Kanta Maeda",
	    lastModified = "",
	    lastModifiedBy = "",
	    revision = 1
	    )
	    public class SimpleTest{
		public static void main(String srv[]){
		    System.out.println("Success");
		}
	    }
