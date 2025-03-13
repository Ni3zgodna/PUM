

// Zad 1

fun r(s: String,i: Int) {
    var napis: String = ""

    for(n in 1..i){
        napis += s

    }

    println(napis)
}

// Zad 2

val <T> List<T>.head: T
    get() = first()

val <T> List<T>.tail: List<T>
    get() = drop(1)


// Zad 3

fun <T> isSorted(Lista: List<T>, action: (T, T) -> Boolean){
    val dlugosc: Int = Lista.size
    var czy: Boolean = true

    for(i in 0..< dlugosc - 1){
        if(!action(Lista[i], Lista[i + 1])){
            czy = false
        }

    }
    println(czy)
}

// Zad 4
fun <A> tailToHead(Lista: List<A>): List<A> {
    var Nowa_Lista = Lista.toMutableList()
    
    val dlugosc: Int = Lista.size
    var end: Int = dlugosc - 1

    if(!Lista.isEmpty()) {
        for(i in 0..dlugosc / 2 - 1) {
            val pomocnicza = Nowa_Lista[i]
            Nowa_Lista[i] = Nowa_Lista[end]
            Nowa_Lista[end] = pomocnicza
            end--
        }
        return Nowa_Lista
    } else {
        throw IllegalStateException("Empty list")
    }
}

// Zad 5

fun <A> setHead(Lista: List<A>, item: A): List<A> {
    var Nowa_Lista = Lista.toMutableList()
    Nowa_Lista[0] = item

    return Nowa_Lista
}

// Zad 6

fun suma(preambula: List<Int>, target: Int): Boolean {
    for (i in 0 until preambula.size) {
        for (j in i + 1 until preambula.size) {
            if (preambula[i] + preambula[j] == target) {
                return true
            }
        }
    }
    return false
}

fun check(N: Int, list: List<Int>): Int {

    for (i in N..list.size) {

        val preambula = list.subList(i - N, i)
        val target = list[i]

        if (!suma(preambula, target)) {
            return target
        }
    }
    return -1
}

fun main() {
    // Zad 1
    r("a",3)

    // Zad 2
    val list = listOf(1, 2, 3, 4, 5)

    println(list.head)
    println(list.tail)

    // Zad 3
    isSorted(listOf(1, 2, 3, 4), {i: Int, j: Int -> i < j})

    isSorted(listOf(1, 3, 2, 4), {i: Int, j: Int -> i < j})
    isSorted(listOf(4, 3, 2, 1), {i: Int, j: Int -> i > j})

    // Zad 4
    println(tailToHead(listOf(1, 2, 3)))
    // println(tailToHead(listOf<Int>()))

    // Zad 5
    println(setHead(listOf(1, 2, 3), 5))

    // Zad 6

    println(check(3, listOf(1, 2, 3, 5, 7, 12, 30)))
    println(check(5, listOf(35, 25, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)))
}