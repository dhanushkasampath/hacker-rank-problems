read X
read Y
read Z

if [[ $X == $Y && $X == $Z && $Y == $Z ]]
then
    echo "EQUILATERAL"
elif [[ $X != $Y && $X != $Z && $Y != $Z ]]
then
   echo "SCALENE"
else
    echo "ISOSCELES"
fi