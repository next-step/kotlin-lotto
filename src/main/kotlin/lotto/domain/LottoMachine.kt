package lotto.domain

class LottoMachine {
    fun generateAuto(): Lotto {
        return Lotto(listOf(1, 2, 3, 4, 5, 6))
    }
}
