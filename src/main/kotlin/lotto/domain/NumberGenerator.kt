package lotto.domain

interface NumberGenerator {
    fun generateLottoNumber(): List<LottoNumber>
}
