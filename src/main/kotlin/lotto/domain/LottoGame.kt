package lotto.domain

class LottoGame(val lottoList: List<LottoNumbers>) {
    fun getResult(winningNumbers: WinningNumbers): LottoGameResult {
        val totalPrice = getTotalPrice()
        val rewards = getRewards(winningNumbers)
        return LottoGameResult(totalPrice, rewards)
    }

    private fun getTotalPrice(): Int =
        lottoList.size * LottoNumbers.LOTTO_PRICE

    private fun getRewards(winningNumbers: WinningNumbers): List<LottoReward> =
        lottoList.map { winningNumbers.match(it) }
            .mapNotNull { LottoReward.valueOf(it.matchCount, it.bonusMatch) }
            .sorted()
}
