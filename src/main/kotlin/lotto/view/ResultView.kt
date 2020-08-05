package lotto.view

import lotto.domain.Lotto
import lotto.domain.PrizeMoney
import lotto.domain.Rank
import lotto.domain.Result

object ResultView {

    fun resultLotto(lottoList: List<Lotto>) {
        lottoList.forEach { lotto -> println(lotto.numbers.map { it.number }) }
    }

    fun resultRank(result: Result, rank: Rank) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (${PrizeMoney.FIFTH.money}원)- ${rank.ranks[PrizeMoney.FIFTH]}개")
        println("4개 일치 (${PrizeMoney.FOURTH.money}원)- ${rank.ranks[PrizeMoney.FOURTH]}개")
        println("5개 일치 (${PrizeMoney.THIRD.money}원)- ${rank.ranks[PrizeMoney.THIRD]}개")
        println("5개 일치, 보너스 볼 일치 (${PrizeMoney.SECOND.money}원)- ${rank.ranks[PrizeMoney.SECOND]}개")
        println("6개 일치 (${PrizeMoney.FIRST.money}원)- ${rank.ranks[PrizeMoney.FIRST]}개")
        println("총 수익률은 ${result.getRateOfReturn()}입니다.")
    }
}
