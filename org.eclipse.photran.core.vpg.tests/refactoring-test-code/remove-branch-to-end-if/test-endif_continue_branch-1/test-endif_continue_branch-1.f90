! With more DO and IF structures the outer GOTO
! statement should still be retargetted to the 
! existing CONTINUE statement and then remove the 
! label of the selected END IF statement.

PROGRAM test_endif_continue_branch_1
   INTEGER :: sum, i
   sum = 0
   DO 20, i = 1, 10
     IF (MOD(i,2).eq.0) THEN
       GOTO 10
     END IF
     sum = sum + i
     IF (sum.ge.100) THEN
       sum = sum + sum
       GOTO 30
10   END IF                         !<<<<< 17, 1, 17, 12, pass
20 CONTINUE
30 PRINT *, 'sum:', sum
END PROGRAM test_endif_continue_branch_1
