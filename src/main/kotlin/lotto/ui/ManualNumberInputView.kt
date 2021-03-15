package lotto.ui

import lotto.data.LottoNumbers

object ManualNumberInputView {

    fun askManualInput(): List<LottoNumbers> {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val manualTicketCount = askManualTicketCount()

        println("수동으로 구매할 번호를 입력해 주세요.")
        val manualNumbersList = mutableListOf<LottoNumbers>()
        repeat(manualTicketCount) {
            val lottoNumbers = readSingleLottoNumbers()
            manualNumbersList.add(lottoNumbers)
        }
        return manualNumbersList
    }

    private fun askManualTicketCount(): Int {
        val manualTicketNumInput = readLine()
        return manualTicketNumInput?.toIntOrNull() ?: throw IllegalArgumentException("잘못된 입력값이 들어왔습니다.($manualTicketNumInput)")
    }

    private fun readSingleLottoNumbers(): LottoNumbers {
        val manualTicketNumInput = readLine() ?: throw IllegalArgumentException("입력 값이 존재하지 않습니다.")
        return LottoNumbers(InputUtils.splitWinningNumbers(manualTicketNumInput))
    }
}
