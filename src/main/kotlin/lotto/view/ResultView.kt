package lotto.view

import lotto.domain.Amount
import lotto.domain.Lotto
import lotto.domain.PrizeMoney
import lotto.domain.Rank

object ResultView {

    fun resultLotto(lottoList: List<Lotto>, amount: Amount) {
        println("수동으로 ${amount.manual}장, 자동으로 ${amount.auto}개를 구매하셨습니다.")
        lottoList.forEach { lotto -> println(lotto.numbers.map { it.number }.sortedBy { it }) }
    }

    fun resultRank(rateOfReturn: Double , rank: Rank) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (${PrizeMoney.FIFTH.money}원)- ${rank.ranks[PrizeMoney.FIFTH]}개")
        println("4개 일치 (${PrizeMoney.FOURTH.money}원)- ${rank.ranks[PrizeMoney.FOURTH]}개")
        println("5개 일치 (${PrizeMoney.THIRD.money}원)- ${rank.ranks[PrizeMoney.THIRD]}개")
        println("5개 일치, 보너스 볼 일치 (${PrizeMoney.SECOND.money}원)- ${rank.ranks[PrizeMoney.SECOND]}개")
        println("6개 일치 (${PrizeMoney.FIRST.money}원)- ${rank.ranks[PrizeMoney.FIRST]}개")
        println("총 수익률은 ${rateOfReturn}입니다.")
    }
}
