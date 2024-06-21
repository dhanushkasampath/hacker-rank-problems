#! /usr/bin/bash

readarray -t arr

new_array=("${arr[@]} ${arr[@]} ${arr[@]}")  # this is how we can concatenate

for countries in "${new_array[@]}"
do
    echo -e "$countries \c"
done


#Sample Input
#
#Namibia
#Nauru
#Nepal
#Netherlands
#NewZealand
#Nicaragua
#Niger
#Nigeria
#NorthKorea
#Norway