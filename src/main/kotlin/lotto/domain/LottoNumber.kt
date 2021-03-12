package lotto.domain

data class LottoNumber(val value: Int) {

    init {
        checkValidateLottoNumber(value)
    }

    override fun toString(): String {
        return value.toString()
    }

    private fun checkValidateLottoNumber(number: Int) {
        if(number !in 1..45) throw IllegalArgumentException("로또 번호는 1부터 45까지이다.")
    }
}
