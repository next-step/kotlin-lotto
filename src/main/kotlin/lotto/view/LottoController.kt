package lotto.view

import common.PositiveNumber
import lotto.domain.shop.LottoShop

class LottoController(
    private val lottoShop: LottoShop,
) {

    fun start() {
        println("구입금액을 입력해 주세요.")
        val lottoPurchaseAmount = PositiveNumber(readln().toInt())

        val lottoPurchaseResult = lottoShop.purchase(lottoPurchaseAmount)
        println("${lottoPurchaseResult.lottoGames.size}개를 구매했습니다.")
        lottoPurchaseResult.lottoGames
            .map { lottoGame -> lottoGame.numbers }
            .forEach { lottoNumbers -> println("[${lottoNumbers.joinToString(", ")}]") }
    }
}
