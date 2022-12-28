package lotto.domain

import lotto.model.LottoNumber
import lotto.model.LottoNumbers
import lotto.model.LottoNumbers.Companion.NUMBER_OF_LOTTO_DIGIT
import lotto.model.LottoPrize

class WinningLotto(
    val numbers: List<LottoNumber>,
) {
    init {
        require(numbers.size == NUMBER_OF_LOTTO_DIGIT) { "당첨 번호는 ${NUMBER_OF_LOTTO_DIGIT}개의 숫자여야 합니다." }
        require(numbers.distinct().size == NUMBER_OF_LOTTO_DIGIT) { "당첨 번호는 중복되는 숫자가 없어야 합니다." }
    }

    fun prize(lottoNumbers: LottoNumbers): LottoPrize? {
        return match(lottoNumbers).let(LottoPrize.Companion::of)
    }

    private fun match(lottoNumbers: LottoNumbers): Int =
        numbers.filter { lottoNumbers.contains(it) }.size
}
