package lotto.domain

class LottoNumber(private val number: Int) {
    override fun toString(): String {
        return number.toString()
    }

    override fun equals(other: Any?): Boolean {
        return when (other) {
            is LottoNumber -> {
                number == other.number
            }
            is Int -> {
                number == other
            }
            else -> {
                super.equals(other)
            }
        }
    }

    override fun hashCode(): Int {
        return number
    }
}
