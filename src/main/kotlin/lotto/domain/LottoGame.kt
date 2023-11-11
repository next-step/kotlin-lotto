package lotto.domain

import lotto.extension.getPrice

class LottoGame(val lottoList: List<Lotto>, val winningNumbers: LottoNumbers) {
    fun getResult(): LottoGameResult {
        val totalPrice = lottoList.getPrice()
        val rewards = lottoList
            .map { it.lottoNumbers.match(winningNumbers) }
            .mapNotNull { LottoReward.valueOf(it) }
            .sorted()

        return LottoGameResult(totalPrice, rewards)
    }
}
