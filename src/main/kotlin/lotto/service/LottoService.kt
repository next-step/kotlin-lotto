package lotto.service

import WinningLotto
import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoMoney
import lotto.domain.LottoResults

class LottoService {
    fun getLottoNumbers(purchaseAmount: Int): List<Lotto> {
        val lottoMoney = LottoMoney(purchaseAmount)
        val buyingLottoQuantity = lottoMoney.calculateQuantity()
        return (1..buyingLottoQuantity).map { LottoGenerator().generate() }
    }

    fun getLottoResult(lottoList: List<Lotto>, winningNumbers: WinningLotto): LottoResults {
        return lottoList.map { lotto -> lotto.match(winningNumbers) }
            .groupingBy { it }
            .eachCount()
            .let { LottoResults.LottoResult.from(it) }
            .let { LottoResults(it) }
    }
}
