awk '{
    avg=($2+$3+$4)/3;
    grade="";

    if (avg < 50 ) {
        grade="FAIL"
    } else if (50<= avg && avg < 60) {
        grade="C"
    } else if (60<= avg && avg < 80) {
        grade="B"
    } else {
        grade="A"
    };

    print $1, $2, $3, $4, ":" ,grade
 }'


# ; is used at the end of a statement
# , id used as a space