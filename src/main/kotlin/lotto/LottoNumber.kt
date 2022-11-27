package lotto

data class LottoNumber(private var value: Int = 0): Comparable<LottoNumber> {
    init {
        if (value == 0) {
            value = (1 .. 45).random()
        }
    }

    override fun toString(): String {
        return "$value"
    }

    override fun compareTo(other: LottoNumber): Int {
        return this.value.compareTo(other.value)
    }
}