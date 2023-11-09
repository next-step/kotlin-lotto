package lotto.model

data class LottoNumbers(
    private val values: LinkedHashSet<LottoNumber>,
) {
    init {
        require(values.size == 6) { "6개의 원소가 필요하지만 [${values.size}] 의 원소가 입력 되었습니다" }
    }

    constructor(values: List<Int>) : this(LinkedHashSet(values.map { LottoNumber(it) }.sortedBy { it.value }))
    constructor(values: IntArray) : this(values.toList())

    override fun toString(): String {
        return values.map { it.value }
            .joinToString(prefix = "[", postfix = "]", separator = ", ")
    }

    fun countOfMatchNumbers(other: LottoNumbers): Int {
        return other
            .values
            .asSequence()
            .filter { this.values.contains(it) }
            .count()
    }

    companion object {
        fun any(): LottoNumbers {
            return LottoNumbers(LottoNumber.any6Numbers())
        }
    }
}
