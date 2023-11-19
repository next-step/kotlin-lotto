package lotto.domain

@JvmInline
value class LottoCount private constructor(
    val value: Int,
) {

    fun multiply(other: Int): Int =
        value * other

    fun plus(other: LottoCount): LottoCount =
        LottoCount(value + other.value)

    fun isZero(): Boolean =
        value == LOTTO_MIN_COUNT

    companion object {
        private const val LOTTO_MIN_COUNT = 0

        fun createResult(value: Int): LottoCountResult {
            if (value < LOTTO_MIN_COUNT) {
                return LottoCountResult.Failure("로또 개수는 ${LOTTO_MIN_COUNT}개 이상이어야 합니다.")
            }
            return LottoCountResult.Success(LottoCount(value))
        }

        fun from(value: Int): LottoCount {
            return (createResult(value) as LottoCountResult.Success).data
        }
    }
}
