package lotto.domain

data class LottoNumber(private val number: Int) {
    init {
        require(number <= 45) { ERROR_MESSAGE }
    }
    fun getNumber(): Int {
        return number
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        private const val ERROR_MESSAGE: String = "로또 번호는 45를 넘을 수 없습니다."
    }
}
