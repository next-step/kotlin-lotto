package lotto.domain

class WinningLotto(val winningNumbers: List<Int>) {

    fun match(): LotteryPrizeAmount{
        return LotteryPrizeAmount.FIRST
    }
}
