package camp.nextstep.edu.step.step2.domain.lotto

import camp.nextstep.edu.step.step2.domain.result.LottoMatch
import java.util.stream.Collectors

class Lottos(
    val lottos: List<Lotto>
) {

    init {
        require(lottos.isNotEmpty()) { "로또는 1개 이상이어야 합니다." }
    }

    fun checkLottoNumbersByWinningLotto(winningLotto: WinningLotto): List<LottoMatch> {
        val lottoMatchResults = mutableListOf<LottoMatch>()

        for (lotto in lottos) {
            val matchNumbers = lotto.countMatch(winningLotto.winningLotto)
            val matchBonus = lotto.countMatchBonus(winningLotto.bonusNumber)
            lottoMatchResults.add(LottoMatch.of(matchNumbers, matchBonus))
        }
        return lottoMatchResults
    }

    fun getLottoElements(): List<List<Int>> {
        return lottos.stream()
            .map { lotto -> lotto.getNumberElements() }
            .collect(Collectors.toList())
    }

    fun getLottoSize(): Int {
        return lottos.size
    }

}
