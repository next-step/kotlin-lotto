package lotto.domain

class Delimiter(private val delimiterString: String) {
    fun parseNumbers(findString: String): List<Int> {
        return findString.split(delimiterString).map { it.trim() }.map { it.toInt() }
    }
}
