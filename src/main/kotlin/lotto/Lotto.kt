package lotto

class Lotto(val numbers: List<Int>) {
    init {
        validateLottoNumbers()
    }

    private fun validateLottoNumbers() {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "로또에 적힌 숫자는 6개입니다" }
        require(numbers.all { it in LOTTO_START_NUMBER..LOTTO_END_NUMBER }) { "로또에는 1 ~ 45 사이의 숫자만 적힐 수 있습니다" }
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
        private const val LOTTO_START_NUMBER = 1
        private const val LOTTO_END_NUMBER = 45
    }
}
