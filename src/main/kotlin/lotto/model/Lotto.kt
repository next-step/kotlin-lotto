package lotto.model

class Lotto(
    private val lotto: List<LottoNumber>
) {

    init {
        validateUnique(lotto)
        validateNumberCount(lotto)
    }

    fun findMatchedNumberCount(other: Lotto) = other.lotto.count { lotto.contains(it) }

    override fun toString(): String {
        return "$lotto"
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6

        private fun validateUnique(numbers: List<LottoNumber>) =
            require(numbers.size == numbers.toSet().size) { "로또에 중복되는 번호가 있을 수 없습니다." }

        private fun validateNumberCount(numbers: List<LottoNumber>) =
            require(numbers.size == LOTTO_NUMBER_COUNT) { "로또 번호 개수는 ${LOTTO_NUMBER_COUNT}개 이어야 합니다." }
    }
}
