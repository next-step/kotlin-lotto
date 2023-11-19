package lotto.adapter

import lotto.application.LottoService
import lotto.application.LottoUseCase
import lotto.application.MatchWinningLottoCommand
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoResultMap
import lotto.view.InputView
import lotto.view.InputViewImpl
import lotto.view.ResultView
import lotto.view.ResultViewImpl

class LottoController(
    private val lottoUseCase: LottoUseCase = LottoService(),
    private val inputView: InputView = InputViewImpl(),
    private val resultView: ResultView = ResultViewImpl(),
) {
    fun run() {
        val userLotto = buyLotto()
        val winningLotto = getWinningLotto()

        val command = MatchWinningLottoCommand(userLotto, winningLotto)
        val lottoResultMap = lottoUseCase.matchWinningLotto(command)
        printLottoResult(lottoResultMap)

        val profitRate = lottoUseCase.calculateProfitRate(lottoResultMap)
        resultView.printProfitRate(ProfitRateDto.from(profitRate))
    }

    private fun buyLotto(): List<Lotto> {
        val priceToBuyLotto = inputView.inputPriceToBuyLotto()
        val userLotto = lottoUseCase.buy(priceToBuyLotto)
        resultView.printBoughtLotto(userLotto.map { LottoDto.from(it) })
        return userLotto
    }

    private fun getWinningLotto(): Lotto {
        val winningLottoNumbers = inputView.inputWinningLotto()
        return Lotto(winningLottoNumbers.map { LottoNumber(it) })
    }

    private fun printLottoResult(lottoResultMap: LottoResultMap) {
        val resultsDto = mutableListOf<LottoResultDto>()
        for (key in lottoResultMap.getLottoResultMapFilteredNotNone().keys) {
            val count = lottoResultMap.getLottoResultCount(key)
            resultsDto.add(LottoResultDto(key.description, key.price, count))
        }
        resultView.printLottoResults(resultsDto)
    }
}
