# Java_Eight_Version-0.1

# Java - 8 Examples All are Covered
1. Lambda Expression

2. Functional Interface SAM(Functional interface should contain single abstract method)

    Existing Functional Interface 
    
    a. Runnable(run())
    b. Callable(call())
    c. Comparable(compareTo())
    d. ActionListener(actionPerformed()))    
    
3. default methods inside interfaces

4. static methods inside interfaces

5. Predefined Functional interfaces present in java.util.function package

  a. interface Predicate<T> {
        public boolean test(T t);
     }
    
  b. interface Function<T,R> {
        public R apply(T t);
     }
     
  c. interface Consumer<T t> {
        public void accept(T t);
     }
    
  d. interface Supplier {
        public R get();
     } 
     
6. :: operator for Method Reference and Constructor Reference (Biggest advantage is code reusablity)
  
7. Streams

  a. stream()
  b. filter(Predicate<T> p)
  c. map(Function<T,U> f)
  d. collect(Collectors.toList())
  e. count()
  f. min(Comparator c)
  g. max(Comparator c)
  h. sorted - default sorting 
  i. sorted(Comparator c) - customized sorting
  j. forEach()
  k. toArray()  
  l. Stream.of()
  
8. Date & Time API (Joda time API)

  a. LocalDate
  b. LocalTime
  c. LocalDateTime
  d. Year
  e. Period
  f. ZoneId
  g. ZonedDateTime
