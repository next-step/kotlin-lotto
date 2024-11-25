package lotto

class BonusNumber(
    value: String?,
) {
    val value: LottoNumber

    init {
        requireNotNull(value) { "보너스 볼 입력은 필수입니다." }
        this.value = try {
            LottoNumber(value.toInt())
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("보너스 볼은 문자가 될 수 없습니다.")
        }
    }
}