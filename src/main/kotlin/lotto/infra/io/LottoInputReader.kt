package lotto.infra.io

import lotto.domain.lotto.LottoAnswer
import lotto.domain.lotto.price.LottoCost

class LottoInputReader {

    fun readLottoCost(): LottoCost {
        return LottoCost(readLine().toInt())
    }

    fun readLottoAnswer(): LottoAnswer {
        return LottoAnswer(readLine().split(",").map { it.trim().toInt() })
    }

    private fun readLine(): String = readln().trim()
}