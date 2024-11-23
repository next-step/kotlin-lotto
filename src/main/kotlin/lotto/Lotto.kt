package lotto

data class Lotto(
    private val numbers: List<Int>,
) {
    init {
        require(numbers.size == 6) { "로또 번호는 6개여야 합니다." }
    }
}