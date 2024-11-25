package lotto.domain

class WinningLotto(
    val lotto: Lotto,
    val bonusNumber: Number,
) {
    init {
        require(!lotto.contains(bonusNumber)) { LOTTO_DUPLICATE_BONUS_EXCEPTION_MESSAGE }
    }

    private fun Lotto.contains(number: Number): Boolean = this.getNumbersRawValues().contains(number.value)

    companion object {
        private const val LOTTO_DUPLICATE_BONUS_EXCEPTION_MESSAGE = "보너스 번호는 로또와 중복될 수 없습니다."
    }
}
