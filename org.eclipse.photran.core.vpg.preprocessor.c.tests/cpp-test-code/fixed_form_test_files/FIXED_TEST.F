#define HOOP 1
      p r ogr  am fixed_test
c       this is the first comment
c       this is the next comment
        integer :: i, j, k, long_name, even_longer_name, really_long,
     &  another_integer, finalint

        print *, "Hello World"
c       this is the third comment
#ifdef FUZZY_WUZZY
        print *, "This should not be here"
#endif
c       this is the final comment
      end program
