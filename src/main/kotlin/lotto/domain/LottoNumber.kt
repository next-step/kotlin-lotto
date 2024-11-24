package lotto.domain

@JvmInline
value class LottoNumber private constructor(val value: Int) {
    init {
        require(value in 1..45)
    }

    companion object {
        private val lottoNumbers: MutableMap<Int, LottoNumber> = mutableMapOf()

        fun get(lottoNumber: Int): LottoNumber =
            lottoNumbers[lottoNumber] ?: LottoNumber(lottoNumber).apply {
                lottoNumbers[lottoNumber] = this
            }
    }
}
