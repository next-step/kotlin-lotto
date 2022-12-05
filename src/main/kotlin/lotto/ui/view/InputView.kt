package lotto.ui.view

import lotto.domain.LottoNumber

object InputView {
    fun getPurchasePrice(): Int {
        println("구입금액을 입력해 주세요.")

        return readLine()?.toIntOrNull() ?: 0
    }

    fun getWinningLotto(): Set<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        return readLine()?.split(",")?.map { stringNumber ->
            LottoNumber(stringNumber.toInt())
        }?.toSet() ?: emptySet()
    }
}
