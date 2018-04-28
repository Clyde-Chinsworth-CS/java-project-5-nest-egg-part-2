#!/bin/bash

# run program

echo Enter annual salary: 
read varSal

echo Enter percentage of salary to put into savings annually:
read varSave

echo Enter amount of years to save \for\:
read varYears

echo Enter amount of years \until retirement\: \(OPTIONAL\)
read varRetire

if [ -n $varRetire ]
then
	echo Enter annual expenses\: \(OPTIONAL, WILL CALCULATE IF NO INPUT\)
	read varExpense
fi

echo Enter annual inflation rate\: \(OPTIONAL\)
read varInfla

echo $varSal $varSave $varYears $varRetire $varExpense $varInfla


