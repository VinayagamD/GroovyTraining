package com.vinaylogics.core.fundamentals_assigment

/*
 * Addition
 * Subtraction
 * Multiplication
 * Division
 *
 * 2 Inputs
 *
 * Welcome
 * Provide Option
 * thank message
 * reuse for other operation
 */
class CalculatorDemo {
    static final def scanner = new Scanner(System.in)
    static final def MENU_OPTION = [1: "Addition", 2: "Subtraction", 3: "Multiplication", 4: "Division", 5: "Modulus"]

    static def welcomeMessage() {
        println "**********************************************************"
        println "********* Welcome to my calculator application ***********"
    }

    static def displayOption() {
        println "Enter the following option for to perform"
        MENU_OPTION.each {
            println "${it.getKey()} : ${it.value}"
        }
    }

    static int getOption() {
        println "Enter Any one of the option"
        scanner.nextInt()
    }

    static boolean validMenu(int menu) {
        MENU_OPTION.keySet().contains(menu)
    }

    static def displayThanks() {
        println "*********** Thank You For Using Our Application **********"
        println "********************* Visit Us Back **********************"
        println "**********************************************************"
    }

    static boolean askForContinue() {
        println "Enter YES or Y to perform another operation"
        def enterOption = scanner.next()
        return enterOption.equalsIgnoreCase("yes") || enterOption.equalsIgnoreCase("y")
    }

    static int askForInput(String operation, String input) {
        println "Enter value for ${input} for ${operation}"
        return scanner.nextInt()
    }

    static int performOperation(int operation,int input1, int input2) {
        switch (operation) {
            case 1:
                return performAddition(input1,input2)
            case 2:
                return performSubtraction(input1,input2)
            case 3:
                return performMultiplication(input1,input2)
            case 4:
                return performDivision(input1,input2)
            case 5:
                return performModulus(input1,input2)
        }
        return -1
    }

    static boolean validInput(int operation, int input2){
        if (operation == 4 || operation == 5){
            return input2 != 0
        }

        return true
    }


    static def performAddition(int input1, int input2) {
        return input1 + input2
    }

    static def performSubtraction(int input1, int input2) {
        return input1 - input2
    }

    static def performMultiplication(int input1, int input2) {
        return input1 * input2
    }

    static def performDivision(int input1, int input2) {
        return input1 / input2
    }

    static def performModulus(int input1, int input2) {
        return input1 % input2
    }

    static def displayResult(int operation, int input1, int input2, int result) {
        println()
        println "--------------------------------"
        println "For the operation ${MENU_OPTION.get(operation)}"
        println "--------------------------------"
        println "For the Provided input1: '${input1}' and input2: '${input2}'"
        println "--------------------------------"
        println "And result: '${result}'"
        println "--------------------------------"
        println()
    }

    static def runApplication() {
        welcomeMessage()
        boolean continueOption
        do {
            displayOption()
            def selectedOption = getOption()
            if (validMenu(selectedOption)) {
                def input1 = askForInput(MENU_OPTION.get(selectedOption), "input1")
                def input2 = askForInput(MENU_OPTION.get(selectedOption), "input2")
                if (validInput(selectedOption, input2)) {
                    def result = performOperation(selectedOption, input1, input2)
                    displayResult(selectedOption, input1, input2, result)
                } else {
                    println "Enter valid input 0 is not allowed for entered option"
                }
            } else {
                println "You have entered invalid option"
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
