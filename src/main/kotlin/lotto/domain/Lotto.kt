package lotto.domain

import calculator.Tokenizer

class Lotto {

    val list: List<Int> = initList()

    private fun initList(): List<Int> = (1..45).shuffled().subList(0, 6).sorted()

    override fun toString(): String {
        return list.toString()
    }

    fun win(input: String): Int {
        val numbers: List<Int> = Tokenizer.tokenize(input).map {
            it.toInt()
        }

        return LottoMatcher.matchingCount(numbers, list)
    }
}
