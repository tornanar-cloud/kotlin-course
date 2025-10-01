package headFirstKotlin.hfkntt

fun main() {
   /* var x = 3
    var y = 1
    println(if (x > y) "x is greater than y" else "x is not greater than y")
    println("This line runs no matter what")
*/

    var x: Int = 1
    while(x < 3){
        print(if(x==1) "Yab" else "Dab")
        print("ba")
        x +=1
    }
    if(x==3) println("Do")

}