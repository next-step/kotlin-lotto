package lotto.domain

data class LottoNumber(val number: Int) {
    init {
        require(number in 1..45) { ERROR_MESSAGE }
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        private const val ERROR_MESSAGE: String = "로또 번호는 45를 넘을 수 없습니다."
    }
}
