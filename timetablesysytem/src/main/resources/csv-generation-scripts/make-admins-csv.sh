#!/bin/bash

# Target CSV file
file="admins.csv"

# Write headers
echo "ID,E-MAIL,PASSWORD" > "$file"

# Example data as arrays
id=("0001" "0002" "0003")
email=("ADMIN@UL.IE" "REGISTRAR@UL.IE" "TIMETABLE@UL.IE")
password=("adminULdotIE" "123" "password")

# Loop through data and append to CSV
for i in "${!id[@]}"; do
    echo "${id[i]},${email[i]},${password[i]}" >> "$file"
done