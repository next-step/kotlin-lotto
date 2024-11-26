package lotto

data class Lotto(val values: Set<LottoNumber>) {
    constructor(values: List<Int>) : this(values.map { LottoNumber(it) }.toSet())

    init {
        require(values.size == LOTTO_SIZE) { "로또는 ${LOTTO_SIZE}개의 숫자로 이루어져야 합니다. 입력값: $values" }
    }

    fun match(other: Lotto): Int {
        return values.intersect(other.values).size
    }

    fun contains(lottoNumber: LottoNumber): Boolean {
        return values.contains(lottoNumber)
    }

    companion object {
        const val LOTTO_SIZE = 6

        fun from(listOf: List<Int>): Lotto {
            return Lotto(listOf.map { LottoNumber(it) }.toSet())
        }
    }
}
