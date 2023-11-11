package lotto.domain

class WinningLotto(val winningNumbers: List<Int>) {
    fun match(lotto: Lotto): LotteryPrizeAmount {
        val userNumbers = lotto.numbers
        val count = userNumbers.count { lottoNumber ->
            winningNumbers.contains(lottoNumber.value)
        }

        return LotteryPrizeAmount.getWinningPrize(count)
    }
}
