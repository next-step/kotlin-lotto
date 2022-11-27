package lotto.view

import lotto.domain.Lotto

object OutputView {

    fun printLottoNumber(lottoNumber: Int) = println("$lottoNumber 개를 구매하였습니다")

    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach {
            print("[")
            printLotto(it)
            print("]\n")
        }
    }

    private fun printLotto(lotto: Lotto) {
        lotto.lotto.forEach {
            print(it.lottoBall)
        }
    }

    fun printRewards(){
        println("당첨 통계\n ---------")
    }
}
