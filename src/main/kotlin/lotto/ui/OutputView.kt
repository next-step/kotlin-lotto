package lotto.ui

import lotto.domain.LottoRank
import lotto.domain.LottoResult
import lotto.domain.Lottos

object OutputView {

    fun printLottos(lottos: Lottos) {
        println("${lottos.lottos.size}개를 구매했습니다.")
        lottos.lottos.forEach { lotto ->
            println(lotto.lottoNumbers.map { it.number })
        }
        println()
    }

    fun printLottoRank(lottoResult: LottoResult) {
        println("당첨 통계")
        println("---------")
        LottoRank.values().forEach {
            if (it != LottoRank.NONE) {
                println("${it.matchCount}개 일치 (${it.price}원)- ${lottoResult.getRankCount(it)}개")
            }
        }
    }
}
