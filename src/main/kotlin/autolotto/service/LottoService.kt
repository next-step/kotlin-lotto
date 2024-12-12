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
        val lottos = lottoRepository.findAll()

        val resultMap =
            mutableMapOf(
                Prize.THREE to 0,
                Prize.FOUR to 0,
                Prize.FIVE to 0,
                Prize.BONUS to 0,
                Prize.SIX to 0,
            )

        lottos.forEach { lotto ->
            val (matchCount, hasBonus) = lotto.compareWithWinningNumbers(winningLottoNumber)
            Prize.fromMatchCount(matchCount, hasBonus)?.let { prize ->
                resultMap[prize] = resultMap.getOrDefault(prize, 0) + 1
            }
        }

        return resultMap
    }

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val LOTTO_TAKE_NUMBER = 6
    }
}
