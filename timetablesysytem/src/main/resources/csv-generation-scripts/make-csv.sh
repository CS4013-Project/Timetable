
# Target CSV file
file="output.csv"

# Write headers
echo "Name,Age,City" > "$file"

# Example data as arrays
names=("Alice" "Bob" "Charlie")
ages=(30 25 35)
cities=("New York" "Los Angeles" "Limerick")

# Loop through data and append to CSV
for i in "${!names[@]}"; do
    echo "${names[i]},${ages[i]},${cities[i]}" >> "$file"
done
