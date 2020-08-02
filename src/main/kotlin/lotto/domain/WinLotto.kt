package lotto.domain

enum class WinLotto(private val index: Int, private val money: Int, var count: Int = 0) {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    companion object {
        fun plusCount(index: Int) {
            WinLotto.values()[index].count++
        }

        fun resultList() = WinLotto.values().filter { it.index >= 1 }.toList()
    }

    override fun toString(): String {
        return "${index}개 일치 (${money}원)- ${count}개\n"
    }
}
