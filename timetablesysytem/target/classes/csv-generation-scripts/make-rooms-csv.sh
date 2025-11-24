#!/bin/bash

# Target CSV file
file="rooms.csv"

# Write headers
echo "ROOM ID,ROOM TYPE,CAPACITY,BUILDING" > "$file"

# Example data as arrays
id=("CSG001" "CSG027" "CSG028" "CSG029" "CS1044" "CS2044" "CS3005B" "CS1045" "KBG12" "KBG14" "EG001" "EG002")
type=("TEACHING" "TEACHING" "TEACHING" "TEACHING" "LAB" "LAB" "LAB" "LAB" "TEACHING" "TEACHING" "TEACHING" "LAB")
capacity=(250 35 40 45 35 40 30 35 500 300 100 25)
building=("CSG" "CSG" "CSG" "CSG" "CSG" "CSG" "CSG" "CSG" "KBG" "KBG" "EG" "EG")

# Loop through data and append to CSV
for i in "${!id[@]}"; do
    echo "${id[i]},${type[i]},${capacity[i]},${building[i]}" >> "$file"
done