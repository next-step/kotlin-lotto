package lotto.domain

class Lotto(val numbers: Set<LottoNumber>) {
    init {
        validateSize(numbers)
    }

    private fun validateSize(numbers: Set<LottoNumber>) {
        require(numbers.size == LOTTO_SIZE) { "로또 번호는 ${LOTTO_SIZE}개여야 합니다. 현재 전달된 개수는 ${numbers.size}개 입니다." }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Lotto

        return numbers == other.numbers
    }

    override fun hashCode(): Int {
        return numbers.hashCode()
    }

    companion object {
        private const val LOTTO_SIZE = 6
    }
}
