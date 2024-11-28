package lotto.step4.domain

interface NumberPicker {
    fun pick(): List<LottoNumber>

    val candidates: List<LottoNumber>
        get() = (1..45).map { LottoNumber(it) }
}
