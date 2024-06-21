while read line;
do
    echo "${line}" | cut -b -4
done
# Output of echo is the input to cut. This is done by pipe

#Sample Input
#
#Hello
#World
#how are you

#Sample Output
#
#Hell
#Worl
#how
