package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoStatics

class ConsoleResultView : ResultView {
    override fun printLottosPickedNumbers(lottos: List<Lotto>) {
        lottos.forEach { lotto -> println(lotto.numbers) }
    }

    override fun printCountOfPurchasedLotto(countOfLotto: Int) {
        println("${countOfLotto}개를 구매했습니다")
    }
    override fun printLottoStatics(lottoStatics: LottoStatics) {
        println("")
        println("당첨 통계")
        println("------------------------------------------------------------------------------------------")
        for ((rank, rankCount) in lottoStatics.ranks) {
            println("[${rank.displayName}]: ${rank.countOfMatch}개 일치, ${rank.winningMoney}원 - ${rankCount}개")
        }
        println("------------------------------------------------------------------------------------------")
        println("총 수익률은 ${"%.2f".format(lottoStatics.rateOfReturn)}입니다")
    }
}
