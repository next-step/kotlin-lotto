package lotto.step4.domain

class LottoNumberPicker : NumberPicker {
    override fun pick(): List<LottoNumber> {
        return this.candidates.shuffled().take(6).sortedBy { it.number }
    }
}
