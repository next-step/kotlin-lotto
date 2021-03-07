package lotto

class LottoNumber(private val value: Int) {

    init {
        check(isValidLottoNumberRange()) { "로또번호를 생성할 수 없는 값이다. value: $value" }
    }

    private fun isValidLottoNumberRange(): Boolean {
        return value in 1..45
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoNumber

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }
}
