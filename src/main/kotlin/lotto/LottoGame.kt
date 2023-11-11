package lotto

import lotto.LottoNumber.MAX_NUMBER
import lotto.LottoNumber.MIN_NUMBER

class LottoGame {
    fun buyLotto(cash: Int): List<Lotto> {
        val lottoList = mutableListOf<Lotto>()
        val times = cash / 1000

        repeat(times) {
            lottoList.add(Lotto(createRandomNumber()))
        }

        return lottoList
    }

    private fun createRandomNumber(): List<Int> {
        return (MIN_NUMBER..MAX_NUMBER).shuffled()
            .subList(SUB_LIST_START_POSITION, SUB_LIST_START_POSITION + SUB_LIST_LENGTH).sorted()
    }

    companion object {
        private const val SUB_LIST_START_POSITION = 0
        private const val SUB_LIST_LENGTH = 6
    }
}
