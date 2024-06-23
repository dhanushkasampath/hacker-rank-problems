awk '{
    if (NF<4) {
        print "Not all scores are available for "$1
    }
}'

#NF - number of fields; refer to the last column