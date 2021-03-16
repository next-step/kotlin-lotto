package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoWonNumber

class InputView {
    fun input(): Input {
        println("구입금액을 입력해 주세요.")
        val amount = readLine()!!.toInt()
        val input: Input = Input(amount)

        println("${input.lottoCount}개를 구매했습니다.")

        return input
    }
    fun inputWonNumber(): LottoWonNumber {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val lottoNumbers = readLine()!!.split(",")
            .map { LottoNumber(it.trim().toInt()) }
            .toSet()

        return LottoWonNumber(lottoNumbers)
    }
}
