package lotto.view

import lotto.domain.Lottos

class InputView {

    private fun read(description: String): String {
        println(description)
        return readLine()!!
    }

    private fun readInt(description: String) = read(description).toInt()

    fun price() = readInt("구입금액을 입력해 주세요.")

    fun printBoughtResult(lottos: Lottos) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it.numbers)
        }
    }
}
