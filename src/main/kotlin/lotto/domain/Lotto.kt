package lotto.domain

data class Lotto(val numbers: List<Int>) {
    fun contains(num: Int): Boolean {
        return this.numbers.contains(num)
    }

    fun getSameCount(anotherLotto: Lotto): Int {
        return this.numbers.count { anotherLotto.contains(it) }
    }
}
