package lotto.domain

import lotto.domain.number.LottoNumber
import lotto.domain.number.LottoNumberGenerator
import lotto.domain.number.LottoNumberResult
import lotto.domain.result.LottoRank

class Lotto private constructor(
    val numbers: List<LottoNumber>,
) {

    fun calculateMatchCount(winningLotto: WinningLotto, hasBonusBall: Boolean): Int {
        val matchCount = numbers.intersect(winningLotto.getLottoNumbers()).size
        if (LottoRank.isSecondOrThirdRank(matchCount).not() && hasBonusBall) {
            return matchCount.inc()
        }
        return matchCount
    }

    fun hasBonusBall(number: LottoNumber): Boolean =
        numbers.contains(number)

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_PRICE = 1000

        fun createFromGenerator(lottoNumberGenerator: LottoNumberGenerator): Lotto {
            val lottoNumbers = lottoNumberGenerator.generate(
                count = LOTTO_NUMBER_COUNT
            )
            return Lotto(lottoNumbers)
        }

        fun createFromNumbers(numbers: List<Int>): LottoResult {
            val lottoNumberResults = numbers.map { LottoNumber.createResult(it) }
            if (hasFailLottoNumber(lottoNumberResults)) {
                return getFailLottoResult(lottoNumberResults)
            }
            val lottoNumbers = getNumbersFromSuccessResult(lottoNumberResults)
            return getLottoResult(lottoNumbers)
        }

        private fun hasFailLottoNumber(lottoNumberResults: List<LottoNumberResult>): Boolean =
            lottoNumberResults.any { it is LottoNumberResult.Failure }

        private fun getFailLottoResult(lottoNumberResults: List<LottoNumberResult>): LottoResult.Failure {
            val errorMessage = lottoNumberResults
                .filterIsInstance<LottoNumberResult.Failure>()
                .first()
                .errorMessage
            return LottoResult.Failure(errorMessage)
        }

        private fun getNumbersFromSuccessResult(lottoNumberResults: List<LottoNumberResult>): List<LottoNumber> {
            return lottoNumberResults
                .filterIsInstance<LottoNumberResult.Success>()
                .map { it.data }
                .sortedBy { it.value }
        }

        private fun getLottoResult(numbers: List<LottoNumber>): LottoResult {
            val countValidationResult = validateCount(numbers)
            return validateDuplication(countValidationResult)
        }

        private fun validateCount(numbers: List<LottoNumber>): LottoResult {
            if (numbers.size != LOTTO_NUMBER_COUNT) {
                return LottoResult.Failure("로또 번호는 ${LOTTO_NUMBER_COUNT}개여야 합니다.")
            }
            return LottoResult.Success(Lotto(numbers))
        }

        private fun validateDuplication(lottoResult: LottoResult): LottoResult {
            return when (lottoResult) {
                is LottoResult.Failure -> lottoResult
                is LottoResult.Success -> getDuplicateValidationResult(lottoResult.data)
            }
        }

        private fun getDuplicateValidationResult(lotto: Lotto): LottoResult {
            if (lotto.numbers.toSet().size != LOTTO_NUMBER_COUNT) {
                return LottoResult.Failure("로또 번호는 중복되지 않아야 합니다.")
            }
            return LottoResult.Success(lotto)
        }
    }
}
