package autolotto.service

import autolotto.domain.LottoNumber
import autolotto.domain.WinningLottoNumber
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

    private fun generateLottoNumbers(): LottoNumber {
        val lottoNumbers =
            (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)
                .shuffled()
                .take(LOTTO_TAKE_NUMBER)
                .toSet()
        return LottoNumber(lottoNumbers)
    }

    fun getResult(winningLottoNumber: WinningLottoNumber): Map<Prize, Int> {
        val resultMap =
            mutableMapOf(
                Prize.THREE to 0,
                Prize.FOUR to 0,
                Prize.FIVE to 0,
                Prize.BONUS to 0,
                Prize.SIX to 0,
            )
        val lottos = lottoRepository.findAll()

        val comparisonResults =
            lottos.map { lotto ->
                comparisonWinningNumbers(lotto, winningLottoNumber)
            }

        val groupByMatchCount =
            comparisonResults.groupBy { it }.mapValues { it.value.size }.toMutableMap()

        val bonusCount =
            lottos.count { lotto ->
                comparisonWinningNumbers(lotto, winningLottoNumber) == 5 &&
                    winningLottoNumber.hasBonusNumber(lotto)
            }

        groupByMatchCount.forEach { (matchCount, count) ->
            val prize =
                Prize.fromMatchCount(
                    matchCount,
                    matchCount == BONUS_MATCHED_COUNT && bonusCount > NOT_MATCHED_BONUS_COUNT,
                )
            prize?.let {
                resultMap[it] = resultMap[it]!! + count
            }
        }

        return resultMap
    }

    private fun comparisonWinningNumbers(
        lotto: Lotto,
        winningLottoNumber: WinningLottoNumber,
    ): Int {
        val matchedNumbers = lotto.getNumbers().filter { winningLottoNumber.hasWinningNumber(it) }
        return matchedNumbers.count()
    }

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val LOTTO_TAKE_NUMBER = 6
        private const val BONUS_MATCHED_COUNT = 5
        private const val NOT_MATCHED_BONUS_COUNT = 0
    }
}
