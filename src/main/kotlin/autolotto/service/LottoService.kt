package autolotto.service

import autolotto.entity.Lotto
import autolotto.repository.LottoRepository
import kotlin.random.Random

class LottoService(private val lottoRepository: LottoRepository) {
    fun start(gameCount: Int): List<Lotto> {
        repeat(gameCount) {
            lottoRepository.save(Lotto(generateLottoNumbers()))
        }
        return lottoRepository.findAll()
    }

    private fun generateLottoNumbers(): Set<Int> {
        return generateSequence { Random.nextInt(45) + 1 }
            .distinct()
            .take(6)
            .toSet()
    }

    fun getWinnerInfo(winnersNumbers: List<Int>): Map<Int, Int> {
        val resultMap = mutableMapOf(
            3 to 0,
            4 to 0,
            5 to 0,
            6 to 0
        )
        val lottos = lottoRepository.findAll()
        val comparisonWinningNumbers =
            lottos.map { lotto -> comparisonWinningNumbers(lotto, winnersNumbers) }
                .groupBy { it }.mapValues { it.value.size }.toMutableMap()
        resultMap.forEach { (key, value) ->
            comparisonWinningNumbers[key] = (resultMap[key] ?: 0) + value
        }
        return resultMap
    }

    private fun comparisonWinningNumbers(
        lotto: Lotto,
        winnersNumbers: List<Int>,
    ): Int {
        val matchedNumbers = lotto.lottoGame.filter { winnersNumbers.contains(it) }
        return matchedNumbers.count()
    }
}
