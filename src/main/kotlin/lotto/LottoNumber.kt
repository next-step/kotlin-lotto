package lotto

data class LottoNumber(private var value: Int = 0): Comparable<LottoNumber> {
    init {
        if (value == 0) {
            value = (1 .. 45).random()
        }
        if (value > 45 || value < 1) {
            throw IllegalArgumentException("로또 숫자는 1~45를 넘을 수 없습니다.")
        }
    }

    override fun toString(): String {
        return "$value"
    }

    override fun compareTo(other: LottoNumber): Int {
        return this.value.compareTo(other.value)
    }
}