package lotto.ui

import lotto.Lotto

object InputView {
    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")

        return readln().toInt()
    }

    fun showBoughtLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it.numbers)
        }
    }

    fun inputWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        return readln()
            .split(",")
            .map { it.toInt() }
    }
}
