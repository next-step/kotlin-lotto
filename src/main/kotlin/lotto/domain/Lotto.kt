package lotto.domain

data class Lotto(val numbers: List<LottoNumber>) {

    init {
        require(numbers.size == LOTTO_SIZE) { LOTTO_SIZE_EXCEPTION }
    }

    fun contains(num: LottoNumber): Boolean {
        return this.numbers.any { it == num }
    }

    fun getSameCount(anotherLotto: Lotto): Int {
        return this.numbers.intersect(anotherLotto.numbers.toSet()).size
    }

    companion object {
        private const val LOTTO_SIZE = 6
        private const val LOTTO_SIZE_EXCEPTION = "로또의 숫자 갯수가 부족합니다"
    }
}
