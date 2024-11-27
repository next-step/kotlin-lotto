package lotto.domain

@JvmInline
value class BonusNumber(val number: Int) {
    init {
        require(number in 1..45) { INPUT_BONUS_NUMBER_EXCEPTION_MESSAGE }
    }

    companion object {
        private const val INPUT_BONUS_NUMBER_EXCEPTION_MESSAGE = "보너스 볼은 1과 45 사이의 숫자여야 합니다."
    }
}
