package lotto.domain

class Delimiter(private val delimiterString: String) {

    @Throws(IllegalArgumentException::class)
    fun parseNumbers(findString: String): List<Int> {
        return findString.split(delimiterString)
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닌 문자($it)가 포함되어 있습니다") }
    }
}
