#!/bin/bash
# Input: number of lines (e.g., 5)
read -p "Enter the number: " n

# First part: Incrementing pattern
for ((i=1; i<=n; i++))
do
  for ((j=1; j<=i; j++))
  do
    echo -n "*"
  done
  echo ""
done

# Second part: Decrementing pattern
for ((i=n-1; i>=1; i--))
do
  for ((j=1; j<=i; j++))
  do
    echo -n "*"
  done
  echo ""
done
