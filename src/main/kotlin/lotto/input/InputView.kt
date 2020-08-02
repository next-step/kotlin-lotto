package lotto.input

import java.lang.IllegalArgumentException

object InputView {
    fun inputMoney(value: String): Int {
        println(value)
        return readLine()?.toInt() ?: throw IllegalArgumentException("숫자만 넣어 주세요")
    }

    fun inputWinningNumber(value: String): List<Int> {
        println(value)
        return readLine()?.split(",")?.map {
            it.toInt()
        } ?: throw IllegalArgumentException("콤마(,)로 연결된 6자리 숫자를 입력하세요.")
    }
}
