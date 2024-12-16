package lotto.view

import lotto.domain.LottoTickets

object PurchaseLottoView {
    fun inputPurchaseCost(): Int {
        println("구입금액을 입력해 주세요.")
        val inputCost: String? = readlnOrNull()
        requireNotNull(inputCost) { "구입금액이 입력되지 않았습니다" }
        requireNotNull(inputCost.toIntOrNull()) { "구입금액이 올바르게 입력되지 않았습니다" }

        return inputCost.toInt()
    }

    fun displayPurchasedLottosView(
        manualLottoTickets: LottoTickets,
        autoLottoTickets: LottoTickets,
    ) {
        val manualLottoCount = manualLottoTickets.lottoTickets.size
        val autoLottoCount = autoLottoTickets.lottoTickets.size
        println("\n수동으로 ${manualLottoCount}장, 자동으로 ${autoLottoCount}개를 구매했습니다.")

        manualLottoTickets.lottoTickets.forEach { println(it.lottoNumbers.getNumbers()) }
        autoLottoTickets.lottoTickets.forEach { println(it.lottoNumbers.getNumbers()) }
    }
}
