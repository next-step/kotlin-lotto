package lotto.exception

class IllegalPurchaseException(message: String = "구입 금액은 양수이어야 합니다.") : RuntimeException(message)
