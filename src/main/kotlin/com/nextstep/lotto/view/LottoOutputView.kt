package com.nextstep.lotto.view

import com.nextstep.lotto.domain.Lotto
import com.nextstep.lotto.domain.LottoResult

object LottoOutputView {
    fun showBuyResult(lottos: List<Lotto>) {
        println("${lottos.size}개 구매했습니다.")
        for (lotto in lottos) {
            println("[${lotto.lottoNumbers.map { it.number }.joinToString(", ")}]")
        }
    }

    fun showLottoResult(lottoResult: LottoResult) {
        println("당첨 통계")
        println("------------")
        println("3개 일치 (${lottoResult.findPrizeByMatchCount(3)}원) - ${lottoResult.findNumberOfLottoByMatchCount(3)}개 ")
        println("4개 일치 (${lottoResult.findPrizeByMatchCount(4)}원) - ${lottoResult.findNumberOfLottoByMatchCount(4)}개 ")
        println("5개 일치 (${lottoResult.findPrizeByMatchCount(5)}원) - ${lottoResult.findNumberOfLottoByMatchCount(5)}개 ")
        println("6개 일치 (${lottoResult.findPrizeByMatchCount(6)}원) - ${lottoResult.findNumberOfLottoByMatchCount(6)}개 ")
        println("총 수익률은 ${lottoResult.getIncomingRate()}입니다.")
    }
}
