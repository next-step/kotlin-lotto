package lotto.view

import lotto.domain.Delimiter
import lotto.domain.LottoTicket
import lotto.domain.Money
import lotto.domain.WinningLottoNumbers
import lotto.dto.TicketCountDto
import lotto.dto.UserMoneyInputDto
import lotto.dto.WinningNumbersInputDto
import lotto.util.InputModule
import lotto.util.OutPutModule

class BuyLottoInputView(private val inputModule: InputModule, private val outPutModule: OutPutModule) {

    fun readUserMoneyInput(): Money {
        showUserMoneyInputGuide()
        val userMoneyInputDto = UserMoneyInputDto(inputModule.read())
        showDivision()
        return userMoneyInputDto.userMoney
    }

    fun readPassiveTickets(): List<LottoTicket> {
        outPutModule.write("수동으로 구매할 로또 수를 입력해 주세요.")
        val ticketCountDto = TicketCountDto(inputModule.read())
        outPutModule.write("")

        if (ticketCountDto.tickCount == 0) {
            return emptyList()
        }

        outPutModule.write("수동으로 구매할 번호를 입력해 주세요.")
        val lottoTicketStrings = mutableListOf<String>()
        repeat(ticketCountDto.tickCount) { lottoTicketStrings.add(inputModule.read()) }
        outPutModule.write("")

        return lottoTicketStrings.map { lottoNumbersString -> LottoTicket.ofString(lottoNumbersString, PASSIVE_LOTTO_DELIMITER) }
    }

    fun readWinningLottoNumbers(): WinningLottoNumbers {
        showWinningLottoNumbersInputGuide()
        val winningNumbersString = inputModule.read()
        showBonusBallInputGuide()
        val bonusBallString = inputModule.read()
        showDivision()
        return WinningNumbersInputDto(winningNumbersString, bonusBallString).winningLottoTicketNumbers
    }

    private fun showUserMoneyInputGuide() {
        outPutModule.write("구입금액을 입력해 주세요.")
    }

    private fun showWinningLottoNumbersInputGuide() {
        outPutModule.write("지난 주 당첨 번호를 입력해 주세요.")
    }

    private fun showBonusBallInputGuide() {
        outPutModule.write("보너스 볼을 입력해 주세요.")
    }

    private fun showDivision() {
        outPutModule.write("")
    }

    companion object {
        private val PASSIVE_LOTTO_DELIMITER = Delimiter(",")
    }
}
