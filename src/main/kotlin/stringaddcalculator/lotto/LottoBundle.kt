package stringaddcalculator.lotto

class LottoBundle(
    private val bundle: List<Lotto>
) {
    init {
        require(bundle.isNotEmpty()) { "로또는 하나 이상 존재해야 합니다" }
    }
}
