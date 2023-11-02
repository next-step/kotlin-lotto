package lotto

class LottoManager(purchased: String) {
    val purchased: Int
    private val lottoList: MutableList<List<Int>> = mutableListOf()

    init {
        validateInput(purchased)
        this.purchased = purchased.toInt()

        repeat(this.purchased / 1000) {
            lottoList.add(generateLotto())
        }
    }

    private fun validateInput(input: String) {
        require(Regex("^[0-9]+$").matches(input)) { "구입 금액은 숫자로만 표현된 양수여야 합니다." }
        require(input.toInt() > 0) { "구입 금액은 숫자로만 표현된 양수여야 합니다." }
        require(input.toInt() % 1000 == 0) { "구입 금액은 1000원 단위여야 합니다." }
    }

    private fun generateLotto(): List<Int> {
        return (1..45).shuffled().take(6).sorted()
    }

    fun getLottoList(): List<List<Int>> {
        return lottoList
    }
}
