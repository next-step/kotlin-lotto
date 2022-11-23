package lotto.domain

import calculator.Tokenizer

class Lotto {

    val list: List<Int> = initList()

    var matchingCount: Int = 0
        private set

    var reward: Int = 0
        private set

    private fun initList(): List<Int> = (1..45).shuffled().subList(0, 6).sorted()

    override fun toString(): String {
        return list.toString()
    }

    fun win(winningNumbers: String) {
        val numbers: List<Int> = Tokenizer.tokenize(winningNumbers).map {
            it.toInt()
        }

        matchingCount = LottoMatcher.match(numbers, list)
        reward = LottoReward.reward(matchingCount)
    }
}
