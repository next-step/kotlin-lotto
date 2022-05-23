package lotto.agency

class LottoTicket() {

    private var _numbers: List<Int>

    init {
        this._numbers = takeLottoNumbers()
    }

    constructor(numbers: List<Int>) : this() {
        this._numbers = numbers
    }

    val numbers: List<Int>
        get() {
            return _numbers
        }

    fun countMatchWonLottoTicket(wonLottoTicket: LottoTicket): Int {
        return _numbers
            .sorted()
            .count { wonLottoTicket._numbers.contains(it) }
    }

    private fun takeLottoNumbers(): List<Int> {
        val grabs = mutableSetOf<Int>()
        while (grabs.size < 6) {
            grabs.add(LOTTO_NUMBER_RANGE.random())
        }

        return grabs.toList()
    }

    companion object {
        val LOTTO_NUMBER_RANGE = IntRange(1, 45)
    }
}
