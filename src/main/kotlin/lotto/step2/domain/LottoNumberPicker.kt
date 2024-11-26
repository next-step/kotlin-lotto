package lotto.step2.domain

class LottoNumberPicker : NumberPicker {
    override fun pick(): List<Int> {
        return this.candidates.shuffled().take(6).sorted()
    }
}
