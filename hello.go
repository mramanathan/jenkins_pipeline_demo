package main

import (
    "fmt"
)

func main() {

  // regular println will automatically insert new line feed
  // while Printf() should be supplied, "\n"
  fmt.Println("Hello Gopher!!!")
  fmt.Println(strings.ToUpper("vanakkam tamilakam!!!"))

  // this is inferred type assignment... ?
  str1 := "The quick brown fox"
  str2 := "jumped over"
  str3 := "lazy brown dog"

}
