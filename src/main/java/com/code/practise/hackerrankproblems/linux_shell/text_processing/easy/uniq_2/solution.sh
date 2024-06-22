uniq -c | tr -s " " | cut -c 2-

#uniq -c   -  This is to get the lines with its count. and it is passed to tr
#tr -s " "  - This is to squeeze spaces and make it a one spaces
#cut -c 2-   -  This is to extract the lines from 2nd character to the end of the line