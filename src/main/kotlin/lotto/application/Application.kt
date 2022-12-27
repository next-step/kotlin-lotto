package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoNumber
import lotto.domain.LottoResultService
import lotto.domain.LottoShop
import lotto.util.RandomNumberGenerator
import lotto.view.InputView
import lotto.view.ResultView

class Application {
    private val inputView = InputView()
    private val resultView = ResultView()
    private val lottoGenerator = LottoGenerator(RandomNumberGenerator())

    fun run() {
        val inputPayment = inputView.inputPayment()
        val manualLottoCount = inputView.inputManualLottoCount()
        val manualNumberList = inputView.inputManualLottoNumbers(manualLottoCount)

        val lottoShop = LottoShop(lottoGenerator, inputPayment)

        val manualLottoList = lottoShop.buyManualLotto(manualNumberList)
        val autoLottoList = lottoShop.buyAutoLotto()
        resultView.printLottoList(manualLottoList, autoLottoList)

        val lottoList = manualLottoList + autoLottoList
        val inputLuckyNumbers = inputView.inputLuckyNumbers()
        val inputBonusNumber = inputView.inputBonusNumber()

        val lottoResultService = LottoResultService(Lotto(inputLuckyNumbers.integerNumberList.map { LottoNumber(it) }), LottoNumber(inputBonusNumber))
        val statistics = lottoResultService.inquireStatistics(inputPayment, lottoList)
        resultView.printLottoStatistics(statistics)
    }
}
