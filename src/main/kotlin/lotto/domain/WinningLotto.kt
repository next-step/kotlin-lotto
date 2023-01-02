package lotto.domain

import lotto.domain.LottoNumbers.Companion.NUMBER_OF_LOTTO_DIGIT
import lotto.model.LottoNumber
import lotto.model.Rank

class WinningLotto private constructor(
    private val numbers: List<LottoNumber>,
    private val bonusNumber: LottoNumber,
) {
    init {
        require(numbers.size == NUMBER_OF_LOTTO_DIGIT) { "당첨 번호는 ${NUMBER_OF_LOTTO_DIGIT}개의 숫자여야 합니다." }
        require(numbers.distinct().size == NUMBER_OF_LOTTO_DIGIT) { "당첨 번호는 중복되는 숫자가 없어야 합니다." }
        require(!numbers.contains(bonusNumber)) { "당첨 번호와 보너스 번호는 중복되면 안됩니다." }
    }

    fun rank(lottoNumbers: LottoNumbers): Rank? {
        val matchCount = match(lottoNumbers)
        val bonusMatch = lottoNumbers.contains(bonusNumber)
        return Rank.of(matchCount, bonusMatch)
    }

    private fun match(lottoNumbers: LottoNumbers): Int =
        numbers.filter { lottoNumbers.contains(it) }.size

    companion object {
        operator fun invoke(numbers: List<Int>, bonusNumber: Int): WinningLotto =
            WinningLotto(numbers.map(::LottoNumber), LottoNumber(bonusNumber))
    }
}
