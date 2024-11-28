package lotto.step3.domain

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in 1..45) { "로또 번호는 1부터 45까지의 숫자여야 합니다. [number=$number]" }
    }

    override fun toString(): String {
        return number.toString()
    }
}
