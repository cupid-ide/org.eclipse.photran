#define ECHO(x) x
#define HOOP 1
      ECHO(module) fixed_test
c       this is the first comment
c       this is the next comment
        integer :: i, j, k, long_name, even_longer_name, really_long,
     &  another_integer, finalint

        contains

        subroutine say_hello()
            ECHO(print) *, "Hello World 1"
            print ECHO(*), "Hello World 2"
            print *, ECHO("Hello World 3")
#ifndef HOOP
            print *, "Don't say hello"
#endif
        end subroutine say_hello

c       this is the final comment
      end module
