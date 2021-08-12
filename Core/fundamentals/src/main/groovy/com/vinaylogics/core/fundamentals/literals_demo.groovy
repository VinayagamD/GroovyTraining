package com.vinaylogics.core.fundamentals

// Simple Data type

// Object
def a = 10

// Number

// Real/Natural Number
byte d = 40
short c = 30
int b = 20
long e = 10L

// Floating Point Number
float f = 20.5F
double g = 30.3

// Character
char h = 'c'

// boolean
boolean  data = true

// String
String name = "venu"
def statements = "This is my student name ${name}"
String mulString = """
                    Mutliline string
                """
String singleQuote = 'venu'
String dollarString = $/
    Hi Hello 
    data
/$

// Arrays
String[] names = ["Usha" ,"Gheeta", "Rani", "Teju"]
int[][] dataInt = [
                        [1,10,20],
                        [1,10,20]
                    ]
def anotherArray = new String[10][]


// Complex Data type

// List
List dataList = [1,2,3,4,5, true, "Hello"]

//Set
Set dataSet = [1,2,3,4,5, true]

// Map
def map = [red: "#FF0000", green: "#00FF00", blur: "#0000FF"]
def emptyMap = [:]

// Range
def range = (0..10)
Range r = (0..<10)
range.forEach{println(it)}
r.forEach{println(it)}