SELECT user_id,
CONCAT(UPPER(SUBSTRING(name, 1, 1)), LOWER(SUBSTRING(name, 2))) AS name
FROM Users
ORDER BY user_id;

--SUBSTRING(name, 1, 1): This function extracts the first character of the name column.
--UPPER(...): This function converts the first character to uppercase.
--SUBSTRING(name, 2): This function extracts the characters starting from the second character of the name column.
--LOWER(...): This function converts the rest of the characters to lowercase.
--CONCAT(...): This function concatenates the uppercase first character with the lowercase rest of the string.