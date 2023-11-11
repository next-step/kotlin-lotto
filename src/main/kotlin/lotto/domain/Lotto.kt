package lotto.domain

class Lotto(val numbers: Set<Int>) {
    init {
        require(numbers.size == 6) {
            "로또 번호는 6개만 가능합니다."
        }
    }

    fun match(otherLotto: Lotto, bonusBall: Int): Rank {
        val size = intersect(otherLotto).size
        val matchBonus = otherLotto.contains(bonusBall)
        return Rank.from(size, matchBonus)
    }

    private fun intersect(otherLotto: Lotto) = numbers.intersect(otherLotto.numbers)

    private fun contains(bonusBall: Int) = numbers.contains(bonusBall)
}
