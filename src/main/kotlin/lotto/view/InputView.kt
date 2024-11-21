package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNumber

object InputView {
    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getWinningNumbers(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(",")
            .map { it.toInt() }
            .map { LottoNumber.of(it) }
            .let { Lotto(it) }
    }
}
