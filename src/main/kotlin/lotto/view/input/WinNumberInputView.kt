package lotto.view.input

import lotto.domain.Lotto
import lotto.domain.Number

object WinNumberInputView {
    fun print(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return Lotto(readln().split(",").map { it.trim().toInt() }.map { Number(it) })
    }
}
