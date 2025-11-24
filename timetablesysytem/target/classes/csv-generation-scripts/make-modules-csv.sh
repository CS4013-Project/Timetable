#!/bin/bash

# Target CSV file
file="modules.csv"

# Write headers
echo "MODULE ID,LECTURER,COURSE,LECTURE HOURS,LAB HOURS,TUTORIAL HOURS" > "$file"

# Example data as arrays
# LM121 modules (Year 1 only - this is a 1 year programme)
# LM051, LM097, LM110 share CS4013 (Year 1, Semester 1)
# Added more modules for multi-year programmes
id=("CS4141" "CS4012" "CS4221" "ET4011" "MS4111" "CS4142" "CS4182" "CS4222" "ET4012" "MA4052" "CS4013" "CS4101" "CS4115" "CS4201" "CS4202" "CS4203" "CS4301" "CS4302" "CS4303" "CS4401" "CS4402")
lecturer=("L001" "L002" "L003" "L007" "L008" "L001" "L004" "L005" "L007" "L008" "L001" "L002" "L003" "L004" "L005" "L002" "L003" "L001" "L004" "L005" "L002")
course=("LM121" "LM121" "LM121" "LM121" "LM121" "LM121" "LM121" "LM121" "LM121" "LM121" "SHARED" "SHARED" "SHARED" "LM051" "LM051" "LM051" "LM097" "LM097" "LM097" "LM110" "LM110")
lectureHours=(2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2)
labHours=(2 1 2 1 0 2 2 2 1 0 2 2 1 2 1 2 2 1 2 2 1)
tutorialHours=(1 2 0 1 2 1 1 0 1 2 1 1 1 1 2 1 1 2 1 1 2)

# Loop through data and append to CSV
for i in "${!id[@]}"; do
    echo "${id[i]},${lecturer[i]},${course[i]},${lectureHours[i]},${labHours[i]},${tutorialHours[i]}" >> "$file"
done