package lotto

object LottoPolicy {
    private const val FIRST_LOTTO_NUMBER = 1
    private const val LAST_LOTTO_NUMBER = 45

    val LOTTO_NUMBER_RANGE = FIRST_LOTTO_NUMBER..LAST_LOTTO_NUMBER
    const val LOTTO_PRICE = 1_000

    fun validateBonusNumber(bonusNumber: Int) {
        if (bonusNumber < FIRST_LOTTO_NUMBER || bonusNumber > LAST_LOTTO_NUMBER) {
            throw IllegalArgumentException("보너스 번호는 ${FIRST_LOTTO_NUMBER}이상, $LAST_LOTTO_NUMBER 이하 숫자 입니다 - `$bonusNumber")
        }
    }
}
