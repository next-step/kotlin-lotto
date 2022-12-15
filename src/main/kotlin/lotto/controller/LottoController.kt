package lotto.controller

import lotto.domain.lotto.Lotto
import lotto.domain.lotto.ticket.LottoAnswerTicket
import lotto.infra.io.LottoInputReader
import lotto.view.CustomLottoTicketInputView
import lotto.view.LottoAnswerInputView
import lotto.view.LottoBonusNumberInputView
import lotto.view.LottoCostInputView
import lotto.view.LottoResultView
import lotto.view.LottoView

class LottoController(
    private val lottoView: LottoView = LottoView(),
    private val lottoResultView: LottoResultView = LottoResultView(),
    private val lottoAnswerInputView: LottoAnswerInputView = LottoAnswerInputView(),
    private val lottoBonusNumberInputView: LottoBonusNumberInputView = LottoBonusNumberInputView(),
    private val lottoCostInputView: LottoCostInputView = LottoCostInputView(),
    private val customLottoTicketInputView: CustomLottoTicketInputView = CustomLottoTicketInputView(),
    private val lottoInputReader: LottoInputReader = LottoInputReader()
) {

    fun run() {
        lottoCostInputView.printLottoCostInputView()

        val lottoCost = lottoInputReader.readLottoCost()

        customLottoTicketInputView.printCustomLottoTicketCountInputView()
        val customLottoTicketCount = lottoInputReader.readCustomLottoTicketCount()

        if (customLottoTicketCount > 0) {
            customLottoTicketInputView.printCustomLottoTicketInputView()
        }

        val customLottoTicketList =
            lottoInputReader.readCustomLottoTicketList(customLottoTicketCount)

        val lotto = Lotto(
            cost = lottoCost.inputCost,
            customLottoTicketList = customLottoTicketList
        )

        lottoView.printLottoView(lotto)

        lottoAnswerInputView.printLottoAnswerInputView()
        val lottoAnswerTicket = lottoInputReader.readLottoTicket()

        lottoBonusNumberInputView.printLottoBonusNumberInputView()
        val lottoBonusNumber = lottoInputReader.readLottoBonusNumber()

        val lottoAnswer = LottoAnswerTicket(lottoAnswerTicket, lottoBonusNumber)

        val lottoResult = lotto.result(lottoAnswer)
        lottoResultView.printLottoResultView(lottoResult)
    }
}
