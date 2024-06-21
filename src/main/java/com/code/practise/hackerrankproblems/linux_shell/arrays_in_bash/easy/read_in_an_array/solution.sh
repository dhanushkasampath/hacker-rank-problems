readarray -t arr

for item in "${arr[@]}"
do
    echo -e "$item \c"
done

#sample input
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