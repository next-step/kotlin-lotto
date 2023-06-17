package next.step.lotto.domain

import kotlin.random.Random

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { "로또 번호는 1~45 사이여야 합니다." }
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45

        fun of(number: Int): LottoNumber = LottoNumber(number)

        fun random(): LottoNumber =
            LottoNumber(Random.nextInt(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER + 1))
    }
}