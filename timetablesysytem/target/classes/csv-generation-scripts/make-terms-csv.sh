#!/bin/bash

# Target CSV file
file="terms.csv"

# Write headers
echo "DAY,TIME,MODULE CODE,CLASS TYPE,ROOM,LECTURER,COURSE,YEAR,TERM" > "$file"

# TERM 1

# MONDAY Term 1
day=("MON" "MON" "MON" "MON" "MON" "MON")
time=("09:00-11:00" "11:00-13:00" "13:00-15:00" "14:00-15:00" "15:00-16:00" "16:00-18:00")
moduleCode=("CS4012" "CS4013" "CS4301" "CS4012" "CS4013" "CS4012")
classType=("LECTURE" "LECTURE" "LECTURE" "TUTORIAL" "TUTORIAL" "LAB")
room=("CSG001" "KBG12" "CSG001" "CSG027" "CSG027" "CS1044")
lecturer=("L002" "L001" "L003" "L002" "L001" "L002")
course=("LM121" "LM051" "LM097" "LM121" "LM051" "LM121")
year=(1 1 3 1 1 1)
term=(1 1 1 1 1 1)

# TUESDAY Term 1
day+=("TUE" "TUE" "TUE" "TUE" "TUE" "TUE")
time+=("09:00-10:00" "10:00-12:00" "11:00-13:00" "13:00-15:00" "14:00-16:00" "15:00-17:00")
moduleCode+=("CS4013" "CS4141" "CS4201" "CS4013" "CS4141" "CS4301")
classType+=("TUTORIAL" "LECTURE" "LAB" "LAB" "LAB" "LAB")
room+=("CSG027" "CSG028" "CS2044" "CS2044" "CS2044" "CS2044")
lecturer+=("L001" "L001" "L004" "L001" "L001" "L003")
course+=("LM097" "LM121" "LM051" "LM051" "LM121" "LM097")
year+=(1 1 2 1 1 3)
term+=(1 1 1 1 1 1)

# WEDNESDAY Term 1
day+=("WED" "WED" "WED" "WED" "WED" "WED" "WED")
time+=("09:00-10:00" "09:00-11:00" "10:00-12:00" "11:00-13:00" "13:00-14:00" "14:00-15:00" "15:00-17:00")
moduleCode+=("CS4221" "CS4201" "CS4101" "CS4221" "CS4201" "CS4101" "CS4303")
classType+=("LECTURE" "LECTURE" "LECTURE" "LAB" "TUTORIAL" "TUTORIAL" "LAB")
room+=("CSG001" "CSG001" "CSG028" "CS3005B" "CSG027" "CSG027" "CS1045")
lecturer+=("L003" "L004" "L002" "L003" "L004" "L002" "L004")
course+=("LM121" "LM051" "LM051" "LM121" "LM051" "LM051" "LM097")
year+=(1 2 1 1 2 1 3)
term+=(1 1 1 1 1 1 1)

# THURSDAY Term 1
day+=("THU" "THU" "THU" "THU" "THU" "THU" "THU")
time+=("09:00-11:00" "10:00-11:00" "11:00-13:00" "13:00-15:00" "14:00-15:00" "15:00-16:00" "16:00-18:00")
moduleCode+=("CS4101" "ET4011" "CS4202" "ET4011" "CS4101" "ET4011" "CS4303")
classType+=("LECTURE" "TUTORIAL" "LECTURE" "LECTURE" "LAB" "LAB" "LAB")
room+=("CSG001" "CSG029" "CSG028" "CSG028" "CS1044" "EG002" "CS1045")
lecturer+=("L002" "L007" "L005" "L007" "L002" "L007" "L004")
course+=("LM110" "LM121" "LM051" "LM121" "LM110" "LM121" "LM097")
year+=(1 1 2 1 1 1 3)
term+=(1 1 1 1 1 1 1)

# FRIDAY Term 1
day+=("FRI" "FRI" "FRI" "FRI" "FRI" "FRI" "FRI" "FRI")
time+=("09:00-11:00" "10:00-11:00" "11:00-12:00" "13:00-14:00" "13:00-15:00" "14:00-16:00" "15:00-17:00" "16:00-17:00")
moduleCode+=("MS4111" "CS4115" "CS4202" "MS4111" "CS4202" "CS4115" "MS4111" "CS4401")
classType+=("LECTURE" "LECTURE" "TUTORIAL" "TUTORIAL" "LAB" "LAB" "TUTORIAL" "LECTURE")
room+=("KBG12" "CSG029" "CSG027" "CSG027" "CS1044" "CS1045" "CSG029" "KBG12")
lecturer+=("L008" "L003" "L005" "L008" "L005" "L003" "L008" "L005")
course+=("LM121" "LM051" "LM051" "LM121" "LM051" "LM051" "LM121" "LM110")
year+=(1 1 2 1 2 1 1 4)
term+=(1 1 1 1 1 1 1 1)

# TERM 2

# MONDAY Term 2
day+=("MON" "MON" "MON" "MON")
time+=("09:00-11:00" "11:00-13:00" "10:00-12:00" "15:00-17:00")
moduleCode+=("CS4201" "MA4052" "CS4203" "MA4052")
classType+=("TUTORIAL" "LECTURE" "LECTURE" "TUTORIAL")
room+=("CSG027" "KBG12" "CSG028" "CSG027")
lecturer+=("L004" "L008" "L002" "L008")
course+=("LM051" "LM121" "LM051" "LM121")
year+=(2 1 2 1)
term+=(2 2 2 2)

# TUESDAY Term 2
day+=("TUE" "TUE" "TUE" "TUE" "TUE" "TUE")
time+=("09:00-10:00" "09:00-11:00" "10:00-12:00" "13:00-14:00" "14:00-16:00" "15:00-17:00")
moduleCode+=("MA4052" "CS4142" "CS4202" "CS4142" "CS4203" "CS4142")
classType+=("TUTORIAL" "LECTURE" "TUTORIAL" "TUTORIAL" "LAB" "LAB")
room+=("CSG029" "CSG001" "CSG027" "CSG027" "CS2044" "CS1044")
lecturer+=("L008" "L001" "L005" "L001" "L002" "L001")
course+=("LM121" "LM121" "LM051" "LM121" "LM051" "LM121")
year+=(1 1 2 1 2 1)
term+=(2 2 2 2 2 2)

# WEDNESDAY Term 2
day+=("WED" "WED" "WED" "WED" "WED")
time+=("09:00-11:00" "10:00-12:00" "13:00-14:00" "14:00-16:00" "15:00-17:00")
moduleCode+=("CS4302" "CS4182" "CS4222" "CS4182" "CS4301")
classType+=("LECTURE" "LECTURE" "TUTORIAL" "LAB" "TUTORIAL")
room+=("CSG001" "CSG028" "CSG027" "CS2044" "CSG027")
lecturer+=("L001" "L004" "L005" "L004" "L003")
course+=("LM097" "LM121" "LM121" "LM121" "LM097")
year+=(3 1 1 1 3)
term+=(2 2 2 2 2)

# THURSDAY Term 2
day+=("THU" "THU" "THU" "THU" "THU")
time+=("09:00-10:00" "09:00-11:00" "11:00-13:00" "13:00-15:00" "16:00-17:00")
moduleCode+=("CS4401" "CS4222" "ET4012" "CS4222" "CS4182")
classType+=("TUTORIAL" "LECTURE" "LAB" "LAB" "TUTORIAL")
room+=("CSG027" "CSG001" "EG002" "CS3005B" "CSG027")
lecturer+=("L005" "L005" "L007" "L005" "L004")
course+=("LM110" "LM121" "LM121" "LM121" "LM121")
year+=(4 1 1 1 1)
term+=(2 2 2 2 2)

# FRIDAY Term 2
day+=("FRI" "FRI" "FRI" "FRI" "FRI")
time+=("09:00-10:00" "10:00-12:00" "11:00-12:00" "13:00-15:00" "14:00-16:00")
moduleCode+=("CS4182" "ET4012" "CS4402" "CS4302" "MA4052")
classType+=("LECTURE" "LECTURE" "LECTURE" "LAB" "LECTURE")
room+=("CSG001" "CSG029" "KBG12" "CS1044" "KBG14")
lecturer+=("L004" "L007" "L002" "L001" "L008")
course+=("LM121" "LM121" "LM110" "LM097" "LM121")
year+=(1 1 4 3 1)
term+=(2 2 2 2 2)

# Loop through data and append to CSV
for i in "${!day[@]}"; do
    echo "${day[i]},${time[i]},${moduleCode[i]},${classType[i]},${room[i]},${lecturer[i]},${course[i]},${year[i]},${term[i]}" >> "$file"
done