package lotto.view.input.parser

class PurchaseAmountInputParser(range: IntRange) : IntInputParser(range) {
    private val priceOfOneLotto = range.first
    override fun parseValue(inputString: String?): Int {
        val parsedAmountValue = super.parseValue(inputString)
        require(parsedAmountValue % this.priceOfOneLotto == 0) {
            "잔돈이 남지 않게 ${this.priceOfOneLotto}의 배수로 입력해 주세요."
        }
        return parsedAmountValue
    }
}
