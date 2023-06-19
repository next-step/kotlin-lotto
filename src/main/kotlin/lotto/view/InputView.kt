package lotto.view

import lotto.domain.LottoNumber

object InputView {
    fun getPurchaseAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        val result = readln().toInt()
        require(result > 0) { "구입 금액은 0보다 커야합니다." }
        return result
    }

    fun getWinningNumbers(): List<LottoNumber> {
        println("지난주 당첨 번호를 입력해 주세요.")
        val result = readln()
        return result
            .split(",")
            .map { LottoNumber.of(it) }
    }
}
