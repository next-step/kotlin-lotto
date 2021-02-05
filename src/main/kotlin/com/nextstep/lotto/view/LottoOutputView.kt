package com.nextstep.lotto.view

import com.nextstep.lotto.domain.LottoResult
import com.nextstep.lotto.domain.Lottos
import com.nextstep.lotto.domain.Prize

object LottoOutputView {
    fun showBuyResult(lottos: Lottos) {
        println("수동으로 ${lottos.numberOfManual}장, 자동으로 ${lottos.getNumberOfAuto()}개를 구매했습니다.")
        for (lotto in lottos.lottos) {
            println("[${lotto.lottoNumbers.map { it.number }.joinToString(", ")}]")
        }
    }

    fun showLottoResult(lottoResult: LottoResult) {
        println("당첨 통계")
        println("------------")
        println("3개 일치 (${Prize.FIFTH.prize}원) - ${lottoResult.findNumberOfLottoByMatchCount(Prize.FIFTH)}개 ")
        println("4개 일치 (${Prize.FOURTH.prize}원) - ${lottoResult.findNumberOfLottoByMatchCount(Prize.FOURTH)}개 ")
        println("5개 일치 (${Prize.THIRD.prize}원) - ${lottoResult.findNumberOfLottoByMatchCount(Prize.THIRD)}개 ")
        println("5개 일치, 보너스 볼 일치 (${Prize.SECOND.prize}원) - ${lottoResult.findNumberOfLottoByMatchCount(Prize.SECOND)}개 ")
        println("6개 일치 (${Prize.FIRST.prize}원) - ${lottoResult.findNumberOfLottoByMatchCount(Prize.FIRST)}개 ")
        println("총 수익률은 ${lottoResult.getIncomingRate()}입니다.")
    }
}
