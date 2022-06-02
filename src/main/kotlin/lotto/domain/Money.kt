package lotto.domain

class Money(private val _price: Int) {
    val price
        get() = _price

    init {
        require(_price >= LottoMachine.TICKET_PRICE) { ERROR_NOT_ENOUGH_MONEY }
    }

    operator fun div(value: Int): Int = _price / value

    companion object {
        private const val ERROR_NOT_ENOUGH_MONEY = "로또를 구입하기 위해서는 최소 1000원 이상 입력해야 한다."
    }
}
