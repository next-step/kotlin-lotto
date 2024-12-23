package lotto

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in 1..45)
    }

    override fun toString(): String {
        return number.toString()
    }
}
