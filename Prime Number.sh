#!/bin/bash

is_prime() {
    number=$1

    if [ $number -le 1 ]; then
        echo "Not a Prime number"
        return
    fi

    for ((i=2; i*i<=number; i++)); do
        if [ $((number % i)) -eq 0 ]; then
            echo "Not a Prime number"
            return
        fi
    done

    echo "Prime number"
}

