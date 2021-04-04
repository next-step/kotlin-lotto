package view

sealed class LottoNumberParsedResult

class ParsedManualNumbers(any: List<Int>) : LottoNumberParsedResult() {
    val numbers: Set<Int> = any.toSet()

    init {
        require(any.size == 6) {
            "The number of elements must be 6. input='${any.size}'"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ParsedManualNumbers

        if (numbers != other.numbers) return false

        return true
    }

    override fun hashCode(): Int {
        return numbers.hashCode()
    }
}

data class InvalidManualNumbers(val message: String) : LottoNumberParsedResult()
