package lotto

import lotto.domin.LottoMachine
import lotto.domin.WinningStatics
import lotto.dto.InputPaymentRequestDto
import lotto.dto.InputWinningLottoNumberDto
import lotto.util.LottoNumberGenerator
import lotto.util.LottoNumberRandomGenerator
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val payment: String = inputView.payment()

    val paymentRequestDto = InputPaymentRequestDto.convertInt(payment)
    val lottoNumberGenerator: LottoNumberGenerator = LottoNumberRandomGenerator()
    val lottoMachine = LottoMachine(paymentRequestDto, lottoNumberGenerator)

    lottoMachine.sellLotto()
    val issuanceLottoCount = lottoMachine.issuanceLottoCount
    val lottoRecord = lottoMachine.lottoRecord
    resultView.purchaseLotto(issuanceLottoCount, lottoRecord)

    val lastWeekWinningLotto: List<String> = inputView.winningNumber()
    val winningStat = WinningStatics(
        paymentRequestDto,
        InputWinningLottoNumberDto.convertInt(lastWeekWinningLotto),
        lottoRecord
    ).run()

    resultView.printTitle()
    resultView.printResult(winningStat)
}
