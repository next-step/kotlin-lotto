package lotto.controller

import lotto.domain.InputParser
import lotto.domain.LottoGenerator
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoNumbersList
import lotto.domain.LottoPrice
import lotto.domain.LottoRank
import lotto.domain.LottoResult
import lotto.view.InputView
import lotto.view.ResultView

object Controller {
    fun start() {
        val amount = inputAmount()
        val lottoCount = amount.count()
        ResultView.printLottoCount(lottoCount)
        generateLottoNumbers(lottoCount)
        ResultView.printLottoNumbersList(LottoNumbersList.getList())

        val winningNumbers = inputWinningNumber()
        val lottoResult = makeLottoResult(winningNumbers)
        printLottoResult(lottoResult, amount)
    }

    private fun printLottoResult(lottoResult: LottoResult, amount: LottoPrice) {
        ResultView.printLottoResultTitle()
        lottoResult.value.forEach {
            ResultView.printLottoResult(it.key.countOfMatch, it.key.winningMoney, lottoResult.getLottoRankCount(it.key))
        }
        val profitRate = lottoResult.calculateProfitRate(amount.value)
        ResultView.printProfitRate(profitRate)
    }

    private fun makeLottoResult(winningNumbers: LottoNumbers): LottoResult {
        val lottoResult = LottoResult(hashMapOf(LottoRank.FIFTH to 0, LottoRank.FOURTH to 0, LottoRank.THIRD to 0, LottoRank.FIRST to 0))
        LottoNumbersList.getLottoNumbers().forEach {
            val lottoNumbers = LottoNumbers(it.value)
            val lottoRank = lottoNumbers.getLottoRank(winningNumbers)
            lottoResult.add(lottoRank)
        }
        return lottoResult
    }

    private fun generateLottoNumbers(lottoCount: Int) {
        repeat(lottoCount) {
            val lottoNumbers = LottoGenerator.generate()
            LottoNumbersList.setLottoNumbers(lottoNumbers)
        }
    }

    private fun inputAmount(): LottoPrice {
        return try {
            LottoPrice(InputView.inputAmount())
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputAmount()
        }
    }

    private fun inputWinningNumber(): LottoNumbers {
        return try {
            val parsedInput = InputParser.parseWithDelimiter(InputView.inputWinningNumber())
            LottoNumbers(parsedInput.map { LottoNumber(it) })
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputWinningNumber()
        }
    }
}
