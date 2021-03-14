package lotto.vo

class LottoNumber private constructor(val number: Int) {
    companion object {
        private const val MIN_NUM = 1
        private const val MAX_NUM = 45
        val LOTTO_NUM_RANGE = (MIN_NUM..MAX_NUM)
        private val LOTTO_NUM_CACHE = LOTTO_NUM_RANGE.map { LottoNumber(it) }
        fun from(num: Int): LottoNumber {
            require(num in LOTTO_NUM_RANGE) { "로또 숫자 범위는 $MIN_NUM ~ $MAX_NUM 입니다" }
            return LOTTO_NUM_CACHE[num - 1]
        }

        fun from(strNum: String): LottoNumber {
            val num = strNum.toIntOrNull() ?: throw IllegalArgumentException("로또 번호는 정수형만 허용됩니다.")
            return from(num)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoNumber

        if (number != other.number) return false

        return true
    }

    override fun hashCode(): Int {
        return number
    }

    override fun toString(): String {
        return "$number"
    }
}
