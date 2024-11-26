package stringadd

fun main() {
    val stringAddCalculator = StringAddCalculator()
    val line = readlnOrNull()
    if (line != null) {
        val result = stringAddCalculator.add(line)
        println(result)
    }
}
