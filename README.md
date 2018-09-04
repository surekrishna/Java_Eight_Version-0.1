# Java_Eight_Version-0.1

# Java - 8 Examples All are Covered
1. Lambda Expression

2. Functional Interface SAM(Functional interface should contain single abstract method)
    Existing Functional Interface 
    1. Runnable(run())
    2. Callable(call())
    3. Comparable(compareTo())
    4. ActionListener(actionPerformed()))    
    
3. default methods inside interfaces

4. static methods inside interfaces

5. Predefined Functional interfaces present in java.util.function package
  1. interface Predicate<T> {
        public boolean test(T t);
     }
  2. interface Function<T,R> {
        public R apply(T t);
     }
  3. interface Consumer<T t> {
        public void accept(T t);
     }
  4. interface Supplier {
        public R get();
     } 
6. :: operator for Method Reference and Constructor Reference (Biggest advantage is code reusablity)
  
7. Streams
  1. stream()
  2. filter(Predicate<T> p)
  3. map(Function<T,U> f)
  4. collect(Collectors.toList())
  5. count()
  6. min(Comparator c)
  7. max(Comparator c)
  8. sorted - default sorting 
  9. sorted(Comparator c) - customized sorting
  10. forEach()
  11. toArray()  
  12. Stream.of()
  
8. Date & Time API (Joda time API)
  1. LocalDate
  2. LocalTime
  3. LocalDateTime
  4. Year
  5. Period
  6. ZoneId
  7. ZonedDateTime
