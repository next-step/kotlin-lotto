package simulator.io

import simulator.lotto.Lotto

class Output {
    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach {
            println("[$it]")
        }
    }

    fun printTimes(times: Int) {
        println("${times}개를 구매했습니다.")
    }

    fun printLottoResultHeader(){
        println("당첨 통계")
        println("----------")
    }

    fun printLottoResult(matchesNumber: Int, prize:Int, count:Int) {
        println("${matchesNumber}개 일치 (${prize}원)- ${count}개")
    }

    fun printYield(yield: Double) {
        println("총 수익률은 ${`yield`}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}