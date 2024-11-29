package autolotto.valid

interface ValidatorStrategy<T> {
    fun isValid(value: T): Boolean
    fun getErrorMessage(): String
}

class NumberValidatorStrategy : ValidatorStrategy<String> {
    override fun isValid(value: String): Boolean = value.toIntOrNull() != null
    override fun getErrorMessage(): String = "숫자 형식이 아닙니다. 숫자를 입력해 주세요."
}

class PositiveNumberValidatorStrategy : ValidatorStrategy<Int> {
    override fun isValid(value: Int): Boolean = value >= 0
    override fun getErrorMessage(): String = "양수만 입력 가능합니다."
}

class LottoAmountValidatorStrategy : ValidatorStrategy<Int> {
    private val LOTTO_AMOUNT = 1000
    override fun isValid(value: Int): Boolean = value >= LOTTO_AMOUNT && value % LOTTO_AMOUNT == 0
    override fun getErrorMessage(): String = "돈은 1000원 단위로만 입력 가능합니다."
}

class WinningNumberValidatorStrategy : ValidatorStrategy<List<Int>> {
    override fun isValid(value: List<Int>): Boolean {
        return value.stream().allMatch { v -> v >= 0 }
    }
    override fun getErrorMessage(): String = "잘못된 로또 번호 형식입니다."
}