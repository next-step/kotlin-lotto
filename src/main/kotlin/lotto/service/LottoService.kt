package lotto.service

import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.LottoNumberGenerator
import lotto.domain.LottoResult
import lotto.domain.Money
import lotto.domain.WinningLotto

object LottoService {
    private val lottoNumberGenerator = LottoNumberGenerator()
    fun generateLottos(money: Money): List<Lotto> {
        return LottoMachine.generateLotto(money, lottoNumberGenerator)
    }

    fun getLottoResult(lottos: List<Lotto>, winningLotto: WinningLotto): LottoResult {
        val resultMap = lottos.groupBy { winningLotto.calculatePrize(it) }
            .mapValues { it.value.size }
        return LottoResult(resultMap)
    }
}
