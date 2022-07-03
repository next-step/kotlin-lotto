package lotto.service

import lotto.domain.LottoMoney
import lotto.domain.LottoRepository
import lotto.domain.LottoStore
import lotto.domain.RandomLottoNumberGenerator

object LottoService {

    fun purchase(inputManualLottos: List<List<Int>>, inputMoney: Int): LottoResponses {
        val money = LottoMoney(inputMoney)
        val (remainMoney, manualLottos) = LottoStore.buyManualLottos(money, inputManualLottos)
        val purchaseLottos = LottoStore.buyLottos(remainMoney, RandomLottoNumberGenerator)

        LottoRepository.saveAll(manualLottos + purchaseLottos)

        return LottoResponses(
            manualLottos.map { LottoResponse(it.lottoNumbers.map { lottoNumber -> lottoNumber.number }) },
            purchaseLottos.map { LottoResponse(it.lottoNumbers.map { lottoNumber -> lottoNumber.number }) }
        )
    }

    fun calculateResult(winningLottoNumbers: List<Int>, bonusNumber: Int): LottoResultResponse {
        val winningLotto = LottoStore.createWinningLotto(winningLottoNumbers, bonusNumber)
        val purchaseLottos = LottoRepository.findAll()

        val (ranks, profit) = winningLotto.calculateProfit(purchaseLottos)

        return LottoResultResponse(ranks, profit)
    }
}
