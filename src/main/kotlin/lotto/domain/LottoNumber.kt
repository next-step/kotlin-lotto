package lotto.domain

data class LottoNumber(val value: Int) {
    override fun toString(): String {
        return value.toString()
    }
}
