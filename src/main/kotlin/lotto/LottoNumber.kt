package lotto

data class LottoNumber(val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }
}
