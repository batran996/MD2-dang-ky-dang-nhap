package sevice;

import java.util.List;

public interface IGernericService<T>{
    List<T> findAll();
    void  save(T t);



}
