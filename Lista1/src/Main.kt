import kotlin.math.abs
import kotlin.math.pow

// Zad 1

fun Zad1(obj: Int) {
    for (nums in 1..obj)
    {
        var napis: String = ""

        if (nums % 3 == 0)
            napis = napis.plus("trzy")
        if (nums % 5 == 0)
            napis = napis.plus("piec")
        if (nums % 7 == 0)
            napis = napis.plus("siedem")
        if (nums % 11 == 0)
            napis = napis.plus("jedenascie")
        if (nums % 13 == 0)
            napis = napis.plus("trzynascie")
        if (napis == "")
            println(nums)
        else
            println(napis)
    }


}

//Zad 2

fun Zad2(obj: String): Boolean {
    var czy: Boolean = true

    var end: Int = obj.length - 1

    for (index in 0..obj.length - 1) {
        if(obj[index] != obj[end])
            czy = false
        end--
    }

    return czy
}

// Zad 3
fun silnia(obj: Int): Int {
    if(obj == 0 || obj == 1)
        return 1
    else return obj * silnia(obj - 1)
}

fun Newton(n: Int, k: Int): Int {
    if(k > n) return 0
    return silnia(n) / (silnia(k) * silnia(n - k))
}

fun Zad3(obj: Int) {
    for (wiersz in 0..obj - 1) {
        var linijka: String = ""

        for (spacja in 0..obj - wiersz - 2)
            linijka = linijka.plus(" ")

        for (kolumna in 0..wiersz)
            linijka = linijka.plus("${Newton(wiersz, kolumna)} ")

        println(linijka)
    }
}

// Zad 4

fun Doskonala(n: Int): String {
    var s: Int = 1

    for (i in 2..n - 1) {
        if (n % i == 0)
            s += i
    }

    return when {
        n == s -> "Doskonała"
        n < s -> "Obfita"
        n > s -> "Niedomiarowa"
        else -> "Błąd"
    }
}

// Zad 5

fun potega(a: Int, b: Int): Int {
    var s: Int = 1
    for(i in 1..b)
    {
        s *= a
    }

    return s
}

fun Armstrong(n: Int): Boolean {

    val napis: String = n.toString()
    var cyfry: Int = napis.length

    var liczba: Int = n

    var s: Int = 0

    for(i in 0..cyfry)
    {
        s += potega(liczba % 10, cyfry)
        liczba /= 10
    }

    return when {
        s == n -> true
        else -> false
    }

}


fun main() {

    // Zad 1
    val num: Int = 15
    Zad1(num)

    // Zad 2
    val word: String = "abba"
    println(Zad2(word))

    // Zad 3
    val height: Int = 7
    Zad3(height)

    // Zad 4
    val number: Int = 12
    println(Doskonala(number))

    // Zad 5
    val liczba: Int = 371
    println(Armstrong(liczba))
}