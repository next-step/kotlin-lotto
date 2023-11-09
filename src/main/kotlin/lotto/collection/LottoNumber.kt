package lotto.collection

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in NUMBER_RANGE) { "로또 번호는 ${NUMBER_RANGE.first}~${NUMBER_RANGE.last} 사이여야 합니다." }
    }
    companion object {
        val NUMBER_RANGE = 1..45
    }
}
