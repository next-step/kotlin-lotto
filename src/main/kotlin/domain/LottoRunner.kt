package domain

import util.InputReader

class LottoRunner(private val inputReader: InputReader) {
    fun startLotto() {
        println("구입금액을 입력해 주세요.")
        val money = inputReader.raedLine()
        println(money)
    }
}
