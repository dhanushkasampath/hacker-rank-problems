readarray array
echo ${array[@]/[A-Z]/.}



# array[@]: This represents all the elements of the array named array.

# /[A-Z]/.: This is the pattern replacement part of the parameter expansion:

# [A-Z]: This specifies a character class matching any uppercase letter from A to Z.
# .: This is the replacement string, which is a single period (dot).
# ${array[@]/[A-Z]/.}: This performs a pattern replacement on each element of the array. For each element in the array:

# It searches for the first occurrence of any uppercase letter (A-Z).
# It replaces the first occurrence of that uppercase letter with a period (dot).
# echo: This prints the modified elements to the standard output.