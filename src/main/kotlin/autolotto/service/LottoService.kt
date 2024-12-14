package autolotto.service

import autolotto.constants.LottoConstants.LOTTO_TAKE_NUMBER
import autolotto.constants.LottoConstants.MAX_LOTTO_NUMBER
import autolotto.constants.LottoConstants.MIN_LOTTO_NUMBER
import autolotto.domain.LottoMatchResult
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

        val matchResults =
            lottos.map { lotto ->
                lotto.compareWithWinningNumbers(winningLottoNumber)
            }

        val resultMap =
            mutableMapOf(
                Prize.THREE to 0,
                Prize.FOUR to 0,
                Prize.FIVE to 0,
                Prize.BONUS to 0,
                Prize.SIX to 0,
            )

        matchResults.forEach { result ->
            toPrize(result, resultMap)
        }

        return resultMap
    }

    private fun toPrize(
        result: LottoMatchResult,
        resultMap: MutableMap<Prize, Int>,
    ) {
        result.toPrize()?.let { prize ->
            resultMap[prize] = resultMap.getOrDefault(prize, 0) + 1
        }
    }
}
