#!/bin/bash

find_missing_number() {
    numbers=("$@")  
    n=${#numbers[@]} 

    expected_sum=$((n * (n + 1) / 2))

    actual_sum=0
    for num in "${numbers[@]}"; do
        actual_sum=$((actual_sum + num))
    done

    missing_number=$((expected_sum - actual_sum))

    echo $missing_number
}
