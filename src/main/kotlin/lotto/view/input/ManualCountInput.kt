package lotto.view.input

class ManualCountInput(input: String?) {
    val count: Int

    init {
        require(!input.isNullOrBlank()) { "보너스 번호는 필수입니다." }

        count = input.toIntOrNull() ?: throw IllegalArgumentException("보너스 번호는 숫자여야 합니다.")
    }
}
