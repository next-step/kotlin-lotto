package lotto.view

import lotto.dto.UserMoneyInputDto
import lotto.dto.WinningNumbersInputDto
import lotto.util.InputModule
import lotto.util.OutPutModule

class BuyLottoInputView(private val inputModule: InputModule, private val outPutModule: OutPutModule) {

    fun readUserMoneyInput(): UserMoneyInputDto {
        showUserMoneyInputGuide()
        val userMoneyInputDto = UserMoneyInputDto(inputModule.read())
        showDivision()
        return userMoneyInputDto
    }

    fun readWinningLottoNumbers(): WinningNumbersInputDto {
        showWinningLottoNumbersInputGuide()
        val winningNumbersString = inputModule.read()
        showBonusBallInputGuide()
        val bonusBallString = inputModule.read()
        showDivision()
        return WinningNumbersInputDto(winningNumbersString, bonusBallString)
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
}
