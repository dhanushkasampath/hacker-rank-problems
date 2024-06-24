#!/usr/bin/bash

# Read number of elements (N)
read N

# Read array elements
read -a arr

# Sort the array numerically
arr=($(printf "%s\n" "${arr[@]}" | sort -n))

# Loop to remove consecutive duplicates
i=0
while [[ $i -lt $((${#arr[@]} - 1)) ]]; do
    if [[ ${arr[i]} == ${arr[i+1]} ]]; then
        unset arr[i]
        unset arr[i+1]
        arr=("${arr[@]}")  # Rebuild the array to re-index it
        ((i--))  # Move one step back to recheck the previous element
    fi
    ((i++))
done

# Print the final array
echo "${arr[@]}"