#!/bin/bash

# Target CSV file
file="students.csv"

# Write headers
echo "ID,NAME,COURSE,YEAR" > "$file"

# Example data as arrays
id=("S001" "S002" "S003" "S004" "S005" "S006" "S007" "S008" "S009" "S010" "S011" "S012" "S013" "S014" "S015" "S016" "S017" "S018" "S019" "S020")
name=("ALICE SMITH" "BOB JONES" "CHARLIE BROWN" "DIANA PRINCE" "ETHAN HUNT" "FIONA GREEN" "GEORGE LUCAS" "HANNAH WHITE" "IAN MALCOLM" "JULIA ROBERTS" "KEVIN HART" "LAURA PALMER" "MIKE ROSS" "NINA SIMONE" "OSCAR WILDE" "PATRICIA CLARK" "QUINN TAYLOR" "RACHEL GREEN" "SEAN MURPHY" "TARA FITZGERALD")
course=("LM121" "LM121" "LM121" "LM051" "LM051" "LM051" "LM097" "LM097" "LM110" "LM110" "LM086" "LM086" "LM051" "LM097" "LM110" "LM051" "LM097" "LM110" "LM086" "LM121")
year=(1 1 1 1 1 2 1 2 1 3 1 2 3 4 2 4 3 4 2 1)

# Loop through data and append to CSV
for i in "${!id[@]}"; do
    echo "${id[i]},${name[i]},${course[i]},${year[i]}" >> "$file"
done