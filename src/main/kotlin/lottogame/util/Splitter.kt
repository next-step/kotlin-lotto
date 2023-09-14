package lottogame.util

class Splitter(private val delimiter: String = ",") {
    fun toNumbers(input: String): List<Int> {
        return input.split(delimiter)
            .map { it.trim().toInt() }
    }
}
