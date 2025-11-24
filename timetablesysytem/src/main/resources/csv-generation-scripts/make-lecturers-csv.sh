#!/bin/bash

# Target CSV file
file="lecturers.csv"

# Write headers
echo "ID,NAME,FACULTY" > "$file"

# Example data as arrays
id=("L001" "L002" "L003" "L004" "L005" "L006" "L007" "L008" "L009" "L010")
name=("YALE HARVARD" "SARAH BEECHAM" "JIM BUCKLEY" "OISIN CAWLEY" "MIKE SCOTT" "EMMA MURPHY" "PATRICK RYAN" "MARY HAYES" "TOM MCCARTHY" "LISA BURKE")
faculty=("CSIS" "CSIS" "CSIS" "CSIS" "CSIS" "CSIS" "ENG" "SCI" "CSIS" "CSIS")

# Loop through data and append to CSV
for i in "${!id[@]}"; do
    echo "${id[i]},${name[i]},${faculty[i]}" >> "$file"
done