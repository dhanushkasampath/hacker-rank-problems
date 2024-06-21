read count

temp=$count
total=0

while (( temp-- > 0 ))
do
    read num
   (( total+=$num ))
done

#echo "scale=3; $total/$count" | bc    # <- This line did not worked
printf "%.3f" "$(echo "$total / $count" | bc -l)"


#Sample Input
#
#4
#1
#2
#9
#8