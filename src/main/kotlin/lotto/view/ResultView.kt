package lotto.view

import lotto.LottoNumber
import lotto.LottoResult
import lotto.enums.LottoReturn

object ResultView {
    fun printLotto(lottoNumbers: List<LottoNumber>) {
        println("${lottoNumbers.size}개를 구매했습니다.")
        lottoNumbers.forEach {
            println(it.numbers)
        }
        println()
    }

    fun printReturn(lottoResult: LottoResult) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (${LottoReturn.FOURTH.returnPrice}원)- ${lottoResult.fourthCount}개")
        println("4개 일치 (${LottoReturn.THIRD.returnPrice}원)- ${lottoResult.thirdCount}개")
        println("5개 일치 (${LottoReturn.SECOND.returnPrice}원)- ${lottoResult.secondCount}개")
        println("6개 일치 (${LottoReturn.FIRST.returnPrice}원)- ${lottoResult.firstCount}개")
        println("총 수익률은 ${lottoResult.returnRatio}입니다.")
    }
}
