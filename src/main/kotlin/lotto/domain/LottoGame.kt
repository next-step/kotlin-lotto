package lotto.domain

class LottoGame(val lottoList: List<LottoNumbers>, val winningNumbers: LottoNumbers, val bonusNumber: BonusNumber) {
    fun getResult(): LottoGameResult {
        val totalPrice = getTotalPrice()
        val rewards = getRewards(winningNumbers)
        return LottoGameResult(totalPrice, rewards)
    }

    private fun getTotalPrice(): Int =
        lottoList.size * LottoNumbers.LOTTO_PRICE

    private fun getRewards(winningNumbers: LottoNumbers): List<LottoReward> =
        lottoList.map { it.match(winningNumbers) }
            .mapNotNull { LottoReward.valueOf(it) }
            .sorted()
}
