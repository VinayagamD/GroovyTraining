package com.vinaylogics.core.fundamentals_assigment;
/*
 * Welcome Message
 * Thank You Message
 * Ask for input
 * Default range is 10
 * print the table
 * thank you message
 */
class TablesDemo {
    static final def scanner = new Scanner(System.in)

    static def welcomeMessage() {
        println "**********************************************************"
        println "********* Welcome to my calculator application ***********"
    }

    static def displayThanks() {
        println "*********** Thank You For Using Our Application **********"
        println "********************* Visit Us Back **********************"
        println "**********************************************************"
    }

    static int askForInput(String input) {
        println "Enter value for ${input}"
        return scanner.nextInt()
    }

    static boolean askForContinue() {
        println "Enter YES or Y to perform another table"
        def enterOption = scanner.next()
        return enterOption.equalsIgnoreCase("yes") || enterOption.equalsIgnoreCase("y")
    }

    static def printTable(int value,int range = 10 ){
        println()
        println "------------------------------------------"
        for(def i in 1..range){
            println "${value} X ${i} = ${i*value}"
        }
        println "------------------------------------------"
        println()
    }

    static boolean customRange() {
        println "Enter YES or Y to define custom range"
        def enterOption = scanner.next()
        return enterOption.equalsIgnoreCase("yes") || enterOption.equalsIgnoreCase("y")
    }

    static boolean validateRange(int range){
        return range > 0
    }

    static def runApplication(){
        welcomeMessage()
        boolean continueOption
        do {
            def customRangeOption = customRange()
            def value = askForInput("Value")
            if (customRangeOption) {
                def range = askForInput("range")
                if (validateRange(range)) {
                    printTable(value, range)
                } else {
                    println "You have entered invalid range"
                }
            } else {
                printTable(value)
            }
            continueOption = askForContinue()
        } while (continueOption)
        displayThanks()
        scanner.close()
    }

    static void main(String[] args) {
        runApplication()
    }
}
