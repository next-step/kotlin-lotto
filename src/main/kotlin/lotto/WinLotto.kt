package lotto

class WinLotto {
    val winLotto: Lotto

    constructor(input: String?) {
        if (input.isNullOrBlank()) throw IllegalArgumentException("뭐라도 입력하세요")

        this.winLotto = Lotto.ofManual(input)
    }

    fun matchCount(lotto: Lotto): Int {
        return winLotto.numbers.intersect(lotto.numbers.toSet()).size
    }
}
