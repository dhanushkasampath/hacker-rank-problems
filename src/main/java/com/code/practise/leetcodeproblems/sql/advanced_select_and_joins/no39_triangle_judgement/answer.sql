SELECT x,y,z, IF(((x+y)>z AND (y+z)>x AND (x+z)>y), "Yes", "No") AS triangle
FROM Triangle;

-- Triangle Inequality Theorem → for a triangle to be formed, the sum of the lengths of any two sides must be
--greater than (or equal to) the length of the third side.