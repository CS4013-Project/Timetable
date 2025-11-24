#!/bin/bash

# Target CSV file
file="faculties.csv"

# Write headers
echo "FACULTY ID,NAME,BUILDING" > "$file"

# Example data as arrays
id=("CSIS" "ENG" "SCI")
name=("COMPUTER SCIENCE AND INFORMATION SYSTEMS" "ENGINEERING" "SCIENCE")
building=("CSG" "EG" "KBG")

# Loop through data and append to CSV
for i in "${!id[@]}"; do
    echo "${id[i]},${name[i]},${building[i]}" >> "$file"
done