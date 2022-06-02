package lotto

import lotto.domin.LottoMachine
import lotto.domin.LottoNumberSet
import lotto.domin.WinningStatics
import lotto.dto.InputLottoMachineRequestDto
import lotto.dto.InputLottoNumberDto
import lotto.util.LottoNumberGenerator
import lotto.util.LottoNumberRandomGenerator
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val payment: String = inputView.payment()
    val manualLottoCount: String = inputView.manualLottoCount()

    inputView.manualLottoNumberTitle()
    val manualLotto = List(InputLottoMachineRequestDto.convertToCount(manualLottoCount)) {
        LottoNumberSet(
            InputLottoNumberDto.convertToLottoNumber(inputView.manualLottoNumberNumber())
        )
    }

    val lottoMachineRequestDto = InputLottoMachineRequestDto.of(payment, manualLottoCount, manualLotto)

    val lottoRecord = buyLotto(resultView, lottoMachineRequestDto)
    lottoStatics(inputView, resultView, lottoMachineRequestDto, lottoRecord)
}

fun buyLotto(resultView: ResultView, lottoMachineRequestDto: InputLottoMachineRequestDto): List<LottoNumberSet> {
    val lottoNumberGenerator: LottoNumberGenerator = LottoNumberRandomGenerator()
    val lottoMachine = LottoMachine(lottoMachineRequestDto, lottoNumberGenerator)

    val lottoRecord = lottoMachine.lottoRecord
    resultView.purchaseLotto(lottoMachine.issuanceLottoCount, lottoMachine.inputManualLottoCount, lottoRecord)
    return lottoRecord
}

fun lottoStatics(
    inputView: InputView,
    resultView: ResultView,
    paymentRequestDto: InputLottoMachineRequestDto,
    lottoRecord: List<LottoNumberSet>
) {
    val lastWeekWinningLotto: List<String> = inputView.winningNumber()
    val bonusBall: String = inputView.bonusBall()
    val winningStat = WinningStatics(
        paymentRequestDto,
        InputLottoNumberDto.of(lastWeekWinningLotto, bonusBall),
        lottoRecord
    ).result()

    resultView.printTitle()
    resultView.printResult(winningStat)
}
