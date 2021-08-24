package com.vinaylogics.core.fundamentals.user_input

import java.nio.charset.StandardCharsets

def reader = System.in.newReader(StandardCharsets.UTF_8.displayName())

String read = ""

/*while ((read=reader.readLine()) !=null) {
    if(read == "exit" || read == ""){
        break
    }
    println read
}

reader.close()*/

Scanner scanner = new Scanner(System.in)

while (scanner.hasNextLine()) {
    println scanner.next()
}

scanner.close()