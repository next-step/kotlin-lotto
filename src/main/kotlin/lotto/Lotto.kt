package lotto

class Lotto(vararg numbers: Int) {
    val numbers: Set<Int> = numbers.toSet()

    init {
        require(this.numbers.size == 6) { "로또는 유일한 숫자 6개로 구성해야합니다." }
    }

    fun matchedCount(other: Lotto): Int {
        return numbers.filter { it in other.numbers }.size
    }

    fun judge(winningLotto: WinningLotto): Prize {
        return Prize.SECOND
    }

    companion object {
        fun random(): Lotto {
            val randomNumbers = (0..45).shuffled().subList(0, 6).toList().toIntArray()
            return Lotto(*randomNumbers)
        }
    }
}
