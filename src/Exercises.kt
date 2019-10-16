import kotlin.properties.Delegates
import kotlin.random.Random

fun main(args: Array<String>)
{
//    lateinitDemo()
//    lazyDemo()
//    setGetField()
//    enumDemo()
//    notNullDemo()
//    observableDemo()
    vetoableDemo()
}

// lateinitDemo
lateinit var demoValue: String
var demo2: String? = null

fun lateinitDemo() {
    demoValue = "Hello lateinit"
    println(demoValue)
}

// by lazy demo
var intRand: Int = 0
val lazyString by lazy {
    println("Initializing lazyString")
    var string: String = ""
    for (i in 1..intRand) {
        string += "lazy string"
    }
    string
}
fun lazyDemo() {
    intRand = Random.nextInt(4) + 1
    println("doing some work")
    println(lazyString)
    println(lazyString)
}

// set, get, field
private val values = IntArray(5) { it * 1 }
private val valuesSum: Int
    get() {
        println("Using valuesSum getter")
        return values.sum()
    }

fun setGetField() {
    println(valuesSum)
    println(valuesSum)
}

fun enumDemo() {
    /*val num: Numbers = Numbers.one
    when (num) {
        Numbers.one -> {}
        Numbers.two -> {}
        Numbers.three -> {}
    }*/

    println(Numbers.one.name)
    println(Numbers.one.ordinal)
}

enum class Numbers {
    one, two, three
}

enum class HttpMethods{
    GET, PUT, POST, DELETE
}

// not null
var max: Int by Delegates.notNull()

fun notNullDemo() {
//     println(max) // will fail
// with IllegalStateException
// if called here

    max = 10
    println(max) // 10

}

// observable
var observed = false
var max2: Int by Delegates.observable(0) { property, oldValue, newValue ->
    observed = true
}

fun observableDemo() {
    println(max2) // 0
    println("observed is ${observed}") // false

    max2 = 10
    println(max2) // 10
    println("observed is ${observed}") // true
}

var max3: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
    newValue > oldValue
}

fun vetoableDemo() {
    println(max3) // 0

    max3 = 10
    println(max3) // 10

    max3 = 5
    println(max3) // 10
}