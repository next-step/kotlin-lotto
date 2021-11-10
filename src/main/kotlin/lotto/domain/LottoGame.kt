package lotto.domain

import lotto.domain.ExceptionType.SIZE_OF_LOTTO_GAME_MUST_SIX

class LottoGame(val numbers: List<LottoNumber>) {
    init {
        require(numbers.toSet().size == 6) { SIZE_OF_LOTTO_GAME_MUST_SIX }
    }

    companion object {
        private val numberPool = List(45) { v -> v + 1 }

        fun createWithAutoSelect() = LottoGame(makeRandomNumbers())

        fun createWithNumberListString(stringList: List<String>) =
            LottoGame(stringList.map { LottoNumber(it) })

        private fun makeRandomNumbers() =
            numberPool
                .shuffled()
                .slice(0..5)
                .sorted()
                .map { LottoNumber(it) }
    }
}
