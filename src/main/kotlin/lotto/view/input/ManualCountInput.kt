package lotto.view.input

data class ManualCountInput(val lottoCount: Int) {
    constructor(input: String) : this(input.toInt())

    companion object {
        private fun String.toInt(): Int {
            return this.toIntOrNull() ?: throw IllegalArgumentException("금액은 숫자야여 합니다.")
        }
    }
}
