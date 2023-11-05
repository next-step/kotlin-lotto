package lotto.ui

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
}
