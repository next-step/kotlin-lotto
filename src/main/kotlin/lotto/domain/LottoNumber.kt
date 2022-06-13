package lotto.domain

private const val MIN_LOTTO_NUMBER = 1
private const val MAX_LOTTO_NUMBER = 45

@JvmInline
value class LottoNumber private constructor(
    val value: Int,
) {
    init {
        require(value in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { "로또 숫자를 1 ~ 45 사이의 숫자만 허용됩니다." }
    }

    companion object {
        val ALL = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).map { LottoNumber(it) }

        fun valueOf(lottoNumber: Int) = ALL.getOrNull(lottoNumber - 1)
            ?: throw IllegalArgumentException("허용되지 않은 로또 숫자입니다.")
    }
}
