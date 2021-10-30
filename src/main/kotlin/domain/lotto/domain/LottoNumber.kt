package domain.lotto.domain

@JvmInline
value class LottoNumber private constructor(private val lottoNumber: Int) {
    companion object {
        fun of(lottoNumber: Int): LottoNumber = LottoNumber(lottoNumber)
    }
}
