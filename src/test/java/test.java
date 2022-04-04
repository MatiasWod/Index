import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

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

        @Test
        public void quicksortTest(){
                quicksort a=new quicksort();
                a.initialize( new int[] {100, 50, 30, 50, 80, 100, 100, 30} );
                a.sortedPrint();
                int[] rta= a.range(50, 100, false, false); // [80]
                System.out.println(rta.toString());
                rta= a.range(50, 100, true, false); // [50, 50, 80]
                System.out.println(rta.toString());
                rta= a.range(50, 100, false, true); // [80, 100, 100, 100]
                System.out.println(rta.toString());
                rta= a.range(30, 50, true, false); // [30, 30]
                System.out.println(rta.toString());
                rta= a.range(45, 100, false, false); // [50, 50, 80]
                System.out.println(rta.toString());
                rta= a.range(45, 100, true, false); // [50, 50, 80]
                System.out.println(rta.toString());
                rta= a.range(45, 100, false, true); // [50, 50, 80, 100, 100, 100]
                System.out.println(rta.toString());
                rta= a.range(10, 50, true, false); // [30, 30]
                System.out.println(rta.toString());
                rta= a.range(10, 50, false, false); // [30, 30]
                System.out.println(rta.toString());
                rta= a.range(10, 20, false, false); // []
                System.out.println(rta.toString());
                rta= a.range(47, 45, false, false); // []
                System.out.println(rta.toString());
                rta= a.range(120, 120, true, true); // []
                System.out.println(rta.toString());
                rta= a.range(80, 80, false, false); // []
                System.out.println(rta.toString());
                rta= a.range(80, 81, true, false); // [80]
                System.out.println(rta.toString());
                rta= a.range(80, 81, false, false); // []
                System.out.println(rta.toString());
        }



}
