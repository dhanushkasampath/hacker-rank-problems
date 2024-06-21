while read line;
do
    echo "$line" | cut -d ' ' -f -3
done

# when you want 1st 3 words use -3
# when you want words from 3rd word use 3-
