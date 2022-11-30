package lotto.domain

data class Lotto(val numbers: Set<LottoNumber>) {

    val value = krw

    init {
        require(numbers.size == 6)
    }

    companion object {
        val krw = KRW(1000)
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
