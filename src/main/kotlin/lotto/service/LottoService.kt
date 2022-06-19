package lotto.service

import lotto.component.LottoFactory
import lotto.component.RandomLottoNumberGenerator
import lotto.domain.Lotto
import lotto.domain.LottoMoney
import lotto.domain.LottoNumber
import lotto.view.LottoResponse
import lotto.view.LottoResponses
import lotto.view.LottoResultResponse

object LottoService {

    fun purchase(inputMoney: Int): LottoResponses {
        val money = LottoMoney.from(inputMoney)
        val purchaseLottoList = LottoFactory.createLottoList(money, RandomLottoNumberGenerator)

        return LottoResponses(purchaseLottoList.map { LottoResponse(it.lottoNumbers.map { lottoNumber -> lottoNumber.number }) })
    }

    fun calculateResult(purchaseLottos: LottoResponses, winningLottoNumbers: List<Int>): LottoResultResponse {
        val winningLotto = LottoFactory.createWinningLotto(winningLottoNumbers)
        val purchaseLottos =
            purchaseLottos.lottos.map { Lotto.create(it.numbers.map { number -> LottoNumber.from(number) }) }

        val (matchCounts, profit) = winningLotto.calculateProfit(purchaseLottos)

        return LottoResultResponse(matchCounts, profit)
    }
}
