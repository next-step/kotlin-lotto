package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_MAX
import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_MIN

class Lotto(val numbers: List<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "로또 번호는 ${LOTTO_NUMBER_SIZE}개만 가능합니다." }
        require(numbers.toSet().size == LOTTO_NUMBER_SIZE) { "로또 번호는 중복될 수 없습니다." }
        require(numbers.all { it.number in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX }) { "로또 번호는 1~45 사이의 숫자만 가능합니다." }
    }

    companion object {
        const val LOTTO_PRICE = 1000
        private const val LOTTO_NUMBER_SIZE = 6

        fun auto(): Lotto {
            return Lotto((LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX).toList().shuffled().take(LOTTO_NUMBER_SIZE).sorted().map(::LottoNumber))
        }
    }
}
