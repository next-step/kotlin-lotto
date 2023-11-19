package lotto

data class LottoTicket(val numbers: List<Int>) {
    init {
        numbers.forEach {
            require(it in 1..45) { "로또 번호는 1 ~ 45 사이의 숫자만 가능합니다." }
        }
    }

    fun isNumberMatched(number: Int): Boolean {
        return numbers.contains(number)
    }

    companion object {
        fun generate(randomNumber: RandomNumber = LottoRandomNumber): LottoTicket {
            return LottoTicket(randomNumber.generate())
        }
    }
}
