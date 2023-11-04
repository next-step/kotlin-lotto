package lotto.domain

class Lotto(val numbers: Set<Int>) {
    init {
        require(numbers.size == 6) {
            "로또 번호는 6개만 가능합니다."
        }
    }

    fun match(otherLotto: Lotto): Rank {
        val size = numbers.intersect(otherLotto.numbers).size
        return Rank.of(size)
    }
}
