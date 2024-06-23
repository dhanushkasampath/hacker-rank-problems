sed s/thy/{\&}/gi

# s: This is the substitute command in sed.

# thy: This is the search pattern, specifying the string to be replaced. In this case, it looks for the word "thy".

# {\&}: This is the replacement string. The & character represents the entire match of the search pattern. Thus, {\&} means to replace the match with itself enclosed in curly braces {}. The backslash \ is used to escape the & character so that sed interprets it correctly as the matched text.

# g: This flag stands for global replacement, meaning all occurrences of the search pattern in each line will be replaced, not just the first one.

# i: This flag makes the search case-insensitive, so it will match "thy", "Thy", "tHy", "THY", etc.
