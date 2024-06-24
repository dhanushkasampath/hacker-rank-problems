#!/usr/bin/bash -x

readarray arr

# Loop through the array and add only needed elements to new array
filtered=()
for element in "${arr[@]}"; do
  filtered+=$(echo "$element" | grep -E -i -v '\b\w*[a]\w*\b')
done

# Print the filtered elements array
echo "${filtered[@]}"

# -v is used to negate the result
#'\b\w*[a]\w*\b'  this is the pattern responsible for extracting words with a or A.
# This question needs the reverse of that