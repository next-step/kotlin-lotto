package lotto.ui

import lotto.domain.LottoNumber

class InputView {

    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()!!.toInt()
    }

    fun inputPrizeNumber(): List<LottoNumber> {
        println("\n지난 주 당첨 번호를 입력해 주세요")
        return readLine()!!.split(", ")
            .map {
                LottoNumber(it.toInt())
            }
    }

    fun inputBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        return LottoNumber(readLine()!!.toInt())
    }
}
