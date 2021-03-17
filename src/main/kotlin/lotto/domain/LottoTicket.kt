package lotto.domain

import lotto.domain.LottoNumber.Companion.MAX_LOTTO_NUMBER
import lotto.domain.LottoNumber.Companion.MIN_LOTTO_NUMBER

class LottoTicket(val value: Set<LottoNumber>) {

    init {
        checkValidateLottoTicket()
    }

    private fun checkValidateLottoTicket() {
        if (value.size != LENGTH_OF_LOTTO) throw RuntimeException("로또의 숫자는 6개가 존재해야 합니다.")
    }

    companion object {
        private val LENGTH_OF_LOTTO = 6

        fun generateAuto(): LottoTicket {
            val numbers = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)
                .shuffled()
                .take(LENGTH_OF_LOTTO)
                .sorted()

            return LottoTicket(
                numbers.map { number ->
                    LottoNumber.from(number)
                }.toSet()
            )
        }

        fun generateManual(numbers: List<Int>): LottoTicket {
            return LottoTicket(
                numbers.map { number ->
                    LottoNumber.from(number)
                }.toSet()
            )
        }
    }
}
