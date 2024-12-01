package autolotto.service

import autolotto.entity.Lotto
import autolotto.enums.prize.Prize
import autolotto.repository.LottoRepository

class LottoService(private val lottoRepository: LottoRepository) {
    fun start(gameCount: Int): List<Lotto> {
        repeat(gameCount) {
            lottoRepository.save(Lotto(generateLottoNumbers()))
        }
        return lottoRepository.findAll()
    }

    private fun generateLottoNumbers(): Set<Int> {
        return (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)
            .shuffled()
            .take(LOTTO_TAKE_NUMBER)
            .toSet()
    }

    fun getResult(winnersNumbers: List<Int>): Map<Prize, Int> {
        val resultMap =
            mutableMapOf(
                Prize.THREE to 0,
                Prize.FOUR to 0,
                Prize.FIVE to 0,
                Prize.SIX to 0,
            )
        val lottos = lottoRepository.findAll()
        val comparisonWinningNumbers =
            lottos.map { lotto -> comparisonWinningNumbers(lotto, winnersNumbers) }
                .groupBy { it }.mapValues { it.value.size }.toMutableMap()
        resultMap.forEach { (key, value) ->
            resultMap[key] = (comparisonWinningNumbers[key.matchCount] ?: 0) + value
        }
        return resultMap
    }

    private fun comparisonWinningNumbers(
        lotto: Lotto,
        winnersNumbers: List<Int>,
    ): Int {
        val matchedNumbers = lotto.getNumbers().filter { winnersNumbers.contains(it) }
        return matchedNumbers.count()
    }

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val LOTTO_TAKE_NUMBER = 6
    }
}
