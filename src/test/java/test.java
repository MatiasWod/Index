import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class test {

        @Test
        public void TestIndexWithDuplicates(){
                IndexService myIndex=new IndexWithDuplicates();
                Assertions.assertEquals(0,myIndex.occurrences( 10 ));      // se obtiene 0
                myIndex.delete( 10 ); // ignora
                Assertions.assertEquals(false, myIndex.search( 10 ) ); // se obtiene false
                myIndex.insert( 80 ); // almacena [80]
                myIndex.insert( 20 ); // almacena [20, 80]
                myIndex.insert( 80 ); // almacena [20, 80, 80]
                // sigue con lo anterior
                myIndex.search( 20 );
                myIndex.occurrences(80);
                Assertions.assertEquals(2,myIndex.occurrences( 80 )); // se obtiene 2
                // el índice posee [30, 30, 50, 50, 80, 100, 100, 100]
                Assertions.assertEquals(false,myIndex.search( 20 )); // se obtiene false
                myIndex.search(80);
                Assertions.assertEquals(true, myIndex.search( 80 )); // se obtiene true
                myIndex.delete(80);
                myIndex.occurrences(80);

        }



}
