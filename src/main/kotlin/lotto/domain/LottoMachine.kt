package lotto.domain

class LottoMachine(private val lottoFactory: LottoFactory) {

    fun buy(lottoBuy: LottoBuy): LottoReceipt {

        val (cost, manual) = lottoBuy
        val totalCount = cost / LOTTO_COST

        require(totalCount >= manual.size) { "비용이 부족합니다." }

        val auto = List(totalCount - manual.size) { lottoFactory.create() }
        return LottoReceipt(manual = manual, auto = auto)
    }

    companion object {
        const val LOTTO_COST = 1000
    }
}
