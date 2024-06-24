package pointing.system;

public interface TriFunction<T, R, S, U> {
  U apply(T arg1, R arg2, S arg3);
}
