package utilits;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Created by root on 15.06.17.
 */
public class MyArray<E> extends ArrayList<E> {

    public MyArray<E> findAll(Predicate<E> p){
        MyArray<E> answer = new MyArray<E>();
        for(Object o:this.toArray())
            if(p.test((E) o))
                answer.add((E) o);
        return answer;
    }

    public E firstFind(Predicate<E> p){
        for(Object o:this.toArray())
            if(p.test((E) o))
                return (E) o;
        return null;
    }


    public boolean addAll(E[] e){
        for(E o: e)
            this.add(o);
        return true;
    }

    public E last(){
        return this.get(this.size() -1);
    }

    public boolean containsSuchThat(Predicate<E> p){
        boolean answer = false;
        for(E o: this) {
            if (p.test(o)) {
                answer = true;
                break;
            }
        }

        return answer;
    }
}
