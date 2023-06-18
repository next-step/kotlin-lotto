package lotto.view

import lotto.domain.shop.LottoPurchaseResult

class RealLottoResultView : LottoResultView {

    override fun display(lottoPurchaseResult: LottoPurchaseResult) {
        println("${lottoPurchaseResult.lottoGames.size}개를 구매했습니다.")
        lottoPurchaseResult.lottoGames
            .map { lottoGame -> lottoGame.numbers }
            .forEach { lottoNumbers -> println("[${lottoNumbers.joinToString(", ")}]") }
    }
}
