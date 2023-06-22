package lotto.domain

data class Lotto(val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { "로또의 숫자 갯수가 부족합니다" }
        require(numbers.all { it in 1..45 }) { "로또의 숫자는 1~45의 숫자만 가능합니다." }
    }

    fun contains(num: Int): Boolean {
        return this.numbers.contains(num)
    }

    fun getSameCount(anotherLotto: Lotto): Int {
        return this.numbers.count { anotherLotto.contains(it) }
    }
}
