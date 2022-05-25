package lotto.domain

class LottoResult(val prize: LottoPrizeInfo) {
    var count = 0
        private set

    val isBonus = prize.isBonus()

    fun increaseMatchCount() {
        count++
    }

    fun getPrizeMoney() = prize.money
}
