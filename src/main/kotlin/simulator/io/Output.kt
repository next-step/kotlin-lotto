package simulator.io

import simulator.lotto.Lotto
import simulator.lotto.LottoResult

class Output {
    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach {
            println("[${toString(it)}]")
        }
    }

    fun printTimes(times: Int) {
        println("${times}개를 구매했습니다.")
    }

    fun printLottoResult(lottoResult: LottoResult) {
        println("당첨 통계")
        println("----------")
        println("3개 일치 (${LottoResult.FOURTH_PRIZE}원)- ${lottoResult.fourth}개")
        println("4개 일치 (${LottoResult.THIRD_PRIZE}원)- ${lottoResult.third}개")
        println("5개 일치 (${LottoResult.SECOND_PRIZE}원)- ${lottoResult.second}개")
        println("6개 일치 (${LottoResult.FIRST_PRIZE}원)- ${lottoResult.first}개")
    }

    fun printYield(money: Int, prize: Int) {
        val yield = if (prize == 0) 0 else money / prize
        println("총 수익률은 ${`yield`}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    private fun toString(lotto: Lotto): String {
        return lotto.numbers.joinToString(",")
    }
}