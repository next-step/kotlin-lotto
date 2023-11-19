package lotto

@JvmInline
value class LottoNumber private constructor(val value: Int) {
    init {
        require(value in MIN_NUMBER..MAX_NUMBER) {
            "로또 번호는 $MIN_NUMBER~$MAX_NUMBER 사이여야 합니다."
        }
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45

        val cache = (MIN_NUMBER..MAX_NUMBER).associateWith { LottoNumber(it) }

        fun of(value: Int): LottoNumber {
            return cache[value] ?: throw IllegalArgumentException("로또 번호는 $MIN_NUMBER~$MAX_NUMBER 사이여야 합니다.")
        }
    }
}
