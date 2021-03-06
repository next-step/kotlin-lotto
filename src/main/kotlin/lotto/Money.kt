package lotto

data class Money(val value: Int) {
    init {
        require(value >= 0) {"로또 구매 금액은 0원보다 커야 합니다."}
    }

    constructor(input: String) : this(input.toInt())
}
