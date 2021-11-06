package lotto.domain

data class LottoNumber(
    val number: Int
) {
    override fun toString(): String {
        return number.toString()
    }
}
