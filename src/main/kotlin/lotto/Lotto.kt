package lotto

class Lotto(val numbers: List<Int>) {

    fun countMatch(winningLotto: Lotto): Int {
        return numbers.intersect(winningLotto.numbers.toSet()).count()
    }

    override fun toString(): String {
        return "[${numbers.joinToString(", ")}]"
    }

    companion object {
        fun makeLotto(): Lotto {
            val numbers = (1..45).shuffled().take(6).sorted()
            return Lotto(numbers)
        }
    }
}
