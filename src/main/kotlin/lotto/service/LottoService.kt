package lotto.service

import lotto.domain.Amount
import lotto.domain.LottoMatchResult
import lotto.domain.LottoNumber
import lotto.domain.LottoNumber.Companion.LOTTO_TAKE_NUMBER
import lotto.domain.LottoNumber.Companion.MAX_LOTTO_NUMBER
import lotto.domain.LottoNumber.Companion.MIN_LOTTO_NUMBER
import lotto.domain.WinningLottoNumber
import lotto.entity.Lotto
import lotto.entity.LottoInfo
import lotto.enums.prize.Prize
import lotto.repository.LottoRepository

class LottoService(private val lottoRepository: LottoRepository) {
    fun start(
        amount: Amount,
        lottoManualNumbers: List<LottoNumber>,
    ): Lotto {
        val manualLotto = lottoManualNumbers.map { LottoInfo(it) }
        val autoLotto = mutableListOf<LottoInfo>()
        repeat(amount.lottoGameCount) {
            autoLotto.add(LottoInfo(generateLottoNumbers()))
        }
        lottoRepository.save(Lotto(manualLotto, autoLotto))
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
        val lotto = lottoRepository.findAll()
        val lottoInfos = lotto.getTotalLottoInfos()
        val matchResults =
            lottoInfos.map { lottoInfo ->
                lottoInfo.compareWithWinningNumbers(winningLottoNumber)
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
