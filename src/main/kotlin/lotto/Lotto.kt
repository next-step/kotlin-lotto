package lotto

class Lotto(
    private val lottoNumbers: Set<Int>,
) {

    init {
        require(lottoNumbers.size == 6) { "로또 숫자는 6개입니다." }
        lottoNumbers.forEach { checkNumberInRange(it) }
    }

    fun matchNumberCount(other: Lotto) =
        lottoNumbers.intersect(other.lottoNumbers).size

    private fun checkNumberInRange(number: Int) {
        require(number in 1..45) { "로또 숫자 범위는 1~45입니다." }
    }
}
