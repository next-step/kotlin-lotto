package lotto.domain

class LottoMachine(private val lottoFactory: LottoFactory) {

    fun buy(lottoBuy: LottoBuy): LottoReceipt {

        val (cost, manualLottoNumbers) = lottoBuy
        val purchasableCount = cost / LOTTO_COST

        require(purchasableCount >= manualLottoNumbers.size) { "비용이 부족합니다." }

        val manual = manualLottoNumbers.map { Lotto.of(it) }
        val auto = List(purchasableCount - manual.size) { lottoFactory.create() }
        return LottoReceipt(manual = manual, auto = auto)
    }

    companion object {
        const val LOTTO_COST = 1000
    }
}
