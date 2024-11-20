package lotto.service

import lotto.domain.LOTTO_COST
import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoResults

class LottoService {
    fun getLottoNumbers(purchaseAmount: Int): List<Lotto> {
        val buyingLottoQuantity = purchaseAmount / LOTTO_COST
        return (1..buyingLottoQuantity).map { LottoGenerator().generate() }
    }

    fun getLottoResult(lottoList: List<Lotto>, winningNumbers: Lotto): LottoResults {
        return lottoList.map { lotto -> lotto.match(winningNumbers) }
            .groupingBy { it }
            .eachCount()
            .let { LottoResults.LottoResult.from(it) }
            .let { LottoResults(it) }
    }
}
