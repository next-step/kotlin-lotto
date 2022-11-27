package lotto.view

import lotto.domain.Lotto

object OutputView {


    fun printLottos(lottos: List<Lotto>) {
        printLottoNumber(lottos.size)
        lottos.forEach {
            print("[")
            printLotto(it)
            print("]\n")
        }
    }
    private fun printLottoNumber(lottoNumber: Int) = println("$lottoNumber 개를 구매하였습니다")

    private fun printLotto(lotto: Lotto) {
        lotto.lotto.forEach {
            print(it.lottoBall)
        }
    }

    fun printRewards(){
        println("당첨 통계\n ---------")
    }
}
