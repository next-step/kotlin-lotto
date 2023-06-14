package domain

class Separator {
    fun extractIntegers(text: String): List<Int> {
        return text.split(",").map { it.toInt() }
    }
}
