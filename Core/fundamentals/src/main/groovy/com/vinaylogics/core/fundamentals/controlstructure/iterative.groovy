package com.vinaylogics.core.fundamentals.controlstructure

def printStartLine(String functionName){
    println("=============== ${functionName} ================")
}

def printEndLine(){
    println("================================================")
}

def checkFor(){
   printStartLine("Checking For Loop")
    for (i in 1..10) {
        println i
    }
   printEndLine()
}

def checkWhile() {
    printStartLine("Check While Loop")
    def i = 1
    while (i <=10) {
        println i++
    }
    printEndLine()
    printStartLine("Check While Loop")
    i = 1
    while (true) {
        println i++
        if (i >10)
            break
    }
    printEndLine()
}

def checkDoWhile() {
    printStartLine("Check do while")
    def i = 1
    do {
        println i ++
    }while (i<=10)
    printEndLine()
}

checkFor()
checkWhile()
checkDoWhile()
