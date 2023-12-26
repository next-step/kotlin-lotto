package camp.nextstep.edu.step.step2.view

import camp.nextstep.edu.step.step2.domain.amount.BuyAmount
import camp.nextstep.edu.step.step2.domain.amount.ManualTicketAmount
import camp.nextstep.edu.step.step2.domain.lotto.Lotto
import camp.nextstep.edu.step.step2.domain.lotto.Lottos
import camp.nextstep.edu.step.step2.domain.number.Number

object InputView {

    fun getInputValueAndReturnBuyAmount(): BuyAmount {
        println("구입금액을 입력해 주세요.")
        return BuyAmount(readLine()!!.toLong())
    }

    fun inputManualLottoCount(): ManualTicketAmount {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return ManualTicketAmount(amount = readLine()!!.toLong())
    }

    fun inputManalLottoNumbers(ticketAmount: Long): Lottos {
        println("수동으로 구매할 번호를 입력해 주세요.")
        val lottoList = (1..ticketAmount).map { Lotto.ofInputValues(numbers = readLine()!!) }
        return Lottos(lottos = lottoList)
    }

    fun inputLastWeekWinningNumbers(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return Lotto.ofInputValues(numbers = readLine()!!)
    }

    fun inputBonusNumber(): Number {
        println("보너스 볼을 입력해 주세요.")
        return Number(number = readLine()!!.toInt())
    }

}
