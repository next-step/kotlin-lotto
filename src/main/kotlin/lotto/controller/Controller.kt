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
import java.util.EnumMap

object Controller {
    private const val DEFAULT_COUNT = 0
    private const val INCREASE_COUNT = 1

    fun start() {
        val amount = inputAmount()
        val numberOfLotto = amount.calculateNumberOfLotto()
        ResultView.printNumberOfLotto(numberOfLotto)
        generateLottoNumbers(numberOfLotto)
        ResultView.printLottoNumbersList(LottoNumbersList.getList())

        val winningNumbers = inputWinningNumber()
        val lottoResult = makeLottoResult(winningNumbers)
        printLottoResult(lottoResult, amount)
    }

    private fun printLottoResult(lottoResult: LottoResult, amount: LottoPrice) {
        ResultView.printLottoResultTitle()
        lottoResult.value.forEach {
            addLottoResult(it)
        }
        val profitRate = lottoResult.calculateProfitRate(amount.value)
        ResultView.printProfitRate(profitRate)
    }

    private fun addLottoResult(it: Map.Entry<LottoRank, Int>) {
        if (it.key != LottoRank.MISS) {
            ResultView.printLottoResult(it.key.countOfMatch, it.key.winningMoney, it.value)
        }
    }

    private fun makeLottoResult(winningNumbers: LottoNumbers): LottoResult {
        val lottoResult: EnumMap<LottoRank, Int> = initLottoResult()
        LottoNumbersList.getLottoNumbers().forEach {
            val lottoNumbers = LottoNumbers(it.value)
            val lottoRank = winningNumbers.getLottoRank(lottoNumbers)
            lottoResult[lottoRank] = lottoResult.getOrDefault(lottoRank, DEFAULT_COUNT) + INCREASE_COUNT
        }
        return LottoResult(lottoResult)
    }

    private fun initLottoResult(): EnumMap<LottoRank, Int> {
        val lottoResult: EnumMap<LottoRank, Int> = EnumMap(LottoRank::class.java)
        LottoRank.values().forEach {
            lottoResult[it] = DEFAULT_COUNT
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
