package lotto.domain

class LottoMaker {
    fun auto(): Lotto {
        val sixNumbers = LOTTO_NUMBERS.shuffled().take(6)
        return Lotto(sixNumbers)
    }

    companion object {
        private val LOTTO_NUMBERS: List<Int> = (1..45).toList()
    }
}
