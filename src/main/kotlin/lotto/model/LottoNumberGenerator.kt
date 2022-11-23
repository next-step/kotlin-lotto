package lotto.model

interface LottoNumberGenerator {
    fun pick(): List<LottoNumber>
}
