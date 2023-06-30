package lotto.view.output.sixFortyFiveNumberLotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoWinningOutput
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoes
import lotto.sixFortyFiveNumberLotto.SixFortyFiveWinningEnum
import lotto.sixFortyFiveNumberLotto.SixFortyFiveWinningLotto

class SixFortyFiveBonusResultOutputView(
    lottoList: SixFortyFiveLottoes,
    winningValue: SixFortyFiveWinningLotto,
) {

    init {
        val lottoWinningOutput = SixFortyFiveLottoWinningOutput(lottoList, winningValue)
        val lottoWinningMap = lottoWinningOutput.winningResultEnumMap
        val earningRate = lottoWinningOutput.earningRate
        println("당첨 통계\n--------")
        listOf(
            SixFortyFiveWinningEnum.FIFTH,
            SixFortyFiveWinningEnum.FOURTH,
            SixFortyFiveWinningEnum.THIRD,
            SixFortyFiveWinningEnum.SECOND,
            SixFortyFiveWinningEnum.FIRST,
        ).forEach { winningEnum ->
            val winningEnumCount = lottoWinningMap[winningEnum]
            val additionalMessage = if (winningEnum == SixFortyFiveWinningEnum.SECOND) ", 보너스 볼 일치" else ""
            println("${winningEnum.countOfMatch}개 일치$additionalMessage (${winningEnum.price}원) - ${winningEnumCount}개")
        }
        println("총 수익률은 $earningRate 입니다.")
    }
}
