package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoPrizeStatics
import lotto.domain.ManualLotto

object ResultView {

    fun showLottoList(lottos: List<Lotto>) {
        val manualLottoCount = lottos.filterIsInstance<ManualLotto>().count()
        println("\n수동으로 ${manualLottoCount}장, 자동으로 ${lottos.size - manualLottoCount}을 구매했습니다.")
        lottos.forEach { println(it.toString()) }
    }

    fun showPrizeStatics(prizeStatics: LottoPrizeStatics) {
        val showPrizeStaticsSentence = StringBuilder("당첨 통계---------\n\n")
        prizeStatics.prizedLotto.forEach {
            val prize = it.key
            showPrizeStaticsSentence.append("${prize.countOfMatch}개 일치")
                .append(if (prize.withBonus) ", 보너스 볼 1개 일치" else "")
                .append("(${prize.prizeMoney}원) -${it.value} 개\n")
        }
        showPrizeStaticsSentence.append("\n총 수익률은 ${prizeStatics.profitRate} 입니다.")
        if (prizeStatics.profitRate < 1) showPrizeStaticsSentence.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        println(showPrizeStaticsSentence)
    }
}
