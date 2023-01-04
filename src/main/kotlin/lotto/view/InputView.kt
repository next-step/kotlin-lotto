package lotto.view

import lotto.controller.dto.CashDto
import lotto.controller.dto.ManualLottoDto
import lotto.controller.dto.WinTicketDto

object InputView {

    fun readCash(): CashDto {
        println("구입금액을 입력해 주세요.")
        val input = try {
            readln().toInt()
        } catch (e: NumberFormatException) {
            error("현금은 숫자여야합니다.")
        }
        return CashDto(input)
    }

    fun ticketCountForManual(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun ticketToManual(ticketCount: Int): ManualLottoDto {
        val manualNumbers = (0 until ticketCount).map {
            println("수동으로 구매할 번호를 입력해 주세요.")
            readln()
        }
        return ManualLottoDto(manualNumbers)
    }

    fun readWinNumber(): WinTicketDto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winNumberString = readln()
        println("보너스 볼을 입력해 주세요.")
        val bonusNumberString = readln()
        return WinTicketDto(winNumberString, bonusNumberString)
    }
}
