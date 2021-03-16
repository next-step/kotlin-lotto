package lotto.view

import lotto.domain.LottoNumber

class InputView {
    fun input(): Input {
        println("구입금액을 입력해 주세요.")
        val amount = readLine()!!.toInt()
        val input: Input = Input(amount)

        println("${input.lottoCount}개를 구매했습니다.")

        return input
    }
    fun inputWonNumber(): List<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        return readLine()!!.split(",")
            .map { LottoNumber(it.trim().toInt()) }
    }
}
