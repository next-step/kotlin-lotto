package lotto.ui

import lotto.controller.LottoController
import lotto.controller.LottoController.Companion.LOTTO_NUMBER_COUNT
import lotto.model.CorrectnessInfo
import lotto.model.LottoInfo

object ResultView {

    fun showGeneratedLottoInfos(lottoInfos: List<LottoInfo>) {
        println("${lottoInfos.size}개를 구매했습니다.")
        lottoInfos.forEach { lottoInfo ->
            print("[")
            lottoInfo.numbers.forEachIndexed { idx, number ->
                print(number)
                if (idx < lottoInfo.numbers.lastIndex) print(", ")
            }
            println("]")
        }
    }

    fun showCorrectnessStatistics(
        correctnessInfoList: List<CorrectnessInfo>,
        minCorrectnessCountForShow: Int,
    ) {
        println("당첨 통계")
        (minCorrectnessCountForShow..LOTTO_NUMBER_COUNT).forEach { correctnessNumberCount ->
            val count = correctnessInfoList
                .find { it.correctnessNumCount == correctnessNumberCount }
                ?.correctLottoInfoCount
                ?: 0
            println("${correctnessNumberCount}개 일치 (${LottoController.winPrizeMoney[correctnessNumberCount]}원) - ${count}개")
        }
    }
}
