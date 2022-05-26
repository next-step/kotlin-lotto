package lotto

import lotto.domin.LottoMachine
import lotto.domin.LottoNumberSet
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
    val paymentRequestDto = InputPaymentRequestDto.convertPayment(payment)

    val lottoRecord = buyLotto(resultView, paymentRequestDto)
    lottoStatics(inputView, resultView, paymentRequestDto, lottoRecord)
}

fun buyLotto(resultView: ResultView, paymentRequestDto: InputPaymentRequestDto): List<LottoNumberSet> {
    val lottoNumberGenerator: LottoNumberGenerator = LottoNumberRandomGenerator()
    val lottoMachine = LottoMachine(paymentRequestDto, lottoNumberGenerator)

    lottoMachine.sellLotto()
    val issuanceLottoCount = lottoMachine.issuanceLottoCount
    val lottoRecord = lottoMachine.lottoRecord
    resultView.purchaseLotto(issuanceLottoCount, lottoRecord)
    return lottoRecord
}

fun lottoStatics(
    inputView: InputView,
    resultView: ResultView,
    paymentRequestDto: InputPaymentRequestDto,
    lottoRecord: List<LottoNumberSet>
) {
    val lastWeekWinningLotto: List<String> = inputView.winningNumber()
    val bonusBall: String = inputView.bonusBall()
    val winningStat = WinningStatics(
        paymentRequestDto,
        InputWinningLottoNumberDto.convertLottoNumber(lastWeekWinningLotto),
        lottoRecord
    ).result()

    resultView.printTitle()
    resultView.printResult(winningStat)
}
