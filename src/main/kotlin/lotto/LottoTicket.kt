package lotto

@JvmInline
value class LottoTicket(val numbers: Collection<LottoNumber>) {

    init {
        require(numbers.size == SIZE) {
            "lottoTicket must be $SIZE numbers. but provided numbers(`$numbers`)"
        }
    }

    companion object {
        const val SIZE: Int = 6
    }
}
