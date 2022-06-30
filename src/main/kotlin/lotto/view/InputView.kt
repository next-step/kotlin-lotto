package lotto.view

import lotto.Const
import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.PositiveNumber
import lotto.domain.WinningLotto

object InputView {
    private const val GET_PRICE_MSG = "구입금액을 입력해 주세요."
    private const val GET_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val GET_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요."
    private const val LOTTO_NUM_MSG = "지난 주 당첨 번호를 입력해 주세요."
    private const val BONUS_NUM_MSG = "보너스 볼을 입력해 주세요."

    private const val MANUAL_LOTTO_COUNT_IS_OVER_PRICE = "구매할 수 있는 장수를 초과했습니다."

    fun getPrice(): PositiveNumber {
        val inputStr = printMsgAndReadValue(GET_PRICE_MSG)
        return PositiveNumber.of(inputStr)
    }

    fun getManualLottoTicketCount(lottoTicketCount: PositiveNumber): PositiveNumber {
        val inputStr = printMsgAndReadValue(GET_MANUAL_LOTTO_COUNT)
        val manualLottoCount = PositiveNumber.of(inputStr)
        require(manualLottoCount <= lottoTicketCount) { MANUAL_LOTTO_COUNT_IS_OVER_PRICE }
        return manualLottoCount
    }

    fun getManualLottoNumbers(lottoTicketCount: PositiveNumber): LottoTickets {
        println(GET_MANUAL_LOTTO_NUMBER)
        val lottoTickets = mutableListOf<LottoTicket>()
        repeat(lottoTicketCount.toInt()) {
            val inputStr = requireNotNull(readlnOrNull()) { Const.ErrorMsg.INPUT_VALUE_IS_NULL_ERROR_MSG }
            println()
            val lottoTicket = LottoTicket(
                inputStr.split(",")
                    .map {
                        requireNotNull(it.trim().toIntOrNull()) { Const.ErrorMsg.CANNOT_CONVERSE_LOTTO_NUMBER_ERROR_MSG }
                    }
            )
            lottoTickets.add(lottoTicket)
        }

        return LottoTickets(lottoTickets.toList())
    }

    fun getLstWinningLotto(): WinningLotto {
        val lottoTicket = LottoTicket(getLastWinningNumbers())
        val bonusNumber = LottoNumber(getBonusNumber())

        return WinningLotto(lottoTicket, bonusNumber)
    }

    private fun getLastWinningNumbers(): List<Int> {
        val inputStr = printMsgAndReadValue("\n$LOTTO_NUM_MSG")
        return inputStr.split(",")
            .map {
                requireNotNull(it.trim().toIntOrNull()) { Const.ErrorMsg.CANNOT_CONVERSE_LOTTO_NUMBER_ERROR_MSG }
            }
    }

    private fun getBonusNumber(): Int {
        val inputStr = printMsgAndReadValue("\n$BONUS_NUM_MSG")
        return requireNotNull(inputStr.toIntOrNull()) { Const.ErrorMsg.CANNOT_CONVERSE_LOTTO_NUMBER_ERROR_MSG }
    }

    private fun printMsgAndReadValue(message: String): String {
        println(message)
        return requireNotNull(readlnOrNull()) { Const.ErrorMsg.INPUT_VALUE_IS_NULL_ERROR_MSG }
    }
}
