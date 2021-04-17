package view

import domain.lotto.LottoNumber
import domain.lotto.LottoNumbers

sealed class LottoNumberParsedResult

class ParsedLottoNumbers(any: List<Int>) : LottoNumberParsedResult() {
    val numbers: Set<Int> = any.toSet()

    init {
        require(any.size == 6) {
            "The number of elements must be 6. input='${any.size}'"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ParsedLottoNumbers

        if (numbers != other.numbers) return false

        return true
    }

    override fun hashCode(): Int {
        return numbers.hashCode()
    }

    fun toLottoNumbers(): LottoNumbers {
        val lottoNumberList = numbers.map { LottoNumber.parse(it) }
        return LottoNumbers.fromList(lottoNumberList)
    }

    fun contains(integer: Int): Boolean {
        return integer in numbers
    }
}

data class InvalidLottoNumbers(val message: String) : LottoNumberParsedResult()
