package lotto.view

import lotto.domain.LottoNumbers
import lotto.domain.LottoReturn

object ResultView {
    fun printLotto(lottoList: List<LottoNumbers>) {
        println("${lottoList.size}개를 구매했습니다.")
        lottoList.forEach {
            println(it.numbers)
        }
        println()
    }

    fun printReturn(lottoReturn: LottoReturn) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (${LottoReturn.FOURTH_RETURN}원)- ${lottoReturn.fourthCount}개")
        println("4개 일치 (${LottoReturn.THIRD_RETURN}원)- ${lottoReturn.thirdCount}개")
        println("5개 일치 (${LottoReturn.SECOND_RETURN}원)- ${lottoReturn.secondCount}개")
        println("6개 일치 (${LottoReturn.FIRST_RETURN}원)- ${lottoReturn.firstCount}개")
        println("총 수익률은 ${lottoReturn.returnRatio}입니다.")
    }
}
