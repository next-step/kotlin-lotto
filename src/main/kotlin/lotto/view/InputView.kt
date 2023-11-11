package lotto.view

import lotto.Lotto
import lotto.LottoMachine


object InputView {

    fun inputPurchaseAmount(): LottoMachine {
        println("구입 금액을 입력해 주세요.")
        val price = readln().toIntOrNull() ?: throw IllegalArgumentException("가격 입력이 올바르지 않습니다.")
        return LottoMachine(price).also { lotto ->
            println("로또 ${lotto.count}개를 구매했습니다.")
            lotto.lottos.forEach { lotto ->
                println(lotto.numbers)
            }
        }

    }

    fun inputWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumber = readln()
        val checkNumber = Lotto().validateLottoNumber(winningNumber)
        if (checkNumber.isNotEmpty()) {
            return checkNumber
        } else {
            println("유효하지 않은 당첨 번호입니다. 다시 입력하세요.")
            return inputWinningNumbers()
        }

    }
}
