package com.vinaylogics.core.fundamentals.closures

import java.util.stream.Collectors

/*
    Closures -> Anonymous block of code
    {}

    Closure
    Delegation
*/

def printHello = { println "Hello"}

printHello()
printHello.call()

def isOdd = {int i -> i%2 != 0}

assert  isOdd(3) == true
assert  isOdd(4) == false

// Parameters
def closureWithOneArg = { str -> str.toUpperCase() }
assert closureWithOneArg('groovy') == 'GROOVY'

def closureWithOneArgAndExplicitType = { String str -> str.toUpperCase() }
assert closureWithOneArgAndExplicitType('groovy') == 'GROOVY'

def closureWithTwoArgs = { a,b -> a+b }
assert closureWithTwoArgs(1,2) == 3

def closureWithTwoArgsAndExplicitTypes = { int a, int b -> a+b }
assert closureWithTwoArgsAndExplicitTypes(1,2) == 3

def closureWithTwoArgsAndOptionalTypes = { a, int b -> a+b }
assert closureWithTwoArgsAndOptionalTypes(1,2) == 3

def closureWithTwoArgAndDefaultValue = { int a, int b=2 -> a+b }
assert closureWithTwoArgAndDefaultValue(1) == 3

def greeting = { "Hello, $it!" }
assert greeting('Venu') == 'Hello, Venu!'
println greeting('Groovy')

def greeting2 = { it -> "Hello, $it!" }
assert greeting2('Patrick') == 'Hello, Patrick!'

def magicNumber = { -> 42 }

// this call will fail because the closure doesn't accept any argument
//magicNumber(11)
magicNumber()

def concat1 = { String... args -> args.join('') }
assert concat1('abc','def') == 'abcdef'
def concat2 = { String[] args -> args.join('') }
assert concat2('abc', 'def') == 'abcdef'

def multiConcat = { int n, String... args ->
    args.join('')*n
}
assert multiConcat(2, 'abc','def') == 'abcdefabcdef'

// Delegation

class Enclosing {
    void run() {
        def whatIsThisObject = { getThisObject() }
        assert whatIsThisObject() == this
        def whatIsThis = { this }
        assert whatIsThis() == this
    }
}
class EnclosedInInnerClass {
    class Inner {
        Closure cl = { this }
    }
    void run() {
        def inner = new Inner()
        assert inner.cl() == inner
    }
}
class NestedClosures {
    void run() {
        def nestedClosures = {
            def cl = { this }
            cl()
        }
        assert nestedClosures() == this
    }
}

// GStrings
def x = 1
def gs = "x = ${x}"
assert gs == 'x = 1'

def x1 = 1
def gs1 = "x = ${-> x1}"
assert gs1 == 'x = 1'

x1 = 2
assert gs1 == 'x = 2'

// memorize
def fib
fib = { long n -> n<2?n:fib(n-1)+fib(n-2) }
assert fib(15) == 610 // slow!

fib = { long n -> n<2?n:fib(n-1)+fib(n-2) }.memoize()
assert fib(25) == 75025 // fast!

// Composition
def plus2  = { it + 2 }
def times3 = { it * 3 }

def times3plus2 = plus2 << times3
assert times3plus2(3) == 11
assert times3plus2(4) == plus2(times3(4))

def plus2times3 = times3 << plus2
assert plus2times3(3) == 15
assert plus2times3(5) == times3(plus2(5))

// reverse composition
assert times3plus2(3) == (times3 >> plus2)(3)

//  Trampoline
def factorial
factorial = { int n, def accu = 1G ->
    if (n < 2) return accu
    factorial.trampoline(n - 1, n * accu)
}
factorial = factorial.trampoline()

assert factorial(1)    == 1
assert factorial(3)    == 1 * 2 * 3
assert factorial(1000) // == 402387260.. plus another 2560 digits

def data (Closure test){
    test() println("Venu")
}

data(printHello)

data {
    println "New Variation"
}

def myData = [1,2,3,4,5,6,7,8,9,10]
println myData
myData.forEach{println it}
println myData.stream().map{it*2}.collect(Collectors.toList())
println myData.stream().mapToInt(){it*2}.sum()
println myData.stream().mapToInt(){it*2}.max().orElse(0)
