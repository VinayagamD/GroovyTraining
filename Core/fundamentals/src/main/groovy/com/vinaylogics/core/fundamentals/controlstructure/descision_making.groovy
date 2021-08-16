package com.vinaylogics.core.fundamentals.controlstructure

/*
  Decision making
  if
  if else
  if else if
  switch case
*/

def checkIf() {
    if (true) {
        println "This statement will print since if is true"
    }

    if (false) {
        println "Non executed block"
    }

    if (true)
        println "This single block if"
}


def checkIfElse() {
    def condition = false
    if (condition) {
        println "If else - if block executed"
    } else {
        println "If else - else block executed"

    }
}

def checkIfElseIf() {
    def data = 21
    if (data < 5) {
        println "Enter data is less than 5"
    } else if (data == 5) {
        println "Enter data is exactly 5"
    } else if (data > 5 && data < 10) {
        println "Enter data is between 5 to 10"
    } else if (data == 10) {
        println "Enter data is 10"
    } else {
        println "Data is greater than 10"
    }
}

def checkSwitchCase() {
    def day = "Holiday"
    switch (day) {
        case ["Sun", "Sunday", "SUN","sun"]:
            println "Today is sunday"
            break
        case "Mon":
            println "Today is monday"
            break
        case "Tue":
            println "Today is tuesday"
            break
        case "Wed":
            println "Today is wednesday"
            break
        case "Thu":
            println "Today is sunday"
            break
        case "Fri":
            println "Today is sunday"
            break
        case "Sat":
            println "Today is sunday"
            break
        default:
            println "Invalid day"
    }
}

checkIf()
checkIfElse()
checkIfElseIf()
checkSwitchCase()