# search for the specific word in a file; n means line, v means without, i means ignore the case
grep -n  'word' file.txt
grep -vn 'word' file.txt
grep -in 'word' file.txt
# use [] as ? for example: g[eo]t equals get or got; [^g]oo means no oo start with g; [^a-z]oo means no oo start with lower case
grep -n 't[ae]st' file.txt
grep -n '[^g]oo' file.txt 
grep -n '[^a-z]oo' file.txt
grep -n '[^[:lower:]]' file.txt #same as the prevous commands
# use ^ to express at the beginning of the sentence, use $ to express at the end of the sentence
grep -n '^[^a-zA-Z]' file.txt #the sentence without English character at the beginning of the sentence
grep -n '^[^[:alpha:]]' file.txt #same as the previous commands
grep -n '\.$' file.txt #the sentence endding with '.'
grep -n '^$' file.txt  #find the empty line

