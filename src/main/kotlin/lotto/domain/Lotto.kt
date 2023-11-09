package lotto.domain

class Lotto(val numbers: Set<Int>) {
    init {
        require(numbers.size == 6) {
            "로또 번호는 6개만 가능합니다."
        }
    }

    fun match(otherLotto: Lotto): Rank {
        val size = intersect(otherLotto).size
        return Rank.from(size, true)
    }

    private fun intersect(otherLotto: Lotto) = numbers.intersect(otherLotto.numbers)
}
