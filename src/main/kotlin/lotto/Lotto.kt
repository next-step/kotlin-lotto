package lotto

data class Lotto(val numbers: Set<Int>) {
    init {
        validateSize()
        validateNumberRange()
    }

    private fun validateSize() {
        require(numbers.size == 6) { "로또 번호는 6개여야 합니다. 현재 전달된 개수는 ${numbers.size}개 입니다." }
    }

    private fun validateNumberRange() {
        require(!numbers.any { it < 1 || it > 45 }) { "로또 번호는 1~45 내의 숫자여야 합니다." }
    }
}
