#!/bin/bash

echo "Enter the first number:"
read num1

echo "Enter the second number:"
read num2

sum=$((num1 + num2))
diff=$((num1 - num2))
prod=$((num1 * num2))
if [ $num2 -ne 0 ]; then
    div=$(echo "scale=2; $num1 / $num2" | bc)
else
    div="Division by zero not possible"
fi

echo "Addition: $sum"
echo "Subtraction: $diff"
echo "Multiplication: $prod"
echo "Division: $div"
