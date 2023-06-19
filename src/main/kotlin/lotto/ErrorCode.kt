package lotto

enum class ErrorCode(val msg: String) {
    INVALID_SIX_FORTY_FIVE_LOTTO_NUMBER("6/45 로또 숫자가 유효하지 않습니다"),
    INVALID_SIX_FORTY_FIVE_BONUS_LOTTO_NUMBER("6/45 로또 보너스 숫자가 유효하지 않습니다"),
    INVALIE_SIX_FORTY_FIVE_LOTTO_VERSION("유효하지 않은 로또 버전입니다.")
}
