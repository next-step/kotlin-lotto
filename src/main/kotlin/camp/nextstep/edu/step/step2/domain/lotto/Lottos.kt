package camp.nextstep.edu.step.step2.domain.lotto

import camp.nextstep.edu.step.step2.domain.number.Number
import camp.nextstep.edu.step.step2.domain.result.LottoMatch
import java.util.stream.Collectors

class Lottos(
    val lottos: List<Lotto>
) {

    init {
        require(lottos.isNotEmpty()) { "로또는 1개 이상이어야 합니다." }
    }

    fun isContainLottoNumbers(numbers: List<Number>): Boolean {
        return lottos.contains(Lotto(numbers = numbers))
    }

    fun checkLottoNumbersByWinningLotto(winningLotto: WinningLotto): List<LottoMatch> {
        return lottos.map { lotto ->
            val matchNumbers = lotto.countMatch(winningLotto.winningLotto)
            val matchBonus = lotto.countMatchBonus(winningLotto.bonusNumber)
            LottoMatch.of(matchNumbers, matchBonus)
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
