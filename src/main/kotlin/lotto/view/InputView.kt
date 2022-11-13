package lotto.view

import java.lang.IllegalArgumentException

class InputView {
    companion object {
        fun askPurchaseAmount(): Int {
            println("구입금액을 입력해 주세요.")
            return readLine()?.toInt()
                ?: throw IllegalArgumentException("1000 이상의 숫자를 입력해주세요")
        }

        fun askWinnerNumber(): Set<Int> {
            println("지난 주 당첨 번호를 입력해 주세요.")
            return readLine()?.split(", ")
                ?.map { it.toInt() }
                ?.toSet() ?: throw IllegalArgumentException("당첨 번호는 , 를 기준으로 6자리 숫자를 입력해주세요.")
        }
    }
}