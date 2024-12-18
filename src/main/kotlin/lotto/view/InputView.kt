package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.WinningLotto
import lotto.dto.PurchaseDetail

object InputView {
    private const val DELIMITER = ","

    fun getPurchaseDetail(): PurchaseDetail {
        val purchaseAmount = getPurchaseAmount()
        val manualLottoQuantity = getManualLottoQuantity()
        val manualLottoTickets = getManualLottoTickets(manualLottoQuantity)
        return PurchaseDetail(purchaseAmount, manualLottoTickets)
    }

    private fun getManualLottoTickets(manualLottoQuantity: Int): LottoTickets {
        val manualLottoTickets = mutableListOf<LottoTicket>()
        println("수동으로 구매할 번호를 입력해 주세요.")
        repeat(manualLottoQuantity) {
            val line = readlnOrNull()?.takeIf { it.isNotBlank() } ?: throw IllegalArgumentException("로또 번호를 입력해주세요.")
            val numbers =
                line.split(DELIMITER)
                    .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("로또 번호는 숫자여야 합니다.") }
            manualLottoTickets.add(LottoTicket.from(numbers.toSet()))
        }
        return LottoTickets(manualLottoTickets)
    }

    private fun getManualLottoQuantity(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val quantity = readln()
        return quantity.toIntOrNull() ?: throw IllegalArgumentException("유효한 숫자를 입력해주세요")
    }

    private fun getPurchaseAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        val amount = readln()
        return amount.toIntOrNull() ?: throw IllegalArgumentException("구입 금액이 유효하지 않습니다. 숫자를 입력해주세요")
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
