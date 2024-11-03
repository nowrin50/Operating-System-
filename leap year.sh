#!/bin/bash

current_year=$(date +%Y)

is_leap_year() {
    year=$1
    if (( year % 400 == 0 )); then
        return 0
    elif (( year % 100 == 0 )); then
        return 1
    elif (( year % 4 == 0 )); then
        return 0
    else
        return 1
    fi
}

find_nearest_leap_year() {
    year=$1

    while true; do
        if is_leap_year $year; then
            echo "The nearest leap year is: $year"
            break
        fi
        year=$(( year + 1 ))
    done
}


find_nearest_leap_year $current_year
