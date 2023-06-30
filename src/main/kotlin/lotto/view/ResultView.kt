package lotto.view

import lotto.Lotto
import lotto.LottoResult
import lotto.enums.LottoReturn

object ResultView {
    fun printLotto(resultLottoNumbers: List<Lotto>) {
        println("${resultLottoNumbers.size}개를 구매했습니다.")
        resultLottoNumbers.forEach {
            println(it.numbers)
        }
        println()
    }

    fun printReturn(lottoResult: LottoResult) {
        println("당첨 통계")
        println("---------")
        println("${LottoReturn.FIFTH.matchCount}개 일치 (${LottoReturn.FIFTH.returnPrice}원)- ${lottoResult.count(LottoReturn.FIFTH)}개")
        println("${LottoReturn.FOURTH.matchCount}개 일치 (${LottoReturn.FOURTH.returnPrice}원)- ${lottoResult.count(LottoReturn.FOURTH)}개")
        println("${LottoReturn.THIRD.matchCount}개 일치 (${LottoReturn.THIRD.returnPrice}원)- ${lottoResult.count(LottoReturn.THIRD)}개")
        println("${LottoReturn.SECOND.matchCount}개 일치, 보너스 볼 일치 (${LottoReturn.SECOND.returnPrice}원)- ${lottoResult.count(LottoReturn.SECOND)}개")
        println("${LottoReturn.FIFTH.matchCount}개 일치 (${LottoReturn.FIRST.returnPrice}원)- ${lottoResult.count(LottoReturn.FIRST)}개")
        println("총 수익률은 ${lottoResult.returnRatio}입니다.")
    }
}
