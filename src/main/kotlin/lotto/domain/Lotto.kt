package lotto.domain

import calculator.Tokenizer

class Lotto(val list: List<Int> = initList()) {

    var matchingCount: Int = 0
        private set

    var reward: Int = 0
        private set

    override fun toString(): String {
        return list.toString()
    }

    fun win(winningNumbers: String) {
        val numbers: List<Int> = Tokenizer.tokenize(winningNumbers).map {
            it.toInt()
        }

        matchingCount = LottoMatcher.countMatchNumber(numbers, list)
        reward = LottoReward.reward(matchingCount)
    }

    companion object {
        const val START_LOTTO_INDEX = 0
        const val LAST_LOTTO_INDEX = 6
        private val LOTTO_NUMBER_RANGE = (1..45)

        fun initList(): List<Int> {
            return LOTTO_NUMBER_RANGE.shuffled().subList(START_LOTTO_INDEX, LAST_LOTTO_INDEX).sorted()
        }
    }
}
