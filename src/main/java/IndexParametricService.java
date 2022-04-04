
public interface IndexParametricService <T extends Comparable<? super T>>{

    // elements serán los valores del índice, los anteriores se descartan
    // lanza excepction si elements is null o si alguno de los elementos del
    // arreglo proporcionado son null
    void initialize(T [] elements);

    // busca una key en el índice, O(log2 N)
    boolean search(T key);

    // inserta el key en pos correcta. Crece automáticamente de a chunks.
    // si el valor proporcionado es null, ignora el pedido.
    void insert(T key);

    // borra el key si lo hay, sino lo ignora.
    // decrece automáticamente de a chunks
    void delete(T key);
