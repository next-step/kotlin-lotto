package lotto.view.input

class ManualCountInput(input: String?) {
    val lottoCount: Int

    init {
        require(!input.isNullOrBlank()) { "보너스 번호는 필수입니다." }

        lottoCount = input.toIntOrNull() ?: throw IllegalArgumentException("보너스 번호는 숫자여야 합니다.")
    }
}
