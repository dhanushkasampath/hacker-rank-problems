while read line;
do
    echo "$line" | cut -f 1-3
done
# Output of echo is the input to cut. This is done by pipe
