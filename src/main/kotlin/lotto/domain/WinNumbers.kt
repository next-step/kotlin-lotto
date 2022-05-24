package lotto.domain

data class WinNumbers(val value: List<LottoNumber>, val bonus: LottoNumber) {

    init {
        require(value.toSet().size == value.size) { "중복된 숫자가 있습니다" }
        require(bonus.value !in value.map { it.value }) { "보너스 숫자는 당첨 번호와 달라야 합니다" }
    }

    fun matchCount(lotto: Lotto): Int = value.count { lotto.numbers.contains(it) }

    fun hasBonus(lotto: Lotto): Boolean = bonus in lotto.numbers

    companion object {
        fun of(numbers: List<Int>, bonus: Int): WinNumbers = WinNumbers(numbers.map(::LottoNumber), LottoNumber(bonus))
    }
}
