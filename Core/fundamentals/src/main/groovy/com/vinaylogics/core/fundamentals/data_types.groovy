package com.vinaylogics.core.fundamentals

import groovy.time.TimeCategory

import java.util.regex.Pattern

// Strings
//Define strings with quotes
def a = "First String"
def b = 'Second String'

def multi_line = """First
Second
Third
lines"""

def multiline = '''Multiple
lines
with
triple single quotes'''

def multiline2 = '''Line
with
"double quotes"
in triple single quotes'''

//String concatenation
"Groovy" + " in JMWE" == "Groovy in JMWE"
"Groovy in JMWE" - " in" == "Groovy JMWE"

// GStrings
def name = "Groovy"
def greeting = "Welcome to ${name} language"
greeting == "Welcome to Groovy language"


greeting.strings[0] == "Welcome to "
greeting.strings[1] == " language"
greeting.values[0] == "Groovy"

// Slashy String
def path = /C:\Windows\System32/
/C:\Windows\System32/ == path //returns true

def fooPattern = /.*foo.*/
fooPattern == ".*foo.*" //returns true

//Slashy strings are multiline
def multilineSlashy = /one
    two
    three/

multilineSlashy.contains('\n') //returns true

//Slashy strings can also be interpolated (ie. a GString)
def color = "blue"
def interpolatedSlashy = /a ${color} car/

interpolatedSlashy == "a blue car" //returns true

// Dollar Slashy
def name1 = "Groovy"
def name2 = "JMWE"

def dollarSlashy = $/
    Hello $name1,
    we're ${name2}. /$

// Numbers
def x = 1
def y = 2

x + y == 3
x.plus(y) == 3

// Regex
def regex = ~"Groovy"
def p = ~$/dollar/slashy $ string/$
def p2 = ~"${p}"

println regex
println p
println p2

// Find Operator
def regex2 = ~/:[0-9]+/
def httpUrl1 = 'http://www.example.com:8080/'

println httpUrl1 =~ regex2 //returns java.util.regex.Matcher[pattern=:[0-9]+ region=0,28 lastmatch=]

// Match Operator
def regex3 = ~/https?:\/\/.*/
def httpUrl = 'http://www.example.com/'

println httpUrl ==~ regex3 //returns true

// Pattern Operator
def p3 = ~"Groovy"
println p3 instanceof Pattern //returns true

// Boolean
boolean isActive = true
isActive = false
println isActive

// Arrays
String[] arrStr = ["Apple", "Banana", "Kiwi"]
arrStr[2] = "Mango" //Inserting element into an array
println arrStr

def matrix3 = new Integer[3][3]  //Array with bounds
def matrix = new String[5][]      //Array without bounds

// Collections

// List
def numbers = [1, 2, 3] //Elements of same data type
def hetero = [1, "a", true] //Elements of heterogenous data types

def multi = [[0, 1], [2, 3]]
multi[1][0] == 2
println multi
List newValues = [] //Empty list
println newValues

// Set
Set names = [] //Initialising a HashSet

names.add("Oliver")
names.add("Casper")
names.add("elvis")
names.add("Elvis")
names.add("John")
names.add("Carter")
names.add("Oliver")

println names
println names.size() == 6

Set numbers2 = [3,4,6,"Special","@",5,1.2,3,4]
println numbers2 as Set
println numbers2 //returns [3, 4, 6, Special, @, 5, 1.2, 3, 4]

Set newValues2 = [] //Empty set
println newValues2

// Map
def colors = [red: "#FF0000", green:"#00FF00", blue: "#0000FF"]
def doctor = [name: "Oliver","block-no":33,speciality:"Cardiology"] //Map where the key isn't a valid identifier
def place = [address:"Oliver"] //Variable "address" as the key
def emptyMap = [:] //An empty map

println colors
println doctor
println place
println emptyMap

// Ranges
def range = (0..10) //defining a range - Inclusive range
Range r = (0..<10)  //defining a range - Exclusive range
use (TimeCategory) {
def today = new Date()
def yesterday = today-1.days
def days = yesterday..today

}