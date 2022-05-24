package lotto.domain

class LottoResult(val prize: LottoPrizeInfo) {
    var count = 0
        private set

    fun increaseMatchCount() {
        count++
    }

    fun getPrizeMoney() = prize.money
}
