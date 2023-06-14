package next.step.lotto.domain

import kotlin.random.Random

@JvmInline
value class LottoNumber(private val n: Int) {
    init {
        require(n in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { "로또 번호는 1~45 사이여야 합니다." }
    }

    fun number() = n

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45

        fun of(n: Int): LottoNumber = LottoNumber(n)

        fun random(): LottoNumber =
            LottoNumber(Random.nextInt(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER + 1))
    }
}