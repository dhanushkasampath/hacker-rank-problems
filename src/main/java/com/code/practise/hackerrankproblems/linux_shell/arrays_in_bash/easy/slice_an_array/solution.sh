#! /usr/bin/bash

readarray -t arr #read inputs line by line for the array

start_index=3
end_index=8

length=$(( end_index - start_index ))

slicedArray="${arr[@]:start_index:length}" # we can slice an array by passing these arguments

# Then iterate over the new array
for country in "${slicedArray[@]}"
do
    echo -e "$country \c"
done