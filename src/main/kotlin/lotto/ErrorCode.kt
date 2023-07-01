package lotto

enum class ErrorCode(val msg: String) {
    INVALID_SIX_FORTY_FIVE_LOTTO_NUMBER("6/45 로또 숫자가 유효하지 않습니다"),
    INVALID_SIX_FORTY_FIVE_LOTTO_NUMBER_DUPLICATE("6/45 로또 숫자 값이 중복 값을 가집니다"),
    INVALID_SIX_FORTY_FIVE_BONUS_LOTTO_NUMBER("6/45 로또 보너스 숫자가 유효하지 않습니다"),
    INVALID_SIX_FORTY_FIVE_LOTTO_PURCHASE_PRICE("6/45 로또의 최소 구입 금액은 1000원 입니다"),
    INVALID_SIX_FORTY_FIVE_LOTTO_COUNT("로또 숫자는 0 이상의 정수를 가질 수 있습니다")
}
