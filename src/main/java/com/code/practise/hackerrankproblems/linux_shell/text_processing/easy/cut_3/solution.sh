while read line;
do
    echo "${line}" | cut -c 2-7
done


#Sample Input
#
#Hello
#World
#how are you

#Sample Output
#
#ello
#orld
#ow are
