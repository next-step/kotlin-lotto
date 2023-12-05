package lotto.domain.model

import lotto.view.InputView

@JvmInline
value class SelfLottoNumberCount private constructor(private val value: Int) {

    init {
        require(value >= MIN_SELF_LOTTO_NUMBER_COUNT) {
            "수동으로 구매할 로또 개수는 ${MIN_SELF_LOTTO_NUMBER_COUNT}보다 같거나 커야 합니다."
        }
    }

    fun toInt() = value

    companion object {
        private const val MIN_SELF_LOTTO_NUMBER_COUNT = 0
        fun from(count: Int) = SelfLottoNumberCount(count)
    }
}
