package lotto.view

import lotto.model.Amount
import lotto.model.LottoNumber
import lotto.model.LottoNumbers

class InputView {

    fun getPurchaseAmount(): Amount {
        println("구입금액을 입력해 주세요.")
        return Amount(readLine()!!.toInt())
    }

    fun getWinnerLottoNumbers(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readLine()!!
            .split(",")
            .map { it.trim().toInt() }

        return LottoNumbers.manual(
            num1 = numbers[0],
            num2 = numbers[1],
            num3 = numbers[2],
            num4 = numbers[3],
            num5 = numbers[4],
            num6 = numbers[5],
        )
    }

    fun getBonusLottoNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        val number = readLine()!!.toInt()
        return LottoNumber(number)
    }
}
