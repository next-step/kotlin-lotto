package lotto.view.output.sixFortyFiveNumberLotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoWinningOutput
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoes
import lotto.sixFortyFiveNumberLotto.SixFortyFiveWinningEnum
import lotto.sixFortyFiveNumberLotto.SixFortyFiveWinningLotto

class SixFortyFiveResultOutputView(lottoList: SixFortyFiveLottoes, winningValue: SixFortyFiveWinningLotto) {

    init {
        val lottoWinningOutput = SixFortyFiveLottoWinningOutput(lottoList, winningValue)
        val lottoWinningMap = lottoWinningOutput.winningResultEnumMap
        val earningRate = lottoWinningOutput.earningRate
        println("당첨 통계\n--------")
        listOf(
            SixFortyFiveWinningEnum.FIFTH,
            SixFortyFiveWinningEnum.FOURTH,
            SixFortyFiveWinningEnum.THIRD,
            SixFortyFiveWinningEnum.FIRST,
        ).forEach { winningEnum ->
            val winningEnumCount = lottoWinningMap[winningEnum]
            println("${winningEnum.countOfMatch}개 일치 (${winningEnum.price}원) - ${winningEnumCount}개")
        }
        println("총 수익률은 $earningRate 입니다.")
    }
}
