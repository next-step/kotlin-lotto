package lotto.domain

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value in 1..45) {
            "로또 번호는 1부터 45 사이여야 합니다. 잘못된 로또번호 = $value"
        }
    }

    companion object {

        private val cache = (1..45).associateWith { LottoNumber(it) }

        fun of(value: Int): LottoNumber {
            return cache[value]
                ?: throw IllegalArgumentException(
                    "로또 번호는 1부터 45 사이여야 합니다. 잘못된 로또번호 = $value",
                )
        }
    }
}
