package lotto.domain

import lotto.extension.getPrice

class LottoGame(val lottoList: List<Lotto>, val winningNumbers: Set<Int>) {
    fun getResult(): LottoGameResult {
        val totalPrice = lottoList.getPrice()
        val rewards = lottoList
            .map { it.match(winningNumbers) }
            .mapNotNull { LottoReward.valueOf(it) }
            .sorted()

        return LottoGameResult(totalPrice, rewards)
    }
}
