package lotto.service

import lotto.domain.LottoFactory
import lotto.domain.LottoMoney
import lotto.domain.LottoRepository
import lotto.domain.RandomLottoNumberGenerator

object LottoService {

    fun purchase(inputMoney: Int): LottoResponses {
        val money = LottoMoney(inputMoney)
        val purchaseLottos = LottoFactory.createLottoList(money, RandomLottoNumberGenerator)

        LottoRepository.saveAll(purchaseLottos)

        return LottoResponses(purchaseLottos.map { LottoResponse(it.lottoNumbers.map { lottoNumber -> lottoNumber.number }) })
    }

    fun calculateResult(winningLottoNumbers: List<Int>, bonusNumber: Int): LottoResultResponse {
        val winningLotto = LottoFactory.createWinningLotto(winningLottoNumbers, bonusNumber)
        val purchaseLottos = LottoRepository.findAll()

        val (ranks, profit) = winningLotto.calculateProfit(purchaseLottos)

        return LottoResultResponse(ranks, profit)
    }
}
