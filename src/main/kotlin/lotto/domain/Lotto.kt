package lotto.domain

data class Lotto(val numbers: List<LottoNumber>) {

    init {
        require(numbers.size == 6) { "로또의 숫자 갯수가 부족합니다" }
    }

    fun contains(num: Int): Boolean {
        return this.numbers.any { it.num == num }
    }

    fun getSameCount(anotherLotto: Lotto): Int {
        return this.numbers.intersect(anotherLotto.numbers.toSet()).size
    }
}
