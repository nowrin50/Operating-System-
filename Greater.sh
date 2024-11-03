#!/bin/bash

echo "Enter a number:"
read num

if [ $num -gt 100 ]; then
    echo "CENTURY"
else
    echo "Getting There"
fi
