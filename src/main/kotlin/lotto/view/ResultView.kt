package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoPrizeStatics
import lotto.domain.MIN_NUMBER
import lotto.domain.MAX_NUMBER
import lotto.domain.COUNT_OF_NUMBERS
import lotto.domain.ManualLotto
import lotto.domain.LottoGameResult

object ResultView {

    fun showLottoList(lottos: List<Lotto>) {
        val manualLottoCount = lottos.filterIsInstance<ManualLotto>().count()
        println("\n수동으로 ${manualLottoCount}장, 자동으로 ${lottos.size - manualLottoCount}장을 구매했습니다.")
        lottos.forEach { println(it.toString()) }
    }

    fun showPrizeStatics(prizeStatics: LottoPrizeStatics) {
        val showPrizeStaticsSentence = StringBuilder("당첨 통계---------\n\n")
        prizeStatics.prizedLottoList.forEach {
            val prize = it.key
            showPrizeStaticsSentence.append("${prize.countOfMatch}개 일치")
                .append(if (prize.withBonus) ", 보너스 볼 1개 일치" else "")
                .append("(${prize.prizeMoney}원) -${it.value} 개\n")
        }
        showPrizeStaticsSentence.append("\n총 수익률은 ${prizeStatics.profitRate} 입니다.")
        if (prizeStatics.profitRate < 1) showPrizeStaticsSentence.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        println(showPrizeStaticsSentence)
    }

    fun showErrorMessage(message: Any?) {
        if (message == null) println("입력값을 확인해주세요.")
        if (message is String) println(message)
        when (message) {
            is LottoGameResult.InvalidBonusNumber -> println("$MIN_NUMBER~$MAX_NUMBER 사이의 숫자를 입력해 주세요.")
            is LottoGameResult.InvalidPrizeLotto -> println("$MIN_NUMBER~$MAX_NUMBER 사이의 숫자 ${COUNT_OF_NUMBERS}개 를 ',' 와 함께 입력해주세요.")
            is LottoGameResult.IsContainBonusNumber -> println("당첨번호에 포함되지 않는 보너스 볼을 입력해주세요.")
        }
    }
}
