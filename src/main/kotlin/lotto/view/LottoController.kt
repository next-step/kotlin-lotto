package lotto.view

import lotto.domain.shop.LottoShop

class LottoController(
    private val lottoInputView: LottoInputView,
    private val lottoShop: LottoShop,
) {

    fun start() {
        val lottoPurchaseAmount = lottoInputView.readLottoPurchaseAmount()
        val lottoPurchaseResult = lottoShop.purchase(lottoPurchaseAmount)
        println("${lottoPurchaseResult.lottoGames.size}개를 구매했습니다.")
        lottoPurchaseResult.lottoGames
            .map { lottoGame -> lottoGame.numbers }
            .forEach { lottoNumbers -> println("[${lottoNumbers.joinToString(", ")}]") }
    }
}
