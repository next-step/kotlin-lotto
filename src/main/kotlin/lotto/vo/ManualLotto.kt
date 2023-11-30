package lotto.vo

class ManualLotto() {
    var numbers: List<LottoNumber> = listOf()

    fun initLottoNumbers(input: String): ManualLotto {
        val input = input.split(",")
        require(input.size == 6) { "로또 번호는 6개여야 합니다." }
        LottoNumber.of(input).forEach { addLottoNumber(it) }
        return this
    }

    fun addLottoNumbers(numbers: List<LottoNumber>): ManualLotto {
        numbers.forEach { addLottoNumber(it) }
        return this
    }

    private fun addLottoNumber(number: LottoNumber) {
        require(!numbers.contains(number)) { "로또 번호는 중복될 수 없습니다." }
        numbers = numbers.plus(number)
    }
}
