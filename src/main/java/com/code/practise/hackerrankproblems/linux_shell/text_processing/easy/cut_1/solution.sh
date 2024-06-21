while read line;
do
    echo "${line}" | cut -c3
done

# The pipe operator | takes the output from the command on its left (echo "${line}") and passes it as input to
# the command on its right (cut -c3).

#cut -c3: The cut command with the -c3 option extracts the third character from each line of its input.


#Sample Input
#
#Hello
#World
#how are you