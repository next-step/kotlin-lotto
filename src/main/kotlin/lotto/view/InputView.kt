package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.Money
import lotto.domain.WinningLotto
import lotto.dto.PurchaseDetail

object InputView {
    private const val DELIMITER = ","

    fun getPurchaseDetail(): PurchaseDetail {
        val money = getPurchaseAmount()
        val manualLottoQuantity = getManualLottoQuantity()
        val manualLottoTickets = getManualLottoTickets(manualLottoQuantity)
        return PurchaseDetail.of(money, manualLottoTickets)
    }

    private fun getManualLottoTickets(manualLottoQuantity: Int): LottoTickets {
        println("수동으로 구매할 번호를 입력해 주세요.")
        val manualLottoTickets =
            List(manualLottoQuantity) {
                val readLine = readlnOrNull()?.takeIf { it.isNotBlank() } ?: throw IllegalArgumentException("로또 번호를 입력해주세요.")
                LottoTicket.makeLottoTicket(readLine)
            }
        return LottoTickets(manualLottoTickets)
    }

    private fun getManualLottoQuantity(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val quantity = readln()
        return quantity.toIntOrNull() ?: throw IllegalArgumentException("유효한 숫자를 입력해주세요")
    }

    private fun getPurchaseAmount(): Money {
        println("구입 금액을 입력해 주세요.")
        val amount = readln()
        return Money(amount)
    }

    fun getUserWinningLotto(): WinningLotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningLottoNumbers: String = readln()
        val numbers = winningLottoNumbers.split(DELIMITER).map { it.toInt() }.toSet()

        println("보너스 볼을 입력해 주세요.")
        val bonusNumber: String = readln()
        return WinningLotto(LottoTicket.from(numbers), LottoNumber.from(bonusNumber))
    }
}
