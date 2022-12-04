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
        val lottoNumbersList = generateLottoNumbers(numberOfLotto)
        ResultView.printLottoNumbersList(lottoNumbersList.getList())

        val winningNumbers = inputWinningNumber()
        val bonusNumber = inputBonusNumber()
        val lottoResult = makeLottoResult(winningNumbers, lottoNumbersList)
        ResultView.printLottoResultTitle()
        lottoResult.value.forEach {
            ResultView.printLottoResult(it.key.countOfMatch, it.key.winningMoney, it.value)
        }
        val profitRate = lottoResult.calculateProfitRate(amount.value)
        ResultView.printProfitRate(profitRate)
    }

    private fun makeLottoResult(winningNumbers: LottoNumbers, lottoNumbersList: LottoNumbersList): LottoResult {
        val lottoResult: EnumMap<LottoRank, Int> = initLottoResult()
        lottoNumbersList.value.forEach {
            val lottoNumbers = LottoNumbers(it.value)
            val lottoRank = winningNumbers.getLottoRank(lottoNumbers)
            lottoResult[lottoRank] = lottoResult.getOrDefault(lottoRank, DEFAULT_COUNT) + INCREASE_COUNT
        }
        lottoResult.remove(LottoRank.MISS)
        return LottoResult(lottoResult)
    }

    private fun initLottoResult(): EnumMap<LottoRank, Int> {
        val lottoResult: EnumMap<LottoRank, Int> = EnumMap(LottoRank::class.java)
        LottoRank.values().forEach {
            lottoResult[it] = DEFAULT_COUNT
        }
        return lottoResult
    }

    private fun generateLottoNumbers(lottoCount: Int): LottoNumbersList {
        val lottoNumbersList = mutableListOf<LottoNumbers>()
        repeat(lottoCount) {
            val lottoNumbers = LottoGenerator.generate()
            lottoNumbersList.add(lottoNumbers)
        }
        return LottoNumbersList(lottoNumbersList)
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

    private fun inputBonusNumber(): LottoNumber {
        return try {
            LottoNumber(InputView.inputBonusNumber())
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputBonusNumber()
        }
    }
}
