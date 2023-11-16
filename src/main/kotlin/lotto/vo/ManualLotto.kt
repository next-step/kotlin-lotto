package lotto.vo

class ManualLotto() {
    private val numbers: List<LottoNumber> = listOf()

    fun initLottoNumbers(input: String) {
        LottoNumber.of(input.split(",")).forEach { addLottoNumber(it) }
    }

    private fun addLottoNumber(number: LottoNumber) {
        numbers.plus(number)
    }
}
