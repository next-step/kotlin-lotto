package lotto.view

import lotto.domain.LottoNumbers
import lotto.domain.LottoReturn
import lotto.domain.Rank

object ResultView {
    fun printLotto(lottoList: List<LottoNumbers>) {
        println("${lottoList.size}개를 구매했습니다.")
        lottoList.forEach {
            println(
                it.numbers
                    .sorted()
            )
        }
        println()
    }

    fun printReturn(lottoReturn: LottoReturn) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (${Rank.FIFTH.winningMoney}원)- ${lottoReturn.fifthCount}개")
        println("4개 일치 (${Rank.FOURTH.winningMoney}원)- ${lottoReturn.fourthCount}개")
        println("5개 일치 (${Rank.THIRD.winningMoney}원)- ${lottoReturn.thirdCount}개")
        println("5개 일치, 보너스 볼 일치 (${Rank.SECOND.winningMoney}원)- ${lottoReturn.secondCount}개")
        println("6개 일치 (${Rank.FIRST.winningMoney}원)- ${lottoReturn.firstCount}개")
        println("총 수익률은 ${lottoReturn.returnRatio}입니다.")
    }
}
