package lotto.view

import lotto.domain.Number

object InputView {
    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요 (한장에 1000원입니다.)")
        return readLine()!!.toInt()
    }

    fun inputCorrectNumbers(): List<Number> {
        println("지난 주 당첨 번호를 입력해주세요")
        return readLine()!!.split(",").map { Number(it.trim()) }
    }
}
